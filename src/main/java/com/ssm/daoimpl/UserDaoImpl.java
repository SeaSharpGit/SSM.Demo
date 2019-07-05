package com.ssm.daoimpl;

import com.ssm.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public String sayHello() {
        return "Hello World!";
    }

}
