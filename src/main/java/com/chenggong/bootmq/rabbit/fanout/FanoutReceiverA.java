package com.chenggong.bootmq.rabbit.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * created By DCG
 **/
@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {
  @RabbitHandler
  public void process(String message) {
    System.out.println("fanout Receiver A  : " + message);
  }
}

