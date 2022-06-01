package com.tifa.framework.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.tifa.framework.config.JwtConfig;
import com.tifa.framework.web.pojo.Adressdetail;
import com.tifa.framework.web.pojo.User;
import com.tifa.framework.web.pojo.res.MongoDBUser;
import com.tifa.framework.web.service.impl.AdressdetailServiceImpl;
import com.tifa.framework.web.service.impl.UserServiceImpl;
import com.tifa.framework.web.util.AjaxReturnValue;
import com.tifa.framework.web.util.JSONData;
import com.tifa.framework.web.util.TifaConstant;
import io.jsonwebtoken.Claims;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private MongoClient mongoClient;
    @Autowired
    private AdressdetailServiceImpl adressdetailService;

    @Resource
    private JwtConfig jwtConfig;
    @Autowired
    private ObjectMapper objectMapper;
    

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
    public AjaxReturnValue registerConfim(@RequestBody User user, Model model) throws JsonProcessingException {
        //不允许重名。
        if (userService.uNameExisted(user.getUname())){
            return AjaxReturnValue.error(438);
        }
        MongoDBUser mongoDBUser = new MongoDBUser();
        mongoDBUser.setUsername(user.getUname());
        mongoDBUser.setPassword(user.getPassword());
        mongoDBUser.setFirst(true);
        mongoDBUser.setTimestamp(System.currentTimeMillis());
        MongoCollection<Document> userCollection = mongoClient.getDatabase(TifaConstant.MONGODB_DATABASE).getCollection(TifaConstant.DB_USER_COLLECTION_NAME);
        userCollection.insertOne(Document.parse(objectMapper.writeValueAsString(mongoDBUser)));
        //未注册则插入数据。
        userService.save(user);
        return AjaxReturnValue.success("OK");
    }

    /**
     * 获取当前用户的信息。
     * @param token
     * @return
     */
    @PostMapping("/userData")
    public AjaxReturnValue userInfoData(@RequestBody String token){
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
        User user = userService.getById(Integer.parseInt(claims.getSubject()));
        return AjaxReturnValue.success("OK",user);
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
    public AjaxReturnValue loginConfirm(@RequestBody User user){
        if (userService.userExisted(user.getUname(),user.getPassword())){
            JSONData data = new JSONData();
            //获取id和token。
            Integer id = userService.getIdByName(user.getUname());
            String token = jwtConfig.createToken(id.toString());
            data.put("token",token);
            return AjaxReturnValue.success("OK",data);
        }
        return AjaxReturnValue.error(438);
    }

    @PostMapping("/addAdress")
    public AjaxReturnValue addAddress(@RequestBody Adressdetail adressdetail){
        adressdetailService.save(adressdetail);
        return AjaxReturnValue.success();
    }

    @PostMapping("/locationData")
    public AjaxReturnValue locationData(@RequestBody JSONData data){
        String name = (String) (data.get("pname"));
        List<Adressdetail> list = adressdetailService.list(new QueryWrapper<Adressdetail>()
                .eq("name",name)
        );
        return AjaxReturnValue.success(list);
    }

    @PostMapping("/deleteAdress")
    public AjaxReturnValue deleteAdress(@RequestBody JSONData data){
        Integer aid = (Integer) data.get("aid");
        adressdetailService.removeById(aid);
        return AjaxReturnValue.success();
    }

    @PostMapping("/updateUserInfo")
    public AjaxReturnValue updateUserInfo(@RequestBody User user){
        userService.updateById(user);
        return AjaxReturnValue.success();
    }
    @PostMapping("/registerMerchantConfim")
    public AjaxReturnValue registerMerchant(@RequestBody JSONData jsonData){
        User user = new User();
        user.setBid(1);
        user.setUid((Integer) (jsonData.get("uid")));
        userService.updateById(user);
        return AjaxReturnValue.success();
    }
    @PostMapping("/rePassword")
    public AjaxReturnValue rePassword(@RequestBody JSONData jsonData){
        User user = new User();
        user.setUid(userService.getOne(
                new QueryWrapper<User>()
                        .eq("phone",((String) (jsonData.get("phone"))))
        ).getUid());
        user.setPassword((String) (jsonData.get("password")));
        userService.updateById(user);
        return AjaxReturnValue.success();
    }
}
