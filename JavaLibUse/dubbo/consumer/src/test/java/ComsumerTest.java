import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.HelloService;

/**
 * Created by yuyufeng on 2017/6/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:application.xml"})
public class ComsumerTest {
    @Autowired
    HelloService helloService;

    @Test
    public void test() {
        String res = helloService.say("你好~");
        System.out.println(res);
    }

    @Test
    public void testMany() {
        for (int i = 0; i < 50; i++) {
            String res = helloService.say("你好~");
            System.out.println(res);
        }

    }
}
