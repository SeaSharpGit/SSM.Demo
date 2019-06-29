package com.ssm.daoimpl;

import com.ssm.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("userDao")
public class UserDaoImpl implements UserDao {
    @Value("1")
    private int number;


    @Override
    public void sayHello() {
        System.out.println("我是UserRepository");
    }

}
