package com.ssm.daoimpl;

import com.ssm.common.SqlSessionFactoryUtils;
import com.ssm.dao.UserDao;
import com.ssm.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public List<User> getList() {
        try(SqlSession session=SqlSessionFactoryUtils.openSession()) {
            List<User> users=session.selectList("user.getList");
            return users;
        }
    }

    @Override
    public User getById(int id) {
        try(SqlSession session=SqlSessionFactoryUtils.openSession()) {
            //查询
            User user=session.selectOne("user.getById",id);
            return user;
        }
    }

    @Override
    public int add(User user) {
        try(SqlSession session=SqlSessionFactoryUtils.openSession()) {
            session.insert("user.insert",user);
            return user.getId();
        }
    }

    @Override
    public void update(User user) {
        try(SqlSession session=SqlSessionFactoryUtils.openSession()) {
            session.update("user.update",user);
        }
    }

    @Override
    public void delete(int id) {
        try(SqlSession session=SqlSessionFactoryUtils.openSession()) {
            session.delete("user.delete",id);
        }
    }
}
