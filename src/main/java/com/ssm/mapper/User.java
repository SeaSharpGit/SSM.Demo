package com.ssm.mapper;

import java.util.List;

public interface User {
    List<com.ssm.model.User> getList();
    com.ssm.model.User getById(int id);
    int add(com.ssm.model.User user);
    void update(com.ssm.model.User user);
    void delete(int id);

}
