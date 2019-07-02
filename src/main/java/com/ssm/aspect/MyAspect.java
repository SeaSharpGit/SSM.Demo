package com.ssm.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component("myAspect")
public class MyAspect {

    @Before(value = "execution(* com.ssm.serviceimpl.UserServiceImpl.sayHello(..))")
    public void before(){
        System.out.println("MyAspect.before");
    }

    @After(value = "execution(* com.ssm.serviceimpl.UserServiceImpl.sayHello(..))")
    public void after(){
        System.out.println("MyAspect-after");
    }
}
