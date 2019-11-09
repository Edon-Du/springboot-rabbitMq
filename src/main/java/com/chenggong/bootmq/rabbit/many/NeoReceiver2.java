package com.chenggong.bootmq.rabbit.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * created By DCG
 *  测试 一对多 多对多 接收者2
 **/
@Component
@RabbitListener(queues = "neo")
public class NeoReceiver2 {

  @RabbitHandler
  public void process(String neo) {
    System.out.println("Receiver 2: " + neo);
  }

}
