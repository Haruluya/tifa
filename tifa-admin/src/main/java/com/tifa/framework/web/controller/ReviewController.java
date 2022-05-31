package com.tifa.framework.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tifa.framework.web.pojo.Rating;
import com.tifa.framework.web.pojo.Review;
import com.tifa.framework.web.service.impl.RatingServiceImpl;
import com.tifa.framework.web.service.impl.ReviewServiceImpl;
import com.tifa.framework.web.util.AjaxReturnValue;
import com.tifa.framework.web.util.JSONData;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tifai/review")
public class ReviewController {

    @Autowired
    private ReviewServiceImpl reviewService;

    @Autowired
    private RatingServiceImpl ratingService;


    @PostMapping("/getReviewData")
    public AjaxReturnValue reviewData(@RequestBody JSONData jsonData){
        List<Review> list = reviewService.list(
                new QueryWrapper<Review>()
                        .eq("pid",(Integer)(jsonData.get("pid")))
        );
        return AjaxReturnValue.success(list);
    }

    @PostMapping("/addReview")
    public AjaxReturnValue addReview(@RequestBody Review review){
        reviewService.saveOrUpdate(review);
        return AjaxReturnValue.success();
    }
}
