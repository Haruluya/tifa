package com.tifa.framework.config;


import com.tifa.framework.web.Interceptors.CrossDomainInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 拦截器配置类。
 * @author haruluya
 * @date 2022/4/6
 */
@Configuration
public class InterceptorsConfig implements WebMvcConfigurer {

    //跨域拦截器配置作用域。
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CrossDomainInterceptors())
                .addPathPatterns("/**");
    }
}
