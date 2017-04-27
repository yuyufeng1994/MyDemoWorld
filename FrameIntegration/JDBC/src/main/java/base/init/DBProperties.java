package base.init;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by yuyufeng on 2017/4/26.
 */
public class DBProperties {
    private static String url;
    private static String username;
    private static String password;
    private static String driverClassName;
    private static Properties properties;

    static {
        properties = new Properties();
        FileInputStream in;
        try {
            in = new FileInputStream(DBProperties.class.getResource("/jdbc.properties").getFile());
            properties.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return (String) properties.get("url");
    }

    public static String getUsername() {
        return (String) properties.get("username");
    }

    public static String getPassword() {
        return (String) properties.get("password");
    }

    public static String getDriverClassName() {
        return (String) properties.get("driverClassName");
    }


}
