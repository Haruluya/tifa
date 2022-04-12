package com.tifa.framework.web.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.tifa.framework.config.JwtConfig;
import com.tifa.framework.web.pojo.User;
import com.tifa.framework.web.service.impl.UserServiceImpl;
import com.tifa.framework.web.util.AjaxReturnValue;
import com.tifa.framework.web.util.JSONData;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 *
 * @author haruluya
 * @date 2022/4/3
 */
@CrossOrigin
@RestController
@RequestMapping("/tifai/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Resource
    private JwtConfig jwtConfig;

    @GetMapping("/tableNames")
    public String[] tableNames(Model model){
        String[] result = userService.getAllTableNames();
        System.out.println(result);
        return result;
    }


    @GetMapping("/pageData")
    public Page<User> userPageData(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageNum, Model model){
        Page<User> userPage = new Page<>(pageNum,10);

        return userService.page(userPage,null);
    }


    /**
     * 注册确认，判断注册并返回是否成功。
     * @param model
     * @return 注册信息。
     */
    @PostMapping("/registerConfirm")
    public AjaxReturnValue registerConfim(@RequestBody User user, Model model){
        if (userService.emailExisted(user.getName())){
            return AjaxReturnValue.error(438);
        }
        //未注册则插入数据。
        userService.save(user);
        return AjaxReturnValue.success("OK");
    }

    /**
     * 获取当前用户的信息。
     * @param token
     * @param model
     * @return
     */
    @PostMapping("/userData")
    public AjaxReturnValue userInfoData(@RequestBody String token,Model model){
        //未登录或token失效。
        if (token.isEmpty()){
            return  AjaxReturnValue.error(438,"token not found");
        }
        Claims claims = jwtConfig.getTokenClaim(token);
        if (claims == null){
            return  AjaxReturnValue.error(438,"token invaild!");
        }
        Date expirationDate = jwtConfig.getExpirationDateFromToken(token);
        if (jwtConfig.isTokenExpired(expirationDate)){
            return  AjaxReturnValue.error(438,"token timeOut!");
        }
        System.out.println(claims.getSubject());
        String name = userService.getNameById(Integer.parseInt(claims.getSubject()));
        JSONData data = new JSONData();
        data.put("name",name);
        return AjaxReturnValue.success("OK",data);
    }

    /**
     * 用户退出登录，处理token等缓存信息。
     * @return
     */
    @PostMapping("/logout")
    public AjaxReturnValue userLogout(){
        return AjaxReturnValue.success("OK");
    }

    /**
     * 用户登录检测。
     * @return
     */
    @PostMapping("/loginConfirm")
    public AjaxReturnValue loginConfirm(@RequestBody User loginData){
        if (userService.userExisted(loginData)){
            JSONData data = new JSONData();
            //获取id和token。
            Integer id = userService.getIdByName(loginData.getName());
            String token = jwtConfig.createToken(id.toString());
            data.put("token",token);
            return AjaxReturnValue.success("OK",data);
        }
        return AjaxReturnValue.error(438);
    }

}
