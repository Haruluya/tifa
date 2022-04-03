package com.tifa.framework.web.mapper;
import com.tifa.framework.web.pojo.User;
import org.apache.ibatis.annotations.Param;

import com.tifa.framework.web.pojo.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author haruluya
* @description 针对表【category】的数据库操作Mapper
* @createDate 2022-03-29 17:15:21
* @Entity com.tifa.framework.web.pojo.Category
*/
@Repository
public interface CategoryMapper extends BaseMapper<Category> {
    List<Category> selectAll();
}




