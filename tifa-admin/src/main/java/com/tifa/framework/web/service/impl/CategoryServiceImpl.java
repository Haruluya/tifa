package com.tifa.framework.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tifa.framework.web.pojo.Category;
import com.tifa.framework.web.service.CategoryService;
import com.tifa.framework.web.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author haruluya
* @description 针对表【category】的数据库操作Service实现
* @createDate 2022-03-29 17:15:21
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

}




