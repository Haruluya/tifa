package com.tifa.framework.web.mapper;

import com.tifa.framework.web.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author haruluya
* @description 针对表【product】的数据库操作Mapper
* @createDate 2022-03-29 17:15:21
* @Entity com.tifa.framework.web.pojo.Product
*/
@Repository
public interface ProductMapper extends BaseMapper<Product> {

}




