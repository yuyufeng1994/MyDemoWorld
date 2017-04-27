package base.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Created by yuyufeng on 2017/4/26.
 */

public class Test1 {
    @Test
    public void test() throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();

        Properties info = new Properties();
        info.put("user", "root");
        info.put("password", "12345");
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&amp;characterEncoding=UTF-8";
        // 通过反射常见Driver对象.
         connection = driver.connect(jdbcUrl, info);







    }

}
