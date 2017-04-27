package base.connection;

import base.init.DBProperties;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by yuyufeng on 2017/4/27.
 */
public class DBCPUtil {


    public static Connection getConnection() throws Exception {
        Properties properties = new Properties();
        InputStream inStream = DBCPUtil.class.getClassLoader()
                .getResourceAsStream("jdbc.properties");
        properties.load(inStream);
        DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
        return dataSource.getConnection();

    }


    /**
     * 1.加载dbcp的properties 配置文件：配置文件中的键值对需要来自basicdatasource中的属性
     * 2.创建BasicDataSourceFactory 的 createDataSource方法创建datasource实例
     * 3.从datasource实例中获取数据库连接
     *
     * @throws Exception
     */
    @Test
    public void testDBCPWithDataSourceFactory() throws Exception {
        Properties properties = new Properties();
        InputStream inStream = DBCPUtil.class.getClassLoader()
                .getResourceAsStream("jdbc.properties");
        properties.load(inStream);
        DataSource dataSource = BasicDataSourceFactory
                .createDataSource(properties);
        System.out.println(dataSource.getConnection());
        BasicDataSource basicDataSource = (BasicDataSource) dataSource;
        System.out.println(basicDataSource.getMaxWait());
    }


    /**
     * 使用DBCP 数据库连接池 （依赖与pool这个jar包）
     *
     * @throws SQLException
     */
    @Test
    public void testDBCP() throws SQLException {
        BasicDataSource dataSource = null;

        // 创建DBCP 数据源实例
        dataSource = new BasicDataSource();

        // 为数据实例指定必须的属性
        dataSource.setUsername(DBProperties.getUsername());
        dataSource.setPassword(DBProperties.getPassword());
        dataSource.setUrl(DBProperties.getUrl());
        dataSource.setDriverClassName(DBProperties.getDriverClassName());

        // 指定一些可选的属性
        // 1.初始化连接数的个数
        dataSource.setInitialSize(10);
        // 2.指定最大连接数:同一时刻可以向数据库申请的连接数
        dataSource.setMaxActive(50);
        // 3.指定最小连接数：在数据库连接池中保存的最少的空闲连接数量
        dataSource.setMinIdle(5);
        // 4.等待数据库连接池分配连接的最长时间，单位为毫秒，超出该时间讲抛出异常
        dataSource.setMaxWait(1000 * 5);

        // 从数据源中获取数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection.getClass());
    }
}
