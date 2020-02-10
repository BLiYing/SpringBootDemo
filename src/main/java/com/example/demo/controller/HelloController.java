package com.example.demo.controller;

import com.example.demo.pojo.IMoocJSONResult;
import com.example.demo.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author liying
 * @Date 2020/2/5 10:00 AM
 * @Version 1.0
 **/
@RestController
public class HelloController {
    @Autowired
    Resource resource;

    @RequestMapping("/hello")
    public String hello(){
        return "hello springboot3";
    }

    @RequestMapping("/getResource")
    public IMoocJSONResult getResource(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource,bean);

        return IMoocJSONResult.ok(bean);
    }
}
