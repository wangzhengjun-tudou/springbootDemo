package com.example.springbootdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootdemo.entity.LoginUser;
import com.example.springbootdemo.mapper.LoginUserMapper;
import com.example.springbootdemo.service.LoginUserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginUserServiceImpl extends ServiceImpl<LoginUserMapper, LoginUser> implements LoginUserService {


    /**
     * 根据用户名称查询数据库
     * @param userName
     * @return
     */
    @Override
    public LoginUser getByUserName(String userName) {
        LambdaQueryWrapper<LoginUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Strings.isNotEmpty(userName),LoginUser::getUserName,userName);
        return getOne(queryWrapper);
    }
}
