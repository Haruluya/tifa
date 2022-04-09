package com.tifa.framework.web.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tifa.framework.web.pojo.Propertyvalue;
import com.tifa.framework.web.service.impl.PropertyvalueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tifai/propertyvalue")
public class PropertyvalueController {
    @Autowired
    private PropertyvalueServiceImpl propertyvalueService;

    @GetMapping("/pageData")
    public Page<Propertyvalue> propertyvalueData(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
        Page<Propertyvalue> propertyvaluePage = new Page<>(pageNum,10);
        return propertyvalueService.page(propertyvaluePage,null);
    }
}
