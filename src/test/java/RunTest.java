
import com.ssm.dao.UserDao;
import com.ssm.daoimpl.UserDaoImpl;
import com.ssm.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.sql.DataSource;

class RunTest {

    @Test
    void Test1() {
        //加载Spring容器上下文
        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("/src/main/resources/spring-config.xml");

        UserService userService=(UserService)applicationContext.getBean("userService");
        userService.sayHello();
        //UserDaoImpl userDaoImpl= (UserDaoImpl) applicationContext.getBean("userDaoImpl");

        //加载jdbc
        DataSource ds=(DataSource)applicationContext.getBean("myJdbc");

//        UserController userController=(UserController)applicationContext.getBean("userController");
//        userController.Test();

        ((FileSystemXmlApplicationContext) applicationContext).close();



    }

    public void Test5(int...v){
        for (int a:v){

        }
    }


}

