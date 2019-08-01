package com.ssm.serviceimpl;

import com.ssm.common.SqlSessionFactoryUtils;
import com.ssm.dao.UserDao;
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

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService{
    //第一种方式
    @Autowired
    //第二种方式：@Resource(name = "userDao")
    private UserDao userDao;

    @Autowired
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

    public void transaction(){
        c3p0Template.update("INSERT INTO User(Name,Date) VALUES(?,?)","你好8","2019-7-6");
        int x=1/0;
        c3p0Template.update("INSERT INTO User(Name,Date) VALUES(?,?)","你好8","2019-7-6");
    }

    @Override
    public List<User> getList() {
        try(SqlSession session= SqlSessionFactoryUtils.openSession()) {
            UserDao userDao=session.getMapper(UserDao.class);
            return userDao.getList();
        }
    }

    @Override
    public User getById(int id) {
        try(SqlSession session= SqlSessionFactoryUtils.openSession()) {
            UserDao userDao=session.getMapper(UserDao.class);
            return userDao.getById(id);
        }
    }

    @Override
    public int insert(User user) {
        try(SqlSession session= SqlSessionFactoryUtils.openSession()) {
            UserDao userDao=session.getMapper(UserDao.class);
            return userDao.insert(user);
        }
    }

    @Override
    public void update(User user) {
        try(SqlSession session= SqlSessionFactoryUtils.openSession()) {
            UserDao userDao=session.getMapper(UserDao.class);
            userDao.update(user);
        }
    }

    @Override
    public void delete(int id) {
        try(SqlSession session= SqlSessionFactoryUtils.openSession()) {
            UserDao userDao=session.getMapper(UserDao.class);
            userDao.delete(id);
        }
    }



}
