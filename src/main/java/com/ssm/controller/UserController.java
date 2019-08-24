package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping("hello")
    public ModelAndView hello(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("msg","Hello SpringMVC!");
        mav.setViewName("Test");
        return mav;
    }
}
