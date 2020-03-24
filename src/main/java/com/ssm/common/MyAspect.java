package com.ssm.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component("myAspect")
public class MyAspect {

    @Pointcut(value = "execution(* com.ssm.service.UserService.sayHello(..))")
    private void sayHelloPointCut(){}

    @Before(value = "com.ssm.common.MyAspect.sayHelloPointCut()")
    public void before(){
        System.out.println("MyAspect.before");
    }

    @After(value = "com.ssm.common.MyAspect.sayHelloPointCut()")
    public void after(){
        System.out.println("MyAspect.after");
    }

    @AfterReturning(value = "com.ssm.common.MyAspect.sayHelloPointCut()",returning = "result")
    public void afterReturning(Object result){
        System.out.println("MyAspect.afterReturning:"+result.toString());
    }

    @Around(value = "com.ssm.common.MyAspect.sayHelloPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("MyAspect环绕前");
        Object obj=joinPoint.proceed();
        System.out.println("MyAspect环绕后");
        return obj;
    }

    @AfterThrowing(value = "com.ssm.common.MyAspect.sayHelloPointCut()",throwing = "ex")
    public void afterThrowing(Throwable ex){
        System.out.println("MyAspect.afterThrowing："+ex.getMessage());
    }
}
