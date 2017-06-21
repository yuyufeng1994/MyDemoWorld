import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.HelloService;

import java.io.IOException;

/**
 * Created by yuyufeng on 2017/6/21.
 */
public class ProviderApp {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        context.start();
        System.out.println("dubbo提供层启动成功！");
        System.in.read();//保持Spring容器启动
    }
}
