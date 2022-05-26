package com.tifa.framework.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tifa.framework.web.pojo.Rating;
import com.tifa.framework.web.service.RatingService;
import com.tifa.framework.web.mapper.RatingMapper;
import org.springframework.stereotype.Service;

/**
* @author 24558
* @description 针对表【rating】的数据库操作Service实现
* @createDate 2022-05-23 08:57:41
*/
@Service
public class RatingServiceImpl extends ServiceImpl<RatingMapper, Rating>
    implements RatingService{

}




