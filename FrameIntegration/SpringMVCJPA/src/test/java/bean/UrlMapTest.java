package bean;

import interceptor.URLBrokerLauncherInterceptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by yuyufeng on 2017/4/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/applicationBeans.xml" })
public class UrlMapTest {
    @Resource(name = "urlMap")
    private Map<String, String> urlMap;
    @Test
    public void test(){
        for (String s : urlMap.keySet()) {
            System.out.println(s+" "+urlMap.get(s));
        }

    }
}
