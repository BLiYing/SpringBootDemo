package com.example.demo.controller;

import com.example.demo.pojo.IMoocJSONResult;
import com.example.demo.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author liying
 * @Date 2020/2/5 10:00 AM
 * @Version 1.0
 **/
@RestController
public class UserController {

    @RequestMapping("/getUserJson")
    public IMoocJSONResult getUserJson(){

        User user = new User();
        user.setAge(21);
        user.setName("Imooc");
        user.setBirthday(new Date());
        user.setDesc("hello imooc~~hello 555~~");
        return IMoocJSONResult.ok(user);
    }

}
