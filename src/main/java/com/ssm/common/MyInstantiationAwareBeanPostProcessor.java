package com.ssm.common;

import com.ssm.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(beanName.equalsIgnoreCase("UserService")){
            System.out.println("MyInstantiationAwareBeanPostProcessor.before");
        }
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(bean instanceof UserService){
            System.out.println("MyInstantiationAwareBeanPostProcessor.after");
        }
        return true;
    }
}
