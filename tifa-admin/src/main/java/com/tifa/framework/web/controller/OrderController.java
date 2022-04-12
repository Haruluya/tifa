package com.tifa.framework.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tifa.framework.web.pojo.Order;
import com.tifa.framework.web.pojo.Orderitem;
import com.tifa.framework.web.service.impl.OrderServiceImpl;
import com.tifa.framework.web.service.impl.OrderitemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/tifai/order_")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;



    @GetMapping("/pageData")
    public Page<Order> order_Data(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
        Page<Order> order_Page = new Page<>(pageNum,10);
        return orderService.page(order_Page,null);
    }



}
