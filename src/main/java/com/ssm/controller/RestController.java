package com.ssm.controller;


import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("getToken")
    public String getToken(){
        return "token";
    }
}
