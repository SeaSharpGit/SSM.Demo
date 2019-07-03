package com.ssm.serviceimpl;

import com.ssm.dao.UserDao;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Value("1")
    private int number;

    //第一种方式
    @Autowired
    //第二种方式：@Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public String sayHello() {
        System.out.println("UserServiceImpl.sayHello");
        return userDao.sayHello();
    }

    @PostConstruct
    public void init(){
        System.out.println("UserServiceImpl初始化");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("UserServiceImpl销毁");
    }

}
