package base.utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by yuyufeng on 2017/4/27.
 */
public class ConnetcionUtil {
    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        InputStream inStream = ConnetcionUtil.class.getClassLoader()
                .getResourceAsStream("config.properties");
        try {
            properties.load(inStream);
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws Exception {
        return dataSource.getConnection();

    }

    public static void beginTx(Connection connection) {

        if (connection != null) {
            try {
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void commit(Connection connection) {
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void rollback(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i++) {
            new Thread(){
                @Override
                public void run() {
                   while(true){
                       try {
                           Connection connection = getConnection();
                           System.out.println(connection.hashCode());
                           Thread.sleep(100);
                           connection.close();
                       } catch (Exception e) {
                           e.printStackTrace();
                       }
                   }
                }
            }.start();
        }


    }
}
