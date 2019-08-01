package com.ssm.dao;

import com.ssm.model.User;

import java.util.List;

public interface UserDao {
    List<User> getList();
    User getById(int id);
    int insert(User user);
    void update(User user);
    void delete(int id);
}
