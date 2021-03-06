package com.tifa.framework.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tifa.framework.web.pojo.Productimage;
import com.tifa.framework.web.service.ProductimageService;
import com.tifa.framework.web.mapper.ProductimageMapper;
import org.springframework.stereotype.Service;

/**
* @author haruluya
* @description 针对表【productimage】的数据库操作Service实现
* @createDate 2022-03-29 17:15:21
*/
@Service
public class ProductimageServiceImpl extends ServiceImpl<ProductimageMapper, Productimage>
    implements ProductimageService{

}




