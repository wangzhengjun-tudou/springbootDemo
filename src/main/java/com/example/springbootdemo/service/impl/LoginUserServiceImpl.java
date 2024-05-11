package com.example.springbootdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootdemo.entity.LoginUser;
import com.example.springbootdemo.mapper.LoginUserMapper;
import com.example.springbootdemo.service.LoginUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginUserServiceImpl extends ServiceImpl<LoginUserMapper, LoginUser> implements LoginUserService {


}
