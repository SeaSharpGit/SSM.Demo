package com.ssm.service;

import com.ssm.entity.User;
import com.ssm.entity.UserParameter;

import java.util.List;

public interface UserService {
    String sayHello();
    void transaction();
    List<User> getListByName(String name);
    User getById(int id);
    List<User> getByIds(UserParameter parameter);
    int insert(User user);
    void update(User user);
    void delete(int id);
}
