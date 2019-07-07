package com.ssm.serviceimpl;

import com.ssm.dao.UserDao;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

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
