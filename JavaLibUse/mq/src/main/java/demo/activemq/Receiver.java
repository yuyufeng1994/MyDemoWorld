package demo.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Date;

/**
 * Created by yuyufeng on 2017/7/19.
 */
public class Receiver {
    public static void main(String[] args) {
        // ConnectionFactory ：连接工厂，JMS 用它创建连接
        ConnectionFactory connectionFactory;
        // Connection ：JMS 客户端到JMS Provider 的连接
        Connection connection = null;
        // Session： 一个发送或接收消息的线程
        Session session;
        // Destination ：消息的目的地;消息发送给谁.
        Destination destination;
        // 消费者，消息接收者
        MessageConsumer consumer;
        connectionFactory = new ActiveMQConnectionFactory(
                "yyf",
                "12345",
                "tcp://106.14.13.212:61616");
        try {
            // 构造从工厂得到连接对象
            connection = connectionFactory.createConnection();
            // 启动
            connection.start();
            // 获取操作连接
            session = connection.createSession(Boolean.FALSE,
                    Session.AUTO_ACKNOWLEDGE);
            // 获取session注意参数值testQueue是一个服务器的queue，须在在ActiveMq的console配置
            destination = session.createQueue("testQueue");
            consumer = session.createConsumer(destination);
            while (true) {
                TextMessage message = (TextMessage) consumer.receive(0);
                if (null != message) {
                    System.out.println("收到消息" + message.getText());
                }else{
                    System.out.println("没有收到消息");
                }

                System.out.println(new Date());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection)
                    connection.close();
            } catch (Throwable ignore) {
            }
        }
    }
}
