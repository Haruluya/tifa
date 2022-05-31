package com.tifa.framework.web.controller;
import com.alibaba.fastjson.JSONObject;

import com.tifa.framework.web.util.AjaxReturnValue;
import com.zhenzi.sms.ZhenziSmsClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping(value = "tifai/code")
public class CodeController {
    //短信平台相关参数
    //这个不用改
    private String apiUrl = "https://sms_developer.zhenzikj.com";
    //榛子云系统上获取
    private String appId = "111704";
    private String appSecret = "997c4d05-51f2-4f4c-ac6c-22c862bbfdcd";

    @GetMapping("/fitness")
    public AjaxReturnValue getCode(@RequestParam("phone") String memPhone, HttpSession httpSession){
        try {
            JSONObject json = null;
            //随机生成验证码
            String code = String.valueOf(new Random().nextInt(999999));
            //将验证码通过榛子云接口发送至手机
            ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
            Map<String, Object> params = new HashMap<String, Object>();
            //前台输入的手机号
            params.put("number", memPhone);
            //这个模板id对应的是榛子云个人中心的模板id
            params.put("templateId", 9466);
            String[] templateParams = new String[2];
            templateParams[0] = code;
            templateParams[1] = "5分钟";
            params.put("templateParams", templateParams);
            String result = client.send(params);
            System.out.println(result);
            json = JSONObject.parseObject(result);
            if (json.getIntValue("code")!=0){//发送短信失败
                return  AjaxReturnValue.error(444);
            }
            //将验证码存到session中,同时存入创建时间
            //以json存放，这里使用的是阿里的fastjson
            json = new JSONObject();
            json.put("memPhone",memPhone);
            json.put("code",code);
            json.put("createTime",System.currentTimeMillis());
            // 将认证码存入SESSION
            httpSession.setAttribute("code",json);
            return AjaxReturnValue.success(json);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxReturnValue.error(438);
        }
    }
}
