package com.ssm.service;

import com.ssm.model.User;

import java.util.List;

public interface UserService {
    String sayHello();
    void transaction();
    List<User> getList();
    User getById(int id);
    int insert(User user);
    void update(User user);
    void delete(int id);
}
