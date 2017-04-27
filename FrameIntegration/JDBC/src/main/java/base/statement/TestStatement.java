package base.statement;

import base.connection.ConnectionUtil;
import base.connection.DBCPUtil;
import org.junit.Test;
import base.utils.ReleaseUtil;

import java.sql.*;

/**
 * Created by yuyufeng on 2017/4/27.
 */
public class TestStatement {
    @Test
    public void test() throws Exception {

    }

    /**
     * ResultSet:结果集，封装使用JDBC进行查询的结果 1.调用statement对象的executeQuery(sql)可以得到结果集
     * 2.ResultSet 反悔的实际上就是一张数据表，有一个指针指向数据表的第一行的前面 可以调用next()方法检测下一行是否有效，
     * 3.当指针对位到一行时，可以通过调用getXxx(index)或getXxx(columnName) 获取每一列的值， 4.ResultSet
     * 当然也需要关闭
     */
    @Test
    public void testResultSet() {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            // 1. 获取Connection
            conn = DBCPUtil.getConnection();
            // 2. 获取Statement
            statement = conn.createStatement();
            // 3. 准备SQL
            String sql = "select user_id,user_name,user_email,user_birth from user_info ";

            // 4.执行查询得到result
            rs = statement.executeQuery(sql);
            // 5.处理ResultSet
            while (rs.next()) {
                int userId = rs.getInt(1);
                String userName = rs.getString("user_name");
                String userEmail = rs.getString(3);
                Date userBirth = rs.getDate(4);

                System.out.println(userId + " " + userName + " " + userEmail + " " + userBirth);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseUtil.releaseSource(rs, statement, conn);
        }

    }


    @Test
    public void testUpdate() throws Exception {
        String sql = "update user_info set user_birth='2017-05-01' where user_id = 1";
        update(sql);
    }

    /*
     * 通用的更新方法：包括 insert update delete
	 */
    public static void update(String sql) throws Exception {
        // 1.连接数据库
        Connection conn = null;
        Statement statement = null;

        try {
            conn = ConnectionUtil.getConnection();
            // 2.准备插入的sql语句

            // 3.执行插入
            statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseUtil.releaseSource(null,statement,conn);
        }
    }

    /*
	 * 通过jdbc向指定的数据表中插入一条记录 statement ：用于执行sql语句的对象 通过connection
	 * 的createStatement方法来获取 通过excuteUpdate(sql)可以执行sql语句 传入的sql可以是insert update
	 * delete 但不能是select
	 *
	 *
	 * connection statement 都是应用程序和数据库服务器连接资源。 使用后一定要关闭。需要在finally中关闭
	 *
	 * 关闭的顺序是： 先关闭后获取，即先关闭statement 后关闭connection
	 */
    @Test
    public void testInsertStatement() throws SQLException {
        // 1.连接数据库
        Connection conn = null;
        Statement statement = null;
        try {
            conn = ConnectionUtil.getConnection();
            // 2.准备插入的sql语句
            String sql = "insert into user_info(user_id,user_name,user_email,user_birth) values(NULL ,'俞育峰','416530244@qq.com','1994-12-24')";
            // 3.执行插入
            statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 4.关闭连接
                if (statement != null)
                    statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (conn != null)
                    conn.close();
            }

        }
    }
}
