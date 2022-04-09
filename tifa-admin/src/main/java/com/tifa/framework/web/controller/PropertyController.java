package com.tifa.framework.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tifa.framework.web.pojo.Category;
import com.tifa.framework.web.pojo.Property;
import com.tifa.framework.web.pojo.Propertyvalue;
import com.tifa.framework.web.service.impl.CategoryServiceImpl;
import com.tifa.framework.web.service.impl.PropertyServiceImpl;
import com.tifa.framework.web.service.impl.PropertyvalueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tifai/property")
public class PropertyController {

    @Autowired
    private PropertyServiceImpl propertyService;






    @GetMapping("/pageData")
    public Page<Property> propertyData(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
        Page<Property> propertyPage = new Page<>(pageNum,10);
        return propertyService.page(propertyPage,null);
    }




}
