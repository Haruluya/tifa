package com.tifa;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//SpringBoot配置主类。
@SpringBootApplication()
@MapperScan("com.tifa.framework.web.mapper")
public class TifaApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(TifaApplication.class, args);
        System.out.println("Tifa is running");
    }
}
