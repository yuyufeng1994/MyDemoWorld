package base.result;

import base.connection.ConnectionUtil;
import base.utils.ReleaseUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuyufeng on 2017/4/27.
 */
public class TestResultSetMetaData {
    /**
     * 数据库获取列名
     */
    @Test
    public void ResultSetMetaData() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            String sql = "select user_id,user_name,user_email,user_birth from user_info where user_id=?";

            conn = ConnectionUtil.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            rs = preparedStatement.executeQuery();
            // 1.得到resultSetMetaData对象
            ResultSetMetaData rsmd = rs.getMetaData();
            Map<String, Object> values = new HashMap<String, Object>();
            while (rs.next()) {
                // 2.打印每一列的列名
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Object columnValue = rs.getObject(columnLabel);
                    values.put(columnLabel, columnValue);
                }
            }


            for (String s : values.keySet()) {
                System.out.println(s + " " + values.get(s));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseUtil.releaseSource(rs, preparedStatement, conn);
        }
    }
}
