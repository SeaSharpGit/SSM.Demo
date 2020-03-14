import com.ssm.mapper.UserMapper;
import com.ssm.entity.User;
import com.ssm.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.function.IntConsumer;

//创建项目时选择org.apache.archetypes:maven-archetype-webapp
class RunTest {

    /**
     * jdbc基本操作
     */
    @Test
    void jdbc(){
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
    void iocAndAop() {
        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("/src/main/resources/spring-config.xml");
        UserService userService=(UserService)applicationContext.getBean("userService");
        userService.sayHello();
        ((FileSystemXmlApplicationContext) applicationContext).close();
    }

    /**
     * mybatis
     */
    @Test
    void mybatis(){
        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("/src/main/resources/spring-config.xml");
        UserMapper userMapper=applicationContext.getBean(UserMapper.class);
        User user=userMapper.getById(30);
    }




}

