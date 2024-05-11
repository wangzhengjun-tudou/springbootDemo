package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.LoginUser;
import com.example.springbootdemo.service.LoginUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("mysqlTest")
public class HelloMySqlController {

    @Autowired
    LoginUserService loginUserService;

    @GetMapping("/listAll")
    public String listAll(){
        List<LoginUser> loginUsers = loginUserService.list();
        log.info(loginUsers.toString());
        return loginUsers.toString();
    }

}
