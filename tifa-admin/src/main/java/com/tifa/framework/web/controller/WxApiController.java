package com.tifa.framework.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import com.tifa.framework.config.JwtConfig;
import com.tifa.framework.web.pojo.User;
import com.tifa.framework.web.service.impl.UserServiceImpl;
import com.tifa.framework.web.util.AjaxReturnValue;
import com.tifa.framework.web.util.ConstansWxUtils;
import com.tifa.framework.web.util.HttpClientUtils;
import com.tifa.framework.web.util.JSONData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

@CrossOrigin
@Controller
@RequestMapping("/tifai/wx")
public class WxApiController {

    @Autowired
    private UserServiceImpl userService;
    @Resource
    private JwtConfig jwtConfig;

    private Boolean isCodeLogin = false;

    private User nowUser;

    @PostMapping("/islogin")
    @ResponseBody
    public AjaxReturnValue islogin(){
        if (isCodeLogin){
            JSONData data = new JSONData();
            //获取id和token。
            Integer id = userService.getIdByName(nowUser.getUname());
            String token = jwtConfig.createToken(id.toString());
            data.put("token",token);
            this.nowUser = null;
            this.isCodeLogin = false;
            return AjaxReturnValue.success(data);
        }
        return AjaxReturnValue.error(438);
    }

    @PostMapping("/login")
    @ResponseBody
    public AjaxReturnValue getWxCode() {
        //固定地址，拼接参数
        //微信开放平台授权baseUrl  固定格式
        String baseUrl = "https://open.weixin.qq.com/connect/oauth2/authorize" +
                "?appid=%s" +
                "&redirect_uri=%s" +
                "&response_type=code" +
                "&scope=snsapi_userinfo" +
                "&state=%s" +
                "#wechat_redirect";

        //对redirect_url进行URLEncoder编码
        String redirectUrl = ConstansWxUtils.WX_OPEN_REDIRECT_URL;

        try {
            //对URL进行utf-8的编码
            URLEncoder.encode(redirectUrl, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String url = String.format( //向指定字符串中按顺序替换%s
                baseUrl,
                ConstansWxUtils.WX_OPEN_APP_ID,
                ConstansWxUtils.WX_OPEN_REDIRECT_URL,
                "Tifa"
        );

        JSONData jsonData = new JSONData();
        jsonData.put("url",url);
        //请求微信地址
        return AjaxReturnValue.success(jsonData);
    }

    @GetMapping("/callback")
    public String callback(String code,String state) {

        String baseAccessTokenUrl =
                "https://api.weixin.qq.com/sns/oauth2/access_token" +
                        "?appid=%s" +
                        "&secret=%s" +
                        "&code=%s" +
                        "&grant_type=authorization_code";

        String accessTokenUrl = String.format(
                baseAccessTokenUrl,
                ConstansWxUtils.WX_OPEN_APP_ID,
                ConstansWxUtils.WX_OPEN_APP_SECRET,
                code
        );

        try {

            String accessTokenInfo = HttpClientUtils.get(accessTokenUrl);

            //使用json转换工具 gson
            Gson gson = new Gson();
            //将JSON格式的字符串转换为一个map集合
            HashMap mapAccessToken = gson.fromJson(accessTokenInfo, HashMap.class);
            String access_token = (String) mapAccessToken.get("access_token");
            String openid = (String) mapAccessToken.get("openid");
            //将扫码人信息添加到数据库中
            //首先判断数据库中是否存在相同信息,根据openid进行查询
            User member = userService.getOne(
                    new QueryWrapper<User>()
                            .eq("openid",openid)
            );
            if (member == null) { //若为空，标识表里没有数据

                //携带access_token，openid请求地址获取微信用户信息
                String baseUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo" +
                        "?access_token=%s" +
                        "&openid=%s";

                String userInfoUrl = String.format(
                        baseUserInfoUrl,
                        access_token,
                        openid
                );

                String userInfo = HttpClientUtils.get(userInfoUrl);

                //使用gson来转换格式
                HashMap userInfoMap = gson.fromJson(userInfo, HashMap.class);
                //用户名
                String nickname = (String) userInfoMap.get("nickname");
                //头像
                String headimgurl = (String) userInfoMap.get("headimgurl");

                //将数据添加到数据库中
                member = new User();
                member.setOpenid(openid);
                member.setHeadpicture(headimgurl);
                member.setNickname(nickname);
                member.setBid(0);
                member.setUname(nickname);
                isCodeLogin = true;
                nowUser = member;
                userService.save(member);
                return "redirect:http://haruluya.natapp1.cc/loginsuccess";
            }else{
                isCodeLogin = true;
                nowUser = userService.getOne(
                        new QueryWrapper<User>()
                                .eq("openid",openid)
                );
                return "redirect:http://haruluya.natapp1.cc/loginsuccess";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:http://5198y370g3.zicp.vip:40592/loginsuccess";
        }
    }

}

