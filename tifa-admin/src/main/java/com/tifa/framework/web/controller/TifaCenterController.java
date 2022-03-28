package com.tifa.framework.web.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.filter.HiddenHttpMethodFilter;


/**
 * @author Haruluya
 * @date 2022/3/28
 * web主控制器。
 */
@Controller
public class TifaCenterController {

    /**
     * 重定义表单隐藏域的方法名称。
     * @return 隐藏域方法过滤器。
     */
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam("_tifa");
        return methodFilter;
    }
}
