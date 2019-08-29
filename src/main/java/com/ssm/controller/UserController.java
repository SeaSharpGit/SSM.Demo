package com.ssm.controller;

import com.ssm.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public ModelAndView hello(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("msg","Hello Spring MVC!");
        mav.setViewName("Test");
        return mav;
    }

    @RequestMapping(value = "hello2",method = RequestMethod.GET)
    public String hello2(Model model,Integer id){
        model.addAttribute("msg","Hello Spring MVC!");
        System.out.println(id);
        return "Test";
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Model model, User user){
        model.addAttribute("msg","保存成功!");
        return "Test";
    }
}
