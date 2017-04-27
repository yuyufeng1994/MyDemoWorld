package base.connection;

import com.alibaba.druid.pool.DruidDataSource;
import base.init.DBProperties;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by yuyufeng on 2017/4/27.
 */
public class DruidUtil {

    @Test
    public void test() throws Exception {
        Connection connection = getConnection();
        System.out.println(connection);
    }

    public static Connection getConnection() throws Exception {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(DBProperties.getDriverClassName());

        druidDataSource.setUsername(DBProperties.getUsername());
        druidDataSource.setPassword(DBProperties.getPassword());
        druidDataSource.setUrl(DBProperties.getUrl());

       /* druidDataSource.setInitialSize(1);
        druidDataSource.setMinIdle(3);
        druidDataSource.setMaxActive(20);

        druidDataSource.setMaxWait(60000);

        druidDataSource.init();*/
        Connection connection = druidDataSource.getConnection();
        return connection;
    }

    @Test
    public void testDruidDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(DBProperties.getDriverClassName());

        druidDataSource.setUsername(DBProperties.getUsername());
        druidDataSource.setPassword(DBProperties.getPassword());
        druidDataSource.setUrl(DBProperties.getUrl());

       /* druidDataSource.setInitialSize(1);
        druidDataSource.setMinIdle(3);
        druidDataSource.setMaxActive(20);

        druidDataSource.setMaxWait(60000);

        druidDataSource.init();*/
        Connection connection = druidDataSource.getConnection();
        System.out.println(connection);
    }
}
