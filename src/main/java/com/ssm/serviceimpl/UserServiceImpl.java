package com.ssm.serviceimpl;

import com.ssm.common.SqlSessionFactoryUtils;
import com.ssm.mapper.UserMapper;
import com.ssm.entity.User;
import com.ssm.entity.UserParameter;
import com.ssm.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public String sayHello() {
        userMapper.getById(30);
        userMapper.getById(30);
        userMapper.getById(30);
        return "Hello World!";
    }

    @PostConstruct
    public void init(){

    }

    @PreDestroy
    public void destroy(){

    }


    public List<User> getListByName(String name) {
        return userMapper.getListByName(name);
    }


    public User getById(int id) {
        return userMapper.getById(id);
    }


    public List<User> getByIds(UserParameter parameter) {
        return userMapper.getByIds(parameter);
    }


    public int insert(User user) {
        return userMapper.insert(user);
    }


    public void update(User user) {
        userMapper.update(user);
    }


    public void delete(int id) {
        userMapper.delete(id);
    }

}
