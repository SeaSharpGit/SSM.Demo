package com.ssm.service;

import com.ssm.mapper.UserMapper;
import com.ssm.entity.User;
import com.ssm.entity.UserParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Resource
    private UserMapper userMapper;

    public UserService(){
        System.out.println("UserService实例化");
    }

    public String sayHello() {
        userMapper.getById(30);
        userMapper.getById(30);
        userMapper.getById(30);
        return "Hello World!";
    }

    @PostConstruct
    public void init(){
        System.out.println("UserService.init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("UserService.destroy");
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
