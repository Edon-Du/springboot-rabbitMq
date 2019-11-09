package com.chenggong.bootmq.rabbit.headers;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * created By DCG
 **/
@Component
public class HeadersReceiver {

  //监听器监听指定的Queue
  @RabbitListener(queues="headersQueue")
  public void process(Message message) throws UnsupportedEncodingException {
    MessageProperties messageProperties = message.getMessageProperties();
    String contentType = messageProperties.getContentType();
    System.out.println("Receive-Headers:"+ new String(message.getBody(), contentType));
  }

}
