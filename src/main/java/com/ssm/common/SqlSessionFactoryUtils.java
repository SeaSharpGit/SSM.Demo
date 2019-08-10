package com.ssm.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            InputStream stream= Resources.getResourceAsStream("SqlMapConfig.xml");
            sqlSessionFactory= builder.build(stream);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    public static SqlSession openSession(){
        return sqlSessionFactory.openSession(true);
    }


}
