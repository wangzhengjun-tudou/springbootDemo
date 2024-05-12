package com.example.springbootdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootdemo.entity.LoginUser;

import java.util.List;

public interface LoginUserService extends IService<LoginUser> {

    public LoginUser getByUserName(String userName);
}
