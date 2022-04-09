//package com.tifa.framework.web.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author haruluya
// */
//@RestController
//@RequestMapping("redis")
//public class RedisTestController {
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//
//    @GetMapping("test1")
//    public String test1(){
//        redisTemplate.opsForValue().set("test","haruluya");
//        String test = (String)redisTemplate.opsForValue().get("test");
//        return test;
//    }
//}
