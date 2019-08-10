package com.ssm.serviceimpl;

import com.ssm.common.SqlSessionFactoryUtils;
import com.ssm.mapper.UserMapper;
import com.ssm.model.User;
import com.ssm.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{
    //第一种方式
    @Autowired
    //第二种方式：@Resource(name = "c3p0Template")
    private JdbcTemplate c3p0Template;

    @Override
    public String sayHello() {
        return "Hello World!";
    }

    @PostConstruct
    public void init(){

    }

    @PreDestroy
    public void destroy(){

    }

    @Transactional
    public void transaction(){
        c3p0Template.update("INSERT INTO User(Name,Date) VALUES(?,?)","你好8","2019-7-6");
        int x=1/0;
        c3p0Template.update("INSERT INTO User(Name,Date) VALUES(?,?)","你好8","2019-7-6");
    }

    @Override
    public List<User> getList() {
        try(SqlSession session= SqlSessionFactoryUtils.openSession()) {
            UserMapper userMapper =session.getMapper(UserMapper.class);
            return userMapper.getList();
        }
    }

    @Override
    public User getById(int id) {
        try(SqlSession session= SqlSessionFactoryUtils.openSession()) {
            UserMapper userMapper =session.getMapper(UserMapper.class);
            return userMapper.getById(id);
        }
    }

    @Override
    public int insert(User user) {
        try(SqlSession session= SqlSessionFactoryUtils.openSession()) {
            UserMapper userMapper =session.getMapper(UserMapper.class);
            return userMapper.insert(user);
        }
    }

    @Override
    public void update(User user) {
        try(SqlSession session= SqlSessionFactoryUtils.openSession()) {
            UserMapper userMapper =session.getMapper(UserMapper.class);
            userMapper.update(user);
        }
    }

    @Override
    public void delete(int id) {
        try(SqlSession session= SqlSessionFactoryUtils.openSession()) {
            UserMapper userMapper =session.getMapper(UserMapper.class);
            userMapper.delete(id);
        }
    }



}
