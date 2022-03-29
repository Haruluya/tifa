package com.tifa.framework.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tifa.framework.web.pojo.Order;
import com.tifa.framework.web.service.OrderService;
import com.tifa.framework.web.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author haruluya
* @description 针对表【order_】的数据库操作Service实现
* @createDate 2022-03-29 17:15:21
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}




