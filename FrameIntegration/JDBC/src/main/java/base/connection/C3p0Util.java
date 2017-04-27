package base.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import base.init.DBProperties;
import org.junit.Test;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by yuyufeng on 2017/4/27.
 */
public class C3p0Util {
    @Test
    public void test() throws Exception {
        Connection connection = getConnection();
        System.out.println(connection);
    }

    public Connection getConnection() throws PropertyVetoException, SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass(DBProperties.getDriverClassName());
        cpds.setJdbcUrl(DBProperties.getUrl());
        cpds.setUser(DBProperties.getUsername());
        cpds.setPassword(DBProperties.getPassword());
        return cpds.getConnection();
    }


    /**
     * 1.创建c3p0-config.xml文件 2.创建ComboPooledDataSource实例 3.从datasource中获取数据库连接
     *
     * @throws SQLException
     */
    @Test
    public void testC3p0WithConfigFile() throws SQLException {
        DataSource dataSource = new ComboPooledDataSource("helloC3p0");
        System.out.println(dataSource.getConnection());
        ComboPooledDataSource comboPooledDataSource = (ComboPooledDataSource) dataSource;
        System.out.println(comboPooledDataSource.getMaxStatements());
    }

    @Test
    public void testC3P0() throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass(DBProperties.getDriverClassName());
        cpds.setJdbcUrl(DBProperties.getUrl());
        cpds.setUser(DBProperties.getUsername());
        cpds.setPassword(DBProperties.getPassword());
        System.out.println(cpds.getConnection());
    }
}
