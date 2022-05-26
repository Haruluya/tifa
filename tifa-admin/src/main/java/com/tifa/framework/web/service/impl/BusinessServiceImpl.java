package com.tifa.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tifa.framework.web.pojo.Business;
import com.tifa.service.BusinessService;
import com.tifa.mapper.BusinessMapper;
import org.springframework.stereotype.Service;

/**
* @author 24558
* @description 针对表【business】的数据库操作Service实现
* @createDate 2022-05-23 08:45:00
*/
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business>
    implements BusinessService{

}




