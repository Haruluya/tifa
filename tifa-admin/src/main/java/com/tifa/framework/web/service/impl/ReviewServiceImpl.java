package com.tifa.framework.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tifa.framework.web.pojo.Review;
import com.tifa.framework.web.service.ReviewService;
import com.tifa.framework.web.mapper.ReviewMapper;
import org.springframework.stereotype.Service;

/**
* @author haruluya
* @description 针对表【review】的数据库操作Service实现
* @createDate 2022-03-29 17:15:21
*/
@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review>
    implements ReviewService{

}




