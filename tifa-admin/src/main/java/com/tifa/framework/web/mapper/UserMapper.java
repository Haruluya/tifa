package com.tifa.framework.web.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tifa.framework.web.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
* @author haruluya
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-03-29 17:15:21
* @Entity com.tifa.framework.web.pojo.User
*/

@Repository
public interface UserMapper extends BaseMapper<User> {
    @Select("select table_name from information_schema.TABLES where TABLE_SCHEMA='tmall'")
    public String[] getAllTableNames();


}




