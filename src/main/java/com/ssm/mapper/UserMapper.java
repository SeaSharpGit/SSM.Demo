package com.ssm.mapper;

import com.ssm.model.User;

import java.util.List;

public interface UserMapper {
    List<User> getListByName(String name);
    User getById(int id);
    int insert(User user);
    void update(User user);
    void delete(int id);
}
