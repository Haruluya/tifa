package com.tifa.framework.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tifa.framework.web.pojo.Review;
import com.tifa.framework.web.service.impl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/tifai/review")
public class ReviewController {

    @Autowired
    private ReviewServiceImpl reviewService;



    @GetMapping("/pageData")
    public Page<Review> reviewData(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
        Page<Review> reviewPage = new Page<>(pageNum,10);
        return reviewService.page(reviewPage,null);
    }
}
