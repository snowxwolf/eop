package com.xwolf.eop.test.mq;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * <p>
 *     RabbitMQ测试
 * </p>
 *
 * @author xwolf
 * @date 2017-01-15 09:46
 * @since V1.0.0
 */
public class TestRabbit {
    private final static String QUEUE_NAME = "hello";

    /**
     * 发送消息
     */
    @Test
    public void testPub(){
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("user");
        factory.setPassword("user123");
        factory.setPort(5672);
        try {
            Connection connection= factory.newConnection();
            //创建一个频道
            Channel channel = connection.createChannel();
            //指定一个队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            //发送的消息
            String message = "hello world!dsdsd";
            //往队列中发出一条消息
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("Sent Message：'" + message + "'");
            //关闭频道和连接
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    /**
     *接收消息
     */
     @Test
    public void testRecv(){
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("user");
        factory.setPassword("user123");
        factory.setPort(5672);
        try {
            Connection connection= factory.newConnection();
            //创建一个频道
            Channel channel = connection.createChannel();
            //指定一个队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            QueueingConsumer consumer=new QueueingConsumer(channel);
            //指定消费队列
            channel.basicConsume(QUEUE_NAME, true, consumer);
            while (true)
            {
                //nextDelivery是一个阻塞方法（内部实现其实是阻塞队列的take方法）
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                String message = new String(delivery.getBody());
                System.out.println("Received Message：'" + message + "'");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
