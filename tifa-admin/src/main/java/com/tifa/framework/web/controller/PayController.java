package com.tifa.framework.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tifa.framework.web.pojo.Order;
import com.tifa.framework.web.pojo.Orderitem;
import com.tifa.framework.web.pojo.PaymentBO;
import com.tifa.framework.web.service.PayService;
import com.tifa.framework.web.service.impl.OrderServiceImpl;
import com.tifa.framework.web.service.impl.ProductServiceImpl;
import com.tifa.framework.web.util.JSONData;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *  支付宝支付，控制器
 *
 * @author wangziyang
 * */
@RestController
@RequestMapping(value = "tifai/pay")
@AllArgsConstructor
public class PayController {

    private PayService payService;

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private ProductServiceImpl productService;
    /**
     *  下单支付
     * */
    @PostMapping(value = "/confirm" , produces = {"text/html;charset=UTF-8"})
    public Object pay (@RequestBody JSONData jsonData) throws Exception {
        PaymentBO paymentBO = new PaymentBO();
        paymentBO.setSubject((String) (jsonData.get("subject")));
        paymentBO.setTotal((Double)(jsonData.get("price")));



        Order order = new Order();
        order.setCreatedate(new Timestamp(System.currentTimeMillis()));
        order.setStatus("create");
        order.setUid((Integer) (jsonData.get("uid")));
        order.setAid((Integer) (jsonData.get("aid")));
        order.setUsermessage((String) (jsonData.get("pids")));
        order.setBid(
                productService.getById(
                        Integer.parseInt(((String)(jsonData.get("pids"))).split("#")[0])
                ).getBid()
        );
        orderService.save(order);
        return payService.pay(paymentBO);
    }


    /**
     *  支付成功的回调
     * */
    @PostMapping(value = "/fallback")
    public Object fallback (HttpServletRequest request) {

        Order order = new Order();
        List<Order> list = orderService.list();
        order.setOid(list.get(list.size()-1).getOid());
        order.setPaydate(new Timestamp(System.currentTimeMillis()));
        order.setStatus("paid");

        orderService.updateById(order);

        return "success";
    }


}