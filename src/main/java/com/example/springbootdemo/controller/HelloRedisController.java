package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.LoginUser;
import com.example.springbootdemo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/helloRedis")
public class HelloRedisController {

    @Autowired
    RedisService redisService;

    @PostMapping("/testSet")
    public String testSet(@RequestBody LoginUser loginUser){
        redisService.setValueWithExpire(loginUser.getUserName(),loginUser.getPassword(),1, TimeUnit.MINUTES);
        return "hello world!";
    }

    @GetMapping("testGet")
    public String testGet(@RequestParam String name){
        return String.valueOf(redisService.getValue(name));
    }
}
