package com.tifa.framework.web.controller;

import com.tifa.framework.web.util.AjaxReturnValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tifai/register")
public class RegisterController {

    /**
     * 注册确认，判断注册并返回是否成功。
     * @param model
     * @return 注册信息。
     */
    @PostMapping("/confirm")
    public AjaxReturnValue registerConfim(Model model){
        return AjaxReturnValue.success("OK");
    }
}
