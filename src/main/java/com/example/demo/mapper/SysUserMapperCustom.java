package com.example.demo.mapper;

import com.example.demo.pojo.SysUser;
import org.springframework.stereotype.Component;

import java.util.List;
public interface SysUserMapperCustom {
    List<SysUser> queryUserSimplyInfoById(String id);

}
