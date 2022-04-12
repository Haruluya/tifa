package com.tifa.framework.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tifa.framework.web.pojo.Productimage;
import com.tifa.framework.web.service.impl.ProductimageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/tifai/productimage")
public class ProductimageController {
    @Autowired
    private ProductimageServiceImpl productimageService;

    @GetMapping("/pageData")
    public Page<Productimage> productimageData(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
        Page<Productimage> productimagePage = new Page<>(pageNum,10);
        return productimageService.page(productimagePage,null);
    }

}
