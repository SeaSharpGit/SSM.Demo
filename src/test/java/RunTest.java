import com.ssm.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

class RunTest {

    @Test
    void Test1() {
        //加载Spring容器上下文
        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("/src/main/resources/spring-config.xml");

        //加载jdbc
        //DataSource ds=(DataSource)applicationContext.getBean("myJdbc");


        UserController userController=(UserController)applicationContext.getBean("userController");
        userController.Test();

        ((FileSystemXmlApplicationContext) applicationContext).close();

    }

    public void Test5(int...v){
        for (int a:v){

        }
    }


}

