package com.tifa.framework.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tifa.framework.web.pojo.Orderitem;
import com.tifa.framework.web.service.OrderitemService;
import com.tifa.framework.web.mapper.OrderitemMapper;
import org.springframework.stereotype.Service;

/**
* @author haruluya
* @description 针对表【orderitem】的数据库操作Service实现
* @createDate 2022-03-29 17:15:20
*/
@Service
public class OrderitemServiceImpl extends ServiceImpl<OrderitemMapper, Orderitem>
    implements OrderitemService{

}




