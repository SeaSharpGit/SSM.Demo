import com.ssm.model.User;
import com.ssm.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    @Test
    void Test4() throws IOException {
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        InputStream stream= Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory=builder.build(stream);
        try(SqlSession session=factory.openSession();) {
            User user=session.selectOne("user.getById",30);
        }
    }





}

