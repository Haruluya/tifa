package com.tifa.framework.web.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tifa.framework.web.pojo.Category;
import com.tifa.framework.web.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/tifai/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;


    @GetMapping("/pageData")
    public Page<Category> categoryData(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
        Page<Category> categoryPage = new Page<>(pageNum,10);
        System.out.println(pageNum);
        return categoryService.page(categoryPage,null);
    }
}
