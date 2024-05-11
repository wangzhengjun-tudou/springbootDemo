package com.example.springbootdemo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdemo.entity.LoginUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginUserMapper extends BaseMapper<LoginUser> {
}
