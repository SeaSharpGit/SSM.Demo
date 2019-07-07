package com.ssm.daoimpl;

import com.ssm.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate c3p0Template;

    @Override
    public String sayHello() {
        return "Hello World!";
    }

    @Override
    public void insert1() {
        c3p0Template.update("INSERT INTO User(UserName,Date) VALUES(?,?)","你好8","2019-7-6");
    }

    @Override
    public void insert2() {
        c3p0Template.update("INSERT INTO User(UserName,Date) VALUES(?,?)","你好9","2019-7-6");
    }

}
