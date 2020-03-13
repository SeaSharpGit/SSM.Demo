package com.ssm.controller;


import com.ssm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("rest")
public class RestController {
    @Autowired
    private UserService userService;

    @GetMapping("getToken")
    public String getToken(){
        return "token";
    }

    @GetMapping("test")
    public void test(){
        userService.sayHello();
    }

}
