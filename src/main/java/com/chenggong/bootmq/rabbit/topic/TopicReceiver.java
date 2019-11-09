package com.chenggong.bootmq.rabbit.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * created By DCG
 **/
@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver {
  @RabbitHandler
  public void process(String message) {
    System.out.println("Topic Receiver1  : " + message);
  }
}
