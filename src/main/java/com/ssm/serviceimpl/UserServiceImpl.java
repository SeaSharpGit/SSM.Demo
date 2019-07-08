package com.ssm.serviceimpl;

import com.ssm.dao.UserDao;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService{
    //第一种方式
    @Autowired
    //第二种方式：@Resource(name = "userDao")
    private UserDao userDao;


    public void transaction(){
        userDao.insert1();
        int x=1/0;
        userDao.insert2();
    }

    @Override
    public String sayHello() {
        return userDao.sayHello();
    }

    @PostConstruct
    public void init(){

    }

    @PreDestroy
    public void destroy(){

    }

}
