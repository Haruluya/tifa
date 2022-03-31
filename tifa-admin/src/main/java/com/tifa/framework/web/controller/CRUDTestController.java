package com.tifa.framework.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.tifa.framework.web.mapper.UserMapper;
import com.tifa.framework.web.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class CRUDTestController {

    @Autowired
//    @Qualifier("userServiceImpl")
    private UserMapper userService;

    @RequestMapping("/CRUD")
    public String showUsers(@RequestParam(value = "pageNum",defaultValue="1")Integer pageNum, Model model){

        PageHelper.startPage(1,3);
        List<User> userList = userService.selectAll();
        PageInfo<User> page = new PageInfo<User>(userList,2);
        model.addAttribute("pageInfo",page);
        return "CRUDindex";
    }


    @RequestMapping("/api")
    @ResponseBody
    public String proxyTest(HttpServletRequest req, HttpServletResponse res){
        res.setHeader("Access-Control-Allow-Origin","*");
        res.setHeader("Access-Control-Allow-Credentials","true");
        res.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
        res.setHeader("Access-Control-Allow-Headers", "Content-Type");
        return "index";
    }

    @RequestMapping("/api/userData")
    @ResponseBody
    public PageInfo<User> userData(HttpServletRequest req, HttpServletResponse res){
        res.setHeader("Access-Control-Allow-Origin","*");
        res.setHeader("Access-Control-Allow-Credentials","true");
        res.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
        res.setHeader("Access-Control-Allow-Headers", "Content-Type");
        PageHelper.startPage(1,3);
        List<User> userList = userService.selectAll();
        PageInfo<User> page = new PageInfo<User>(userList,2);
        return page;
    }
}
