//package com.tifa.framework.web.controller;
//
//
//import com.tifa.framework.web.pojo.Recommendation;
//import com.tifa.framework.web.pojo.User;
//import com.tifa.framework.web.service.RecService;
//import com.tifa.framework.web.service.impl.UserServiceImpl;
//import com.tifa.framework.web.util.AjaxReturnValue;
//import com.tifa.framework.web.util.JSONData;
//import com.tifa.framework.web.util.TifaConstant;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// *
// * @author haruluya
// * @date 2022/4/16
// */
//@RestController
//@RequestMapping("/tifai/rec")
//public class RecSystemController {
//    @Autowired
//    private RecService recService;
//    @Autowired
//    private UserServiceImpl userService;
//    //日志。
//    private final static Logger logger = Logger.getLogger(RecSystemController.class.getName());
//
//    /**
//     * 获取商品的相似商品列表。
//     * @param id    商品id
//     * @return    相似商品列表
//     */
//    @GetMapping("/itemcf/{id}")
//    @ResponseBody
//    public AjaxReturnValue getSimProductsByItemCF(@PathVariable("id")int id) {
//        List<Recommendation> recommendations = recService.getSimRecommendationsByItemCF(id);
//        JSONData jsonData = new JSONData();
//        jsonData.put("products",recService.getProductsByRecommendations(recommendations));
//        return AjaxReturnValue.success("ok",jsonData);
//    }
//
//    /**
//     * 获取热门推荐
//     * @param amount 热门商品数量。
//     * @return json
//     */
//    @GetMapping("/hotrec")
//    @ResponseBody
//    public AjaxReturnValue getHotProducts(@RequestParam(value = "amount",defaultValue = "10")int amount) {
//        List<Recommendation> recommendations = recService.getHotRecommendations(amount);
//        JSONData jsonData = new JSONData();
//        jsonData.put("products",recService.getProductsByRecommendations(recommendations));
//        return AjaxReturnValue.success("ok",jsonData);
//    }
//
//    /**
//     * 获取评分最高的商品
//     * @param amount 数量
//     * @return  product
//     */
//    @GetMapping("/mostrate")
//    @ResponseBody
//    public AjaxReturnValue getMostRatedProducts(@RequestParam(value = "amount",defaultValue = "10")int amount) {
//        List<Recommendation> recommendations = recService.getMostRatedProducts(amount);
//        JSONData jsonData = new JSONData();
//        jsonData.put("products",recService.getProductsByRecommendations(recommendations));
//        return AjaxReturnValue.success("ok",jsonData);
//    }
//    /**
//     * 基于内容的商品推荐。
//     * @param id 商品id
//     * @return  product
//     */
//    @GetMapping("/contentrec/{id}")
//    @ResponseBody
//    public AjaxReturnValue getSimProductsByContent(@PathVariable("id")int id) {
//        List<Recommendation> recommendations = recService.getSimRecommendationsByContent(id);
//        JSONData jsonData = new JSONData();
//        jsonData.put("products",recService.getProductsByRecommendations(recommendations));
//        return AjaxReturnValue.success("ok",jsonData);
//    }
//
//
//    /**
//     * 基于als的离线推荐。
//     * @param amount 数量
//     * @return  product
//     */
//    @GetMapping("/alsrec")
//    @ResponseBody
//    public AjaxReturnValue getALSRecProducts(@RequestParam(value = "amount",defaultValue = "10")int amount,@RequestParam("username")String username) {
//        int userid = userService.getIdByName(username);
//        List<Recommendation> recommendations = recService.getALSRecRecommendation(userid,amount);
//        JSONData jsonData = new JSONData();
//        jsonData.put("products",recService.getProductsByRecommendations(recommendations));
//        return AjaxReturnValue.success("ok",jsonData);
//    }
//
//    /**
//     * 实施推荐。
//     * @param amount 数量
//     * @return  product
//     */
//    @GetMapping("/onlinerec")
//    @ResponseBody
//    public AjaxReturnValue getOnlineRecProducts(@RequestParam(value = "amount",defaultValue = "10")int amount,@RequestParam("username")String username) {
//        int userid = userService.getIdByName(username);
//        List<Recommendation> recommendations = recService.getOnlineRecRecommendation(userid,amount);
//        JSONData jsonData = new JSONData();
//        jsonData.put("products",recService.getProductsByRecommendations(recommendations));
//        return AjaxReturnValue.success("ok",jsonData);
//    }
//
//
//    /**
//     * 用户评分动作处理。
//     * @param id    商品id
//     * @param score 分数
//     * @param username  用户名
//     * @return  boolean
//     */
////    @GetMapping("/rate/{id}")
////    @ResponseBody
////    public AjaxReturnValue rateToProduct(@PathVariable("id")int id, @RequestParam("score")Double score, @RequestParam("username")String username) {
////        User user = userService.getUserByName(username);
////        int userid = user.getId();
////        boolean complete = recService.storeRatingData(userid,id,score);
////        //埋点日志
////        if(complete) {
////            System.out.print("RatingRating:::::::::::");
////            logger.info(TifaConstant.TIFA_RATING_BEHAIVER_TAG + ":" + userid +"|"+ id +"|"+ score +"|"+ System.currentTimeMillis()/1000);
////        }
////        return AjaxReturnValue.success("ok");
////    }
//
//
//
//
//
//}
