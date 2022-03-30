package com.tifa.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.filter.HiddenHttpMethodFilter;

/**
 * @author haruluya
 * @date 2022/3/28
 * 核心配置类。
 */
@Configuration
public class TifaCenterConfig {
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
