package com.chenggong.bootmq.rabbit.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * created By DCG
 * 消息的发送者
 **/
@Component
public class HelloSender {


  /**
   * springboot 提供的默认实现
   */
  @Autowired
  private AmqpTemplate rabbitTemplate;

  public void send() {
    String context = "hello " + new Date();
    System.out.println("Sender : " + context);
    this.rabbitTemplate.convertAndSend("hello", context);
  }
}
