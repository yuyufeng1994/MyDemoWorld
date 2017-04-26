package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by yuyufeng on 2017/4/26.
 */
public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String configValue = servletContextEvent.getServletContext().getInitParameter("config.properties");
        System.out.println("config.properties:" + configValue);
        Properties pro = new Properties();
        FileInputStream in;
        try {
            in = new FileInputStream(this.getClass().getResource(configValue).getFile());
            pro.load(in);
            in.close();
            for (Object o : pro.keySet()) {
                System.out.println(pro.get(o));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    public static void main(String[] args) {
//        System.out.println(InitListener.class.getResource("/conf/config.properties").toString());

        /*Properties pro = new Properties();
        FileInputStream in;
        try {
            in = new FileInputStream(InitListener.class.getResourceAsStream("conf/config.properties").toString());
            pro.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pro.get("key1"));*/

    }
}
