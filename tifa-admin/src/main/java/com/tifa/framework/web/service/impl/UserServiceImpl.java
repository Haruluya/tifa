package com.tifa.framework.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    /**
     * 获取数据库所有表名。
     * @return 表名。
     */
    @Override
    public String[] getAllTableNames(){
        return baseMapper.getAllTableNames();
    }

    /**
     * 判断email是否在数据库中已经存在。
     * @return boolean。
     */
    @Override
    public Boolean uNameExisted(String name) {
        long count = this.count(
                new QueryWrapper<User>()
                        .eq("uname",name)
        );
        return count != 0;
    }

    @Override
    public Boolean userExisted(String name, String password) {
        long count = this.count(
                new QueryWrapper<User>()
                        .eq("uname",name)
                        .eq("password",password)
        );
        return count != 0;
    }

    @Override
    public Integer getIdByName(String name) {
        return this.getOne(
                new QueryWrapper<User>()
                .eq("uname",name)
        ).getUid();
    }

    @Override
    public String getNameById(Integer id) {
        return this.getOne(
                new QueryWrapper<User>()
                        .eq("uid",id)
        ).getUname();
    }



}




