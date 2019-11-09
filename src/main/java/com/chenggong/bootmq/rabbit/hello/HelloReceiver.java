package com.chenggong.bootmq.rabbit.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * created By DCG
 * 消息的接收者
 **/
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {
  @RabbitHandler
  public void process(String hello) {
    System.out.println("Receiver  : " + hello);
  }

}
