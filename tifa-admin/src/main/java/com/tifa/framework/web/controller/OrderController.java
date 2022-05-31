package com.tifa.framework.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tifa.framework.web.pojo.Order;
import com.tifa.framework.web.pojo.Orderitem;
import com.tifa.framework.web.pojo.Product;
import com.tifa.framework.web.pojo.Productimage;
import com.tifa.framework.web.service.impl.OrderServiceImpl;
import com.tifa.framework.web.service.impl.OrderitemServiceImpl;
import com.tifa.framework.web.service.impl.ProductServiceImpl;
import com.tifa.framework.web.service.impl.ProductimageServiceImpl;
import com.tifa.framework.web.util.AjaxReturnValue;
import com.tifa.framework.web.util.JSONData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tifai/order_")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private ProductimageServiceImpl productimageService;

    @Autowired
    private ProductServiceImpl productService;


    @GetMapping("/pageData")
    public Page<Order> order_Data(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
        Page<Order> order_Page = new Page<>(pageNum,10);
        return orderService.page(order_Page,null);
    }

    @PostMapping("/orderData")
    public AjaxReturnValue orderData(@RequestBody JSONData jsonData){
        Integer uid = (Integer)(jsonData.get("uid"));
        String statu = (String) (jsonData.get("statu"));
        List<Order> data;

        if ("all".equals(statu)){
            data = orderService.list(
                    new QueryWrapper<Order>()
                            .eq("uid",uid)
            );
        }else{
            data = orderService.list(
                    new QueryWrapper<Order>()
                            .eq("uid",uid)
                            .eq("status",statu)
            );
        }

        ArrayList<Product> productData = new ArrayList<>();
        ArrayList<Productimage> productimages = new ArrayList<>();
        data.forEach((element)->{
            String[] products = element.getUsermessage().split("#");
            for (int i = 0; i < products.length; i++){
                productData.add(productService.getById(products[i]));
                productimages.add(productimageService.getById(products[i]));
            }
        });
        JSONData jsonData1 = new JSONData();
        jsonData1.put("ordersData",data);
        jsonData1.put("productData",productData);
        jsonData1.put("productImgData",productimages);
        return AjaxReturnValue.success(jsonData1);
    }

    @PostMapping("/confimDe")
    public AjaxReturnValue confimDe(@RequestBody JSONData jsonData) {

        Order order = new Order();
        order.setOid((Integer) (jsonData.get("oid")));
        order.setConfirmdate(new Timestamp(System.currentTimeMillis()));
        order.setStatus("comment");

        orderService.updateById(order);
        return AjaxReturnValue.success();
    }
    @PostMapping("/confirmDeto")
    public AjaxReturnValue confirmDeto(@RequestBody JSONData jsonData) {

        Order order = new Order();
        order.setOid((Integer) (jsonData.get("oid")));
        order.setDeliverydate(new Timestamp(System.currentTimeMillis()));
        order.setStatus("delivery");

        orderService.updateById(order);
        return AjaxReturnValue.success();
    }

    @PostMapping("/merchantOrders")
    public AjaxReturnValue merchantOrders(@RequestBody JSONData jsonData) {
        List<Order> data = orderService.list(
                new QueryWrapper<Order>()
                        .eq("bid",(Integer)(jsonData.get("uid")))
        );
        ArrayList<Product> productData = new ArrayList<>();
        ArrayList<Productimage> productimages = new ArrayList<>();
        data.forEach((element)->{
            String[] products = element.getUsermessage().split("#");
            for (int i = 0; i < products.length; i++){
                productData.add(productService.getById(products[i]));
                productimages.add(productimageService.getById(products[i]));
            }
        });
        JSONData jsonData1 = new JSONData();
        jsonData1.put("ordersData",data);
        jsonData1.put("productData",productData);
        jsonData1.put("productImgData",productimages);
        return AjaxReturnValue.success(jsonData1);
    }
}
