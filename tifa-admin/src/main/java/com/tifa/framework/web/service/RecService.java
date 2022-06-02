package com.tifa.framework.web.service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;



import com.tifa.framework.web.pojo.res.Rating;
import com.tifa.framework.web.pojo.res.Recommendation;
import com.tifa.framework.web.util.TifaConstant;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecService {
    @Autowired
    private MongoClient mongoClient;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RedisService redisService;

    private MongoCollection<Document> ratingCollection;

    /**
     * 获取最多评分的一些商品。
     * @param amount    数量
     * @return  recommendation
     */
    public List<Recommendation> getMostRatedProducts(int amount) {
        MongoCollection<Document> mostRatedProductsCollection = mongoClient.getDatabase(TifaConstant.MONGODB_DATABASE).getCollection(TifaConstant.HIGH_RATE_CLOUD_PRODUCTS);
        FindIterable<Document> documents = mostRatedProductsCollection.find().sort(Sorts.descending("count")).limit(amount);
        List<Recommendation> recommendations = new ArrayList<>();
        for (Document document : documents) {
            recommendations.add(new Recommendation(document.getInteger("productId"), 0D));
        }
        return recommendations;
    }


    /**
     * 获取近期热门推荐。
     * @param amount   数量
     * @return  Recommend包装对象
     */
    public List<Recommendation> getHotRecommendations(int amount) {
        //取时间排序前amount条。
        MongoCollection<Document> hotGoodsRecentlyCollection = mongoClient.getDatabase(TifaConstant.MONGODB_DATABASE).getCollection(TifaConstant.HIGH_RATE_RECENTLY_CLOUD_PRODUCTS);
        FindIterable<Document> documents = hotGoodsRecentlyCollection.find().sort(Sorts.descending("yearmonth")).limit(amount);
        List<Recommendation> recommendations = new ArrayList<>();
        for (Document document : documents) {
            recommendations.add(new Recommendation(document.getInteger("productId"), 0D));
        }
        return recommendations;
    }

    /**
     * 获取商品的相似商品。
     * @param id 商品id
     * @return  商品列表
     */
    public List<Recommendation> getSimRecommendationsByItemCF(int id) {
        MongoCollection<Document> itemCFProductsCollection = mongoClient.getDatabase(TifaConstant.MONGODB_DATABASE).getCollection(TifaConstant.ITEMCF_COLLECTION);
        Document document = itemCFProductsCollection.find(new Document("productId", id)).first();
        List<Recommendation> recommendations = new ArrayList<>();
        ArrayList<Document> recs = document.get("recs", ArrayList.class);
        for (Document recDoc : recs) {
            recommendations.add(new Recommendation(recDoc.getInteger("productId"), recDoc.getDouble("score")));
        }
        return recommendations;
    }

    /**
     * 基于内容的商品推荐。
     * @param id    商品id。
     * @return  推荐列表。
     */
    public List<Recommendation> getSimRecommendationsByContent(int id) {
        MongoCollection<Document> contentBasedProductsCollection = mongoClient.getDatabase(TifaConstant.MONGODB_DATABASE).getCollection(TifaConstant.CONTENTBASED_COLLECTION);
        Document document = contentBasedProductsCollection.find(new Document("productId", id)).first();
        List<Recommendation> recommendations = new ArrayList<>();
        if (document == null){
            return null;
        }
        ArrayList<Document> recs = document.get("recs", ArrayList.class);
        for (Document recDoc : recs) {
            recommendations.add(new Recommendation(recDoc.getInteger("productId"), recDoc.getDouble("score")));
        }
        return recommendations;
    }

    /**
     * 基于ALS的商品离线推荐。
     * @param userid 用户id
     * @param amount 商品数量
     * @return  推荐列表。
     */
    public List<Recommendation> getALSRecRecommendation(int userid,int amount) {
        MongoCollection<Document> userRecsCollection = mongoClient.getDatabase(TifaConstant.MONGODB_DATABASE).getCollection(TifaConstant.USER_RECS_COLLECTION);
        Document document = userRecsCollection.find(new Document("userId",userid)).first();
        List<Recommendation> recommendations = new ArrayList<>();
        if (document == null){
            return null;
        }
        ArrayList<Document> recs = document.get("recs", ArrayList.class);
        for (Document recDoc : recs) {
            recommendations.add(new Recommendation(recDoc.getInteger("productId"), recDoc.getDouble("score")));
        }
        return recommendations;
    }

    /**
     * 实时推荐。
     * @param userid    用户id
     * @param amount    商品数量
     * @return  推荐列表
     */
    public List<Recommendation> getOnlineRecRecommendation(int userid,int amount) {
        MongoCollection<Document> userRecsCollection = mongoClient.getDatabase(TifaConstant.MONGODB_DATABASE).getCollection(TifaConstant.ONLINE_RECS_COLLECTION);
        Document document = userRecsCollection.find(new Document("userId", userid)).first();
        List<Recommendation> recommendations = new ArrayList<>();
        if (document == null){
            return null;
        }
        ArrayList<Document> recs = document.get("recs", ArrayList.class);
        for (Document recDoc : recs) {
            recommendations.add(new Recommendation(recDoc.getInteger("productId"), recDoc.getDouble("score")));
        }

        return recommendations;
    }


    /**
     * 从Recommend中解包返回product对象。
     * @param recommendations   recommendation对象
     * @return  Product列表
     */
    public List<Integer> getProductsByRecommendations(List<Recommendation> recommendations){
        List<Integer> idList = new ArrayList<>();

        for (Recommendation rec: recommendations) {
            idList.add(rec.getProductId());

        }
        return idList;
//        return getProducts(ids);
    }

    /**
     * 初始化评分集合。
     * @return  评分集合
     */
    private MongoCollection<Document> getRatingCollection() {
        if (ratingCollection == null){
            ratingCollection = mongoClient.getDatabase(TifaConstant.MONGODB_DATABASE)
                    .getCollection(TifaConstant.DB_RATING_COLLECTION_NAME);
        }
        return ratingCollection;
    }

    /**
     * 存储评分记录。
     * @param userid    用户id
     * @param productid 产品id
     * @param score 分数
     * @return  状态码
     */
    public boolean storeRatingData(int userid, int productid,Double score) {
        Rating rating = new Rating(userid, productid, score);
        redisService.storeRatingToRedis(rating);
        if (ratingExist(rating.getUserId(), rating.getProductId())) {
            return updateRating(rating);
        } else {
            return newRating(rating);
        }
    }

    /**
     * 更新评价记录。
     * @param rating    评价记录
     * @return  状态码
     */
    private boolean updateRating(Rating rating) {
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.append("userId", rating.getUserId());
        basicDBObject.append("productId", rating.getProductId());
        getRatingCollection().updateOne(basicDBObject,
                new Document().append("$set", new Document("score", rating.getScore())));
        return true;
    }

    /**
     * 判断评分是否已经存在。
     * @param userId
     * @param productId
     * @return
     */
    private boolean ratingExist(int userId, int productId) {
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.append("userId", userId);
        basicDBObject.append("productId", productId);
        FindIterable<Document> documents = getRatingCollection().find(basicDBObject);
        if (documents.first() == null){
            return false;
        }
        return documentToRating(documents.first()) == null;
    }

    /**
     * document转换为rating对象。
     * @param document  documen
     * @return  rating
     */
    private Rating documentToRating(Document document) {
        Rating rating = null;
        try {
            rating = objectMapper.readValue(JSON.toJSONString(document), Rating.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rating;

    }


    /**
     * 新建rating对象。
     * @param rating rating
     * @return  状态码
     */
    private boolean newRating(Rating rating) {
        try {
            getRatingCollection().insertOne(Document.parse(objectMapper.writeValueAsString(rating)));
            return true;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return false;
        }
    }

}
