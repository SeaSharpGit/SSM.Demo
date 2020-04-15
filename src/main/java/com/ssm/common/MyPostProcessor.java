package com.ssm.common;

import com.ssm.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MyPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof UserService){
            System.out.println("MyPostProcessor.before");
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof UserService){
            System.out.println("MyPostProcessor.after");
        }
        return bean;
    }
}
