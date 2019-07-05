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

    //JDBC
    @Test
    void Test2() {
        try {
            Properties properties=new Properties();
            InputStream inputStream=this.getClass().getResourceAsStream("/db.properties");
            properties.load(inputStream);
            String url=properties.getProperty("url");
            String username=properties.getProperty("username");
            String password=properties.getProperty("password");
            String driver=properties.getProperty("driver");
            Class.forName(driver);
            Connection connection=DriverManager.getConnection(url,username,password);
            //新增
            try(PreparedStatement ps=connection.prepareStatement("INSERT INTO User(UserName,Date) VALUES(?,?)");) {
                ps.setString(1,"王海");
                ps.setString(2,"2019-7-6");
                ps.execute();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void Test3() throws SQLException {
        DriverManagerDataSource dataSource=new DriverManagerDataSource("jdbc:mysql://localhost:3306/Test","root","sa123456");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        JdbcTemplate jdbc=new JdbcTemplate(dataSource);
        jdbc.update("INSERT INTO User(UserName,Date) VALUES(?,?)","你好","2019-7-6");


        //加载Spring容器上下文
        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("/src/main/resources/spring-config.xml");
        //加载jdbc
        DataSource ds=(DataSource)applicationContext.getBean("myJdbc");

        DriverManagerDataSource ds2=(DriverManagerDataSource)applicationContext.getBean("myJdbc");

        Connection con= ds.getConnection();
    }





}

