package com.ssm.controller;


import com.ssm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("rest")
@AllArgsConstructor
public class RestController {
    private final UserService userService;

    @GetMapping("getToken")
    public String getToken(){
        return "token";
    }

    @GetMapping("test")
    public void test(){
        userService.sayHello();
    }

}
