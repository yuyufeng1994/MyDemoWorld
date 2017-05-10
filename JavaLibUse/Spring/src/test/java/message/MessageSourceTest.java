package message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring 中MessageSource的使用
 * Created by yuyufeng on 2017/5/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:messages/messageBeans.xml"})
public class MessageSourceTest {
    @Autowired
    private MessageSource messageSource;



    @Test
    public void test() {
        System.out.println("MessageSourceTest.test");
    }

    @Test
    public void testGetMessage() {
        String message = messageSource.getMessage("ERR02", null, "未处理异常", null);
        System.out.println(message);

    }


}
