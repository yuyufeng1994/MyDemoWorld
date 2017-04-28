package base.connection;

import base.init.DBProperties;
import org.junit.Test;

import java.sql.*;

/**
 * Created by yuyufeng on 2017/4/26.
 */
public class ConnectionUtil {
    @Test
    public void test() throws Exception {
        Connection connection = getConnection();
        System.out.println(connection);
    }

    public static Connection getConnection() throws Exception {
// 1.准备连接数据库的4个字符串
        String driverClass = DBProperties.getDriverClassName();
        String jdbcUrl = DBProperties.getUrl();
        String user = DBProperties.getUsername();
        String password = DBProperties.getPassword();

        // 2.加载数据库驱动程序（对应的Driver 实现类中有注册驱动的静态代码快）
        Class.forName(driverClass);
        // 3.通过DriverMananeger 的 getConnection()方法获取数据库连接。
        return DriverManager.getConnection(jdbcUrl, user, password);
    }


    public static void beginTx(Connection connection) {

        if (connection != null) {
            try {
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void commit(Connection connection) {
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void rollback(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
