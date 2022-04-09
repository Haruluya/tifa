package com.tifa.framework.web.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tifa.framework.web.pojo.Orderitem;
import com.tifa.framework.web.service.impl.OrderitemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tifai/orderitem")
public class OrderitemController {

    @Autowired
    private OrderitemServiceImpl orderitemService;

    @GetMapping("/pageData")
    public Page<Orderitem> orderitemData(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
        Page<Orderitem> orderitemPage = new Page<>(pageNum,10);
        return orderitemService.page(orderitemPage,null);
    }
}
