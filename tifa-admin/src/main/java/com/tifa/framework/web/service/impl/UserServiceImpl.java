package com.tifa.framework.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tifa.framework.web.pojo.User;
import com.tifa.framework.web.service.UserService;
import com.tifa.framework.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author haruluya
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-03-29 17:15:21
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
}




