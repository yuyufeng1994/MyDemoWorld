package base.result;

import base.connection.ConnectionUtil;
import base.utils.ReleaseUtil;
import org.junit.Test;

import java.io.*;
import java.sql.*;

/**
 * Created by yuyufeng on 2017/4/28.
 */
public class TestInsertBlob {
    @Test
    public void test() throws FileNotFoundException {


    }


    /*
     * 读取blob数据 使用getblob方法读取到blob对象 调用blob的getbinarystream得到输入流，在使用io操作
	 */
    @Test
    public void readBlob() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionUtil.getConnection();
            String sql = "select user_id,user_name,user_email,user_birth,user_photo from user_info where user_id = 7";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                System.out.println(id + "," + name + "," + email);
                Blob photo = resultSet.getBlob(4);
                System.out.println(photo.length());
                InputStream in = photo.getBinaryStream();
                OutputStream out = new FileOutputStream("d://user.jpg");

                byte[] buffer = new byte[1024];
                int len;
                while ((len = in.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
                in.close();
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseUtil.releaseSource(resultSet, preparedStatement, connection);
        }
    }

    /**
     * 插入bolb类型的数据必须使用preparedstatement，因为blob类型 的数据是无法用字符串拼接的 调用setblob
     * 　MySQL的四种BLOB类型
     * 　　类型 大小(单位：字节)
     * 　　TinyBlob 最大 255
     * 　　Blob 最大 65K
     * 　　MediumBlob 最大 16M
     * 　　LongBlob 最大 4G
     */
    @Test
    public void TestInsertBlob() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.getConnection();
            String sql = "insert into user_info(user_name,user_email,user_birth,user_photo) values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "user.jpg");
            preparedStatement.setString(2, "jdbc@yyf@com");
            preparedStatement.setDate(3, new Date(new java.util.Date().getTime()));

            File file = new File(TestInsertBlob.class.getResource("/user.jpg").getFile());
            InputStream inputStream = new FileInputStream(file);
            preparedStatement.setBlob(4, inputStream);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseUtil.releaseSource(null, preparedStatement, connection);
        }
    }
}
