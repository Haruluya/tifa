package com.tifa.framework.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tifa.framework.web.pojo.Property;
import com.tifa.framework.web.service.PropertyService;
import com.tifa.framework.web.mapper.PropertyMapper;
import org.springframework.stereotype.Service;

/**
* @author haruluya
* @description 针对表【property】的数据库操作Service实现
* @createDate 2022-03-29 17:15:20
*/
@Service
public class PropertyServiceImpl extends ServiceImpl<PropertyMapper, Property>
    implements PropertyService{

}




