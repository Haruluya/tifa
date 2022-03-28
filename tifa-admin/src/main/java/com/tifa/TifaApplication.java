package com.tifa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//SpringBoot配置主类。
@SpringBootApplication
public class TifaApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(TifaApplication.class, args);
        System.out.println("Tifa is running");
    }
}
