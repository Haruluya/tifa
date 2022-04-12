package com.tifa.framework.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tifa.framework.web.pojo.Product;
import com.tifa.framework.web.pojo.Productimage;
import com.tifa.framework.web.service.impl.ProductServiceImpl;
import com.tifa.framework.web.service.impl.ProductimageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/tifai/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;



    @GetMapping("/pageData")
    public Page<Product> productData(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
        Page<Product> productPage = new Page<>(pageNum,10);
        return productService.page(productPage,null);
    }



}
