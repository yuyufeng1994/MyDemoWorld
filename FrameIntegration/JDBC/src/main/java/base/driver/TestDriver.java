package base.driver;

import base.init.DBProperties;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by yuyufeng on 2017/4/26.
 */
public class TestDriver {
    @Test
    public void test() throws Exception {

    }

    /*
	 * DriverManager 是驱动的管理类 1.可以通过重载的getconnection方法读取数据库连接，较为方便
	 * 2.可以同时管理多个驱动程序：若注册了多个数据库连接，则调用getConnection()传入 参数不同，即返回不同连接
	 */
    @Test
    public void testDriverManager() throws Exception {
        // 准备连接数据库的4个字符串
        // 驱动的全类名
        String driverClass = DBProperties.getDriverClassName();
        // jdbc url
        String jdbcUrl = DBProperties.getUrl();
        String user = DBProperties.getUsername();
        String password = DBProperties.getPassword();

        // 加载数据库驱动程序(注册驱动)
        Class.forName(driverClass);// 内涵静态代码快，已注册，只需用即可

        // 通过drivermanager的getConnection方法获取数据可连接
        Connection connection = DriverManager.getConnection(jdbcUrl, user,
                password);
        System.out.println(connection);
    }


    /*
     * Driver 是一个接口：数据库厂商必须提供实现的接口，能从其中获取数据库连接 1.加入mysql驱动
	 */
    @Test
    public void testDriver() throws Exception {
        // 创建一个Driver实现类的对象
        Driver driver = new com.mysql.jdbc.Driver();
        // 准备连接数据库的基本信息： url user password
        Properties info = new Properties();
        info.put("user", DBProperties.getUsername());
        info.put("password", DBProperties.getPassword());
        // 调用driver接口的connect(url,info)获取数据库连接
        Connection connection = driver.connect(DBProperties.getUrl(), info);
        System.out.println(connection);
    }
}
