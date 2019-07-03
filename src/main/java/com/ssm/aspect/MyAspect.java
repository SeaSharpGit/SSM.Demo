package com.ssm.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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
        System.out.println("MyAspect.after");
    }

    @AfterReturning(value = "execution(* com.ssm.serviceimpl.UserServiceImpl.sayHello(..))",returning = "result")
    public void afterReturning(Object result){
        System.out.println("MyAspect.afterReturning:"+result.toString());
    }

    @Around(value = "execution(* com.ssm.serviceimpl.UserServiceImpl.sayHello(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("MyAspect环绕前");
        Object obj=joinPoint.proceed();
        System.out.println("MyAspect环绕后");
        return obj;
    }

    @AfterThrowing(value = "execution(* com.ssm.serviceimpl.UserServiceImpl.sayHello(..))",throwing = "ex")
    public void afterThrowing(Throwable ex){
        System.out.println("MyAspect.afterThrowing："+ex.getMessage());
    }
}
