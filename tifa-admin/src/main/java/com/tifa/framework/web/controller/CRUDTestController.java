package com.tifa.framework.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.tifa.framework.web.mapper.*;
import com.tifa.framework.web.pojo.Category;
import com.tifa.framework.web.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.util.List;

/**
 * @author haruluya
 * 测试CRUD的控制类。
 */
@Controller
@RequestMapping("/tifai/CRUD")
public class CRUDTestController {

    @Autowired
//    @Qualifier("userServiceImpl")
    private UserMapper userService;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ProductimageMapper productimageMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private PropertyMapper propertyMapper;
    @Autowired
    private PropertyvalueMapper propertyvalueMapper;
    @Autowired
    private ReviewMapper reviewMapper;
    @Autowired
    private UserMapper userMapper;

//    @RequestMapping("/CRUD")
//    public String showUsers(@RequestParam(value = "pageNum",defaultValue="1")Integer pageNum, Model model){
//
//        PageHelper.startPage(1,3);
//        List<User> userList = userService.selectAll();
//        PageInfo<User> page = new PageInfo<User>(userList,2);
//        model.addAttribute("pageInfo",page);
//        return "CRUDindex";
//    }


//    @RequestMapping("/api")
//    @ResponseBody
//    public String proxyTest(HttpServletRequest req, HttpServletResponse res){
//        return "index";
//    }

    @RequestMapping("/userData")
    @ResponseBody
    public PageInfo<User> userData(Model model){

        PageHelper.startPage(1,5);
        List<User> userList = userService.selectAll();
        PageInfo<User> page = new PageInfo<User>(userList,2);
        return page;
    }

    @RequestMapping("/categoryData")
    @ResponseBody
    public PageInfo<Category> categoryData(Model model){
        PageHelper.startPage(1,10);
        List<Category> categoryList = categoryMapper.selectAll();
        PageInfo<Category> page = new PageInfo<Category>(categoryList,2);
        return page;
    }


}
