package base.statement;

import base.connection.ConnectionUtil;
import base.utils.ReleaseUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Created by yuyufeng on 2017/4/28.
 */
public class TestBatch {
    /*
	 * 插入1w条记录 测试时间 ： 1.使用statement; 2.PreperedStatement;3.batch; mysql中相差不大
	 * 在oracle 中相差很明显
	 */

    @Test
    public void testBatch() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = null;
        try {
            connection = ConnectionUtil.getConnection();
            ConnectionUtil.beginTx(connection);
            sql = "insert into num values(?,?)";
            preparedStatement = connection.prepareStatement(sql);
            long begin = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                preparedStatement.setInt(1, i + 1);
                preparedStatement.setString(2, "test_name");
                // preparedStatement.executeUpdate();
                // 积攒 sql
                preparedStatement.addBatch();
                // 当积攒到一定程度就统一的执行一次，并清空先前积攒的记录
                if (i + 1 % 300 == 0) {
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
                // 若总条数不是批量树枝的整倍数，则还需额外执行最后一次
                if (10000 % 300 != 0) {
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("Time:" + (end - begin)); // Time:981
            ConnectionUtil.commit(connection);
        } catch (Exception e) {
            e.printStackTrace();
            ConnectionUtil.rollback(connection);
        } finally {
            ReleaseUtil.releaseSource(null, preparedStatement, connection);
        }
    }

    @Test
    public void testBatchWithPreperedStatement() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = null;
        try {
            connection = ConnectionUtil.getConnection();
            ConnectionUtil.beginTx(connection);
            sql = "insert into num values(?,?)";
            preparedStatement = connection.prepareStatement(sql);
            long begin = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                preparedStatement.setInt(1, i + 1);
                preparedStatement.setString(2, "test_name");
                preparedStatement.executeUpdate();
            }
            long end = System.currentTimeMillis();
            System.out.println("Time:" + (end - begin)); // Time:951
            ConnectionUtil.commit(connection);
        } catch (Exception e) {
            e.printStackTrace();
            ConnectionUtil.rollback(connection);
        } finally {
            ReleaseUtil.releaseSource(null, preparedStatement, connection);
        }
    }

    @Test
    public void testBatchWithStatement() {
        Connection connection = null;
        Statement statement = null;
        String sql = null;
        try {
            connection = ConnectionUtil.getConnection();
            ConnectionUtil.beginTx(connection);
            statement = connection.createStatement();
            long begin = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                sql = "insert into num values('" + (i + 1) + "' , 'test_name')";
                statement.execute(sql);
            }
            long end = System.currentTimeMillis();
            System.out.println("Time:" + (end - begin)); // Time:977
            ConnectionUtil.commit(connection);
        } catch (Exception e) {
            e.printStackTrace();
            ConnectionUtil.rollback(connection);
        } finally {
            ReleaseUtil.releaseSource(null, statement, connection);
        }
    }

}
