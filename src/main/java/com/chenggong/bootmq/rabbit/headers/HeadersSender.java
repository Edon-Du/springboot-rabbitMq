package com.chenggong.bootmq.rabbit.headers;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * created By DCG
 **/
@Component
public class HeadersSender {

  @Autowired
  private AmqpTemplate rabbitTemplate;

  /**
   * 发送消息
   */
  public void send(Message message) {
    this.rabbitTemplate.convertAndSend("headersExchange", null, message);
  }

}
