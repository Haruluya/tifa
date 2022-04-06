package com.tifa.framework.config;


import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author haruluya
 * @date 2022/4/6
 * mybatis-plus插件配置。
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 分页插件配置。
     * @return MybatisPlus拦截器。
     */
    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        //分页拦截器。
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        //请求页数大于最大页数时回到首页。
        paginationInnerInterceptor.setOverflow(true);
        //每页最多条数。
        paginationInnerInterceptor.setMaxLimit(200L);
        //添加分页插件。
        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);

        return mybatisPlusInterceptor;
    }
}
