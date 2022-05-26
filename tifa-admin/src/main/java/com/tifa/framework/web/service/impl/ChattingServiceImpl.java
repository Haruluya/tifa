package com.tifa.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tifa.framework.web.pojo.Chatting;
import com.tifa.service.ChattingService;
import com.tifa.mapper.ChattingMapper;
import org.springframework.stereotype.Service;

/**
* @author 24558
* @description 针对表【chatting】的数据库操作Service实现
* @createDate 2022-05-23 08:45:00
*/
@Service
public class ChattingServiceImpl extends ServiceImpl<ChattingMapper, Chatting>
    implements ChattingService{

}




