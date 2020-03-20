import com.ssm.mapper.UserMapper;
import com.ssm.entity.User;
import com.ssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.function.IntConsumer;

//创建项目时选择org.apache.archetypes:maven-archetype-webapp
//整合JUnit4和Spring
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class RunTest {

    @Autowired
    private UserService userService;

    /**
     * jdbc基本操作
     */
    @Test
    public void jdbc(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Test?characterEncoding=utf-8","root","sa123456")) {
                try(PreparedStatement ps=connection.prepareStatement("INSERT INTO User(Name,Date) VALUES(?,?)");) {
                    ps.setString(1,"王海2");
                    ps.setString(2,"2019-7-6");
                    ps.execute();
                }
            }
        }catch (Exception ex){

        }
    }

    /**
     * IOC和AOP
     */
    @Test
    public void iocAndAop() {
        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("/src/main/resources/spring-config.xml");
        UserService userService=(UserService)applicationContext.getBean("userService");
        userService.sayHello();
        ((FileSystemXmlApplicationContext) applicationContext).close();
    }

    /**
     * mybatis
     */
    @Test
    public void mybatis(){
        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("/src/main/resources/spring-config.xml");
        UserMapper userMapper=applicationContext.getBean(UserMapper.class);
        User user=userMapper.getById(30);
    }




}

