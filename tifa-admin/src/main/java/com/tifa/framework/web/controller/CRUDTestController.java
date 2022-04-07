package com.tifa.framework.web.controller;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tifa.framework.web.mapper.UserMapper;
import com.tifa.framework.web.pojo.*;
import com.tifa.framework.web.service.ProductService;
import com.tifa.framework.web.service.impl.*;
import com.tifa.framework.web.util.AjaxReturnValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haruluya
 * 测试CRUD的控制类。
 */
@RestController
@RequestMapping("/tifai/CRUD")
public class CRUDTestController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private ProductimageServiceImpl productimageService;
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private PropertyServiceImpl propertyService;
    @Autowired
    private PropertyvalueServiceImpl propertyvalueService;
    @Autowired
    private ReviewServiceImpl reviewService;
    @Autowired
    private OrderitemServiceImpl orderitemService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/userData")
    public Page<User> userData(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
        Page<User> userPage = new Page<>(pageNum,10);

        return userService.page(userPage,null);
    }

    @GetMapping("/categoryData")
    public Page<Category> categoryData(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
        Page<Category> categoryPage = new Page<>(pageNum,10);
        System.out.println(pageNum);
        return categoryService.page(categoryPage,null);
    }

    @GetMapping("/propertyData")
    public Page<Property> propertyData(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
        Page<Property> propertyPage = new Page<>(pageNum,10);
        return propertyService.page(propertyPage,null);
    }

    @GetMapping("/productData")
    public Page<Product> productData(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
        Page<Product> productPage = new Page<>(pageNum,10);
        return productService.page(productPage,null);
    }


    @GetMapping("/propertyvalueData")
    public Page<Propertyvalue> propertyvalueData(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
        Page<Propertyvalue> propertyvaluePage = new Page<>(pageNum,10);
        return propertyvalueService.page(propertyvaluePage,null);
    }

    @GetMapping("/productimageData")
    public Page<Productimage> productimageData(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
        Page<Productimage> productimagePage = new Page<>(pageNum,10);
        return productimageService.page(productimagePage,null);
    }

    @GetMapping("/reviewData")
    public Page<Review> reviewData(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
        Page<Review> reviewPage = new Page<>(pageNum,10);
        return reviewService.page(reviewPage,null);
    }

    @GetMapping("/order_Data")
    public Page<Order> order_Data(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
        Page<Order> order_Page = new Page<>(pageNum,10);
        return orderService.page(order_Page,null);
    }

    @GetMapping("/orderitemData")
    public Page<Orderitem> orderitemData(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
        Page<Orderitem> orderitemPage = new Page<>(pageNum,10);
        return orderitemService.page(orderitemPage,null);
    }

    @GetMapping("/tableNames")
    public String[] tableNames(Model model){
        String[] result = userMapper.getAllTableNames();
        System.out.println(result);
        return result;
    }

}
