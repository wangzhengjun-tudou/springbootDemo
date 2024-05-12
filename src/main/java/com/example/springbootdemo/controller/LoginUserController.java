package com.example.springbootdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.springbootdemo.entity.LoginUser;
import com.example.springbootdemo.entity.domain.R;
import com.example.springbootdemo.service.LoginUserService;
import com.example.springbootdemo.utils.MD5Util;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loginUser")
public class LoginUserController {

    @Autowired
    LoginUserService loginUserService;

    @PostMapping("/checkUserName")
    public R checkUserName(@RequestParam(name = "userName", required = false, defaultValue = "none") String userName){

        //判断用户名不重复
        if(loginUserService.getByUserName(userName)!=null){
            return R.failed("用户名已存在");
        }else {
            return R.ok();
        }
    }



    @PostMapping("/create")
    public R createLoginUser(@RequestBody LoginUser loginUser){

        //判断用户名不重复
        if(loginUserService.getByUserName(loginUser.getUserName())!=null){
            return R.failed("用户名已存在");
        }

        loginUser.setPassword(MD5Util.md5(loginUser.getPassword()));
        boolean isSuccess = loginUserService.save(loginUser);

        if(isSuccess){
            return R.ok();
        }else {
            return R.failed("保存失败");
        }
    }

    @PostMapping("/login")
    public R loginUser(@RequestBody LoginUser loginUser){

        LoginUser selectResult = loginUserService.getByUserName(loginUser.getUserName());

        if(selectResult==null){
            return R.failed("用户名或密码错误");
        }

        if(MD5Util.md5(loginUser.getPassword()).equals(selectResult.getPassword())){
            return R.ok();
        }else {
            return R.failed("用户名或密码错误");
        }
    }

}
