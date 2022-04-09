package com.tifa.framework.config;


import com.tifa.framework.web.Interceptors.CrossDomainInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;


/**
 * 拦截器配置类。
 * @author haruluya
 * @date 2022/4/6
 */
@Configuration
public class InterceptorsConfig implements WebMvcConfigurer {

//    @Resource
//    private TokenInterceptor tokenInterceptor ;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //跨域拦截器配置作用域。
        registry.addInterceptor(new CrossDomainInterceptor())
                .addPathPatterns("/**");
//        //token拦截器配置作用域。
//        registry.addInterceptor(tokenInterceptor).
//                addPathPatterns("/**");
    }
}
