package com.tifa.framework.web.controller;




import com.tifa.framework.web.pojo.User;
import com.tifa.framework.web.pojo.res.Recommendation;
import com.tifa.framework.web.service.RecService;
import com.tifa.framework.web.service.impl.UserServiceImpl;
import com.tifa.framework.web.service.rec.ItemCFRecommendationRequest;
import com.tifa.framework.web.service.rec.ProductService;
import com.tifa.framework.web.util.AjaxReturnValue;
import com.tifa.framework.web.util.JSONData;
import com.tifa.framework.web.util.TifaConstant;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haruluya
 * @date 2022/4/16
 */
@RestController
@RequestMapping("/tifai/rec")
public class ProductRestApi {
    @Autowired
    private RecService recService;



    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ProductService productService;
    //日志。
    private final static Logger logger = Logger.getLogger(ProductRestApi.class.getName());

    /**
     * 获取商品的相似商品列表。
     * @param id    商品id
     * @return    相似商品列表
     */
    @GetMapping("/itemcf/{id}")
    @ResponseBody
    public AjaxReturnValue getSimProductsByItemCF(@PathVariable("id")int id) {
        List<Recommendation> recommendations = recService.getSimRecommendationsByItemCF(id);
        JSONData jsonData = new JSONData();
        jsonData.put("products",recService.getProductsByRecommendations(recommendations));
        return AjaxReturnValue.success("ok",jsonData);
    }

    /**
     * 获取热门推荐
     * @param amount 热门商品数量。
     * @return json
     */
    @GetMapping("/hotrec")
    @ResponseBody
    public AjaxReturnValue getHotProducts(@RequestParam(value = "amount",defaultValue = "10")int amount) {
        List<Recommendation> recommendations = recService.getHotRecommendations(amount);
        JSONData jsonData = new JSONData();
        jsonData.put("products",productService.getRecommendProducts(recommendations));
        return AjaxReturnValue.success("ok",jsonData);
    }

    /**
     * 获取评分最高的商品
     * @param amount 数量
     * @return  product
     */
    @GetMapping("/mostrate")
    @ResponseBody
    public AjaxReturnValue getMostRatedProducts(@RequestParam(value = "amount",defaultValue = "10")int amount) {
        List<Recommendation> recommendations = recService.getMostRatedProducts(amount);
        JSONData jsonData = new JSONData();
        jsonData.put("products",productService.getRecommendProducts(recommendations));
        return AjaxReturnValue.success("ok",jsonData);
    }
    /**
     * 基于内容的商品推荐。
     * @param id 商品id
     * @return  product
     */
    @GetMapping("/contentrec/{id}")
    @ResponseBody
    public AjaxReturnValue getSimProductsByContent(@PathVariable("id")int id) {
        List<Recommendation> recommendations = recService.getSimRecommendationsByContent(id);
        JSONData jsonData = new JSONData();
        jsonData.put("products",productService.getRecommendProducts(recommendations));
        return AjaxReturnValue.success("ok",jsonData);
    }


    /**
     * 基于als的离线推荐。
     * @param amount 数量
     * @return  product
     */
    @GetMapping("/alsrec")
    @ResponseBody
    public AjaxReturnValue getALSRecProducts(@RequestParam(value = "amount",defaultValue = "20")int amount,@RequestParam("userid")Integer userid) {
        List<Recommendation> recommendations = recService.getALSRecRecommendation(userid,amount);
        JSONData jsonData = new JSONData();
        if (recommendations == null){
            return this.getHotProducts(20);
        }
        jsonData.put("products",productService.getRecommendProducts(recommendations));
        return AjaxReturnValue.success("ok",jsonData);
    }

    /**
     * 实时推荐。
     * @param amount 数量
     * @return  product
     */
    @GetMapping("/onlinerec")
    @ResponseBody
    public AjaxReturnValue getOnlineRecProducts(@RequestParam(value = "amount",defaultValue = "10")int amount,@RequestParam("userid")Integer userid) {
        List<Recommendation> recommendations = recService.getOnlineRecRecommendation(userid,amount);
        JSONData jsonData = new JSONData();
        if (recommendations == null){
            jsonData.put("products",new ArrayList<>());
        }else {
            jsonData.put("products", recService.getProductsByRecommendations(recommendations));
        }
        return AjaxReturnValue.success("ok",jsonData);
    }


    /**
     * 基于物品的协同过滤
     * @param id
     * @return
     */
    @RequestMapping(value = "/itemcf/{id}", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public AjaxReturnValue getItemCFProducts(@PathVariable("id")int id) {
        List<Recommendation> recommendations = recService.getSimRecommendationsByItemCF(id);
        JSONData jsonData = new JSONData();
        jsonData.put("products",productService.getRecommendProducts(recommendations));
        return AjaxReturnValue.success(jsonData);
    }

    /**
     * 获取单个商品的信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/info/{id}", produces = "application/json", method = RequestMethod.GET )
    @ResponseBody
    public AjaxReturnValue getProductInfo(@PathVariable("id")int id) {
        return AjaxReturnValue.success(productService.findByProductId(id));
    }



    /**
     * 用户评分动作处理。
     * @param id    商品id
     * @param score 分数
     * @return  boolean
     */
    @GetMapping("/rate/{id}")
    @ResponseBody
    public AjaxReturnValue rateToProduct(@PathVariable("id")int id, @RequestParam("score")Double score, @RequestParam("userid")Integer userid) {
        boolean complete = recService.storeRatingData(userid,id,score);
        //埋点日志
        if(complete) {
            System.out.print("Person is RatingRating:::::::::::");
            logger.info(TifaConstant.TIFA_RATING_BEHAIVER_TAG + ":" + userid +"|"+ id +"|"+ score +"|"+ System.currentTimeMillis()/1000);
        }
        return AjaxReturnValue.success("ok");
    }





}
