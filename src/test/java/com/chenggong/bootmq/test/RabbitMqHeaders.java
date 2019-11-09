package com.chenggong.bootmq.test;

import com.chenggong.bootmq.rabbit.headers.HeadersSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * created By DCG
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHeaders {

  @Autowired
  private HeadersSender headersSender;


  @Test
  public void headers() throws Exception {
    /**
     * 声明消息 (消息体, 消息属性)
     */
    MessageProperties messageProperties = new MessageProperties();
    // 设置消息是否持久化。Persistent表示持久化，Non-persistent表示不持久化
    messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
    messageProperties.setContentType("UTF-8");
    messageProperties.setHeader("Two", "B");
    Message message = new Message("hello,rabbit_headers_no！".getBytes(), messageProperties);
    headersSender.send(message);
  }

}
