package base.result;

import base.connection.ConnectionUtil;
import base.utils.ReleaseUtil;
import org.junit.Test;

import java.sql.*;

/**
 * Created by yuyufeng on 2017/4/28.
 */
public class TestGetKeyValue {

    @Test
    public void test() {

    }





    /**
     * 取得数据库自动生成的主键
     */
    @Test
    public void testGetKeyValue() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.getConnection();
            String sql = "insert into user_info(user_name,user_email,user_birth) "
                    + "values(?,?,?)";
            // preparedStatement = connection.prepareStatement(sql);
            // 使用重载的prepareStatement 来生成对象
            preparedStatement = connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, "abcde");
            preparedStatement.setString(2, "jdbcyyf@com");
            preparedStatement.setDate(3, new Date(new java.util.Date().getTime()));
            preparedStatement.executeUpdate();
            // 通过
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                System.out.println(rs.getObject(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseUtil.releaseSource(null, preparedStatement, connection);
        }
    }
}
