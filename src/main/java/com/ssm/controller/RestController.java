package com.ssm.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("rest")
public class RestController {

    @GetMapping("getToken")
    public String getToken(){
        return "token";
    }
}
