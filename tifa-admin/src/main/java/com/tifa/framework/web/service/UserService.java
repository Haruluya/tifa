package com.tifa.framework.web.service;

import com.tifa.framework.web.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author haruluya
* @description 针对表【user】的数据库操作Service
* @createDate 2022-03-29 17:15:21
*/

public interface UserService extends IService<User> {

    /**
     * 获取数据库中所有表名。
     * @return 表名。
     */
    public String[] getAllTableNames();

    /**
     * 判断email是否在数据库中已经存在。
     * @return boolean。
     */
    public Boolean emailExisted(String name);

    /**
     * 验证用户信息是否正确。
     * @return
     */
    public Boolean userExisted(User loginData);

    /**
     * 通过name查询id。
     */
    public Integer getIdByName(String name);

    /**
     * 通过id查询name。
     */
    public String getNameById(Integer id);
}