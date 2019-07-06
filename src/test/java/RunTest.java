import com.ssm.dao.UserDao;
import com.ssm.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

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
        try(PreparedStatement ps=connection.prepareStatement("INSERT INTO User(UserName,Date) VALUES(?,?)");) {
            ps.setString(1,"王海2");
            ps.setString(2,"2019-7-6");
            ps.execute();
        }

        //JDBC方式
        JdbcTemplate jdbc=(JdbcTemplate)applicationContext.getBean("jdbcTemplate");
        jdbc.update("INSERT INTO User(UserName,Date) VALUES(?,?)","你好5","2019-7-6");

        //DBCP方式
        JdbcTemplate dbcp=(JdbcTemplate)applicationContext.getBean("jdbcTemplate");
        dbcp.update("INSERT INTO User(UserName,Date) VALUES(?,?)","你好6","2019-7-6");

        //C3P0方式
        JdbcTemplate c3p0=(JdbcTemplate)applicationContext.getBean("jdbcTemplate");
        c3p0.update("INSERT INTO User(UserName,Date) VALUES(?,?)","你好7","2019-7-6");
    }

    //
    @Test
    void Test3() {


    }





}

