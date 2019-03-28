package com.ssm.daoimpl;

import com.ssm.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements UserDao {


    @Override
    public void sayHello() {
        System.out.println("我是UserRepository");
    }

}
