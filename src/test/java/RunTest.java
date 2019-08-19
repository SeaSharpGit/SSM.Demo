import com.ssm.common.SqlSessionFactoryUtils;
import com.ssm.mapper.UserMapper;
import com.ssm.model.User;
import com.ssm.model.UserParameter;
import com.ssm.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//创建项目时选择org.apache.archetypes:maven-archetype-webapp
class RunTest {

    //IOC和AOP
    @Test
    void Test() {
        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("/src/main/resources/spring-config.xml");
        UserService userService=(UserService)applicationContext.getBean("userService");
        userService.sayHello();
        ((FileSystemXmlApplicationContext) applicationContext).close();
    }

    //Connection、JDBC、DBCP、C3P0
    @Test
    void Test2() throws SQLException {
        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("/src/main/resources/spring-config.xml");

        //Connection方式
        Connection connection=(Connection)applicationContext.getBean("dbConnection");
        try(PreparedStatement ps=connection.prepareStatement("INSERT INTO User(Name,Date) VALUES(?,?)");) {
            ps.setString(1,"王海2");
            ps.setString(2,"2019-7-6");
            ps.execute();
        }

        //JDBC方式
        JdbcTemplate jdbc=(JdbcTemplate)applicationContext.getBean("jdbcTemplate");
        jdbc.update("INSERT INTO User(Name,Date) VALUES(?,?)","你好8","2019-7-6");

        //DBCP方式
        JdbcTemplate dbcp=(JdbcTemplate)applicationContext.getBean("dbcpTemplate");
        dbcp.update("INSERT INTO User(Name,Date) VALUES(?,?)","你好9","2019-7-6");

        //C3P0方式
        JdbcTemplate c3p0=(JdbcTemplate)applicationContext.getBean("c3p0Template");
        c3p0.update("INSERT INTO User(Name,Date) VALUES(?,?)","你好10","2019-7-6");
    }

    //事务
    @Test
    void Test3() {
        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("/src/main/resources/spring-config.xml");
        UserService userService=(UserService)applicationContext.getBean("userService");
        userService.transaction();
    }

    //MyBatis增删改查
    @Test
    void Test4(){
        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("/src/main/resources/spring-config.xml");
        UserService userService=(UserService)applicationContext.getBean("userService");
        UserMapper userMapper=applicationContext.getBean(UserMapper.class);
        User user=userMapper.getById(30);
        int a=1;
    }





}

