package statement;

import connection.ConnectionUtil;
import org.junit.Test;
import utils.ReleaseUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 * Created by yuyufeng on 2017/4/27.
 */
public class TestPreparedStatement {

    /*
     * PreparedStatement 有效的禁止sql注入，
	 */
    @Test
    public void testPreparedStatement() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.getConnection();
            String sql = "insert into user_info(user_id,user_name,user_email,user_birth) "
                    + "values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, "yyf");
            preparedStatement.setString(3, "yyf@qq.com");
            preparedStatement.setDate(4,
                    new Date(new java.util.Date().getTime()));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseUtil.releaseSource(null, preparedStatement, connection);
        }
    }


    @Test
    public void test() throws Exception {

    }
}
