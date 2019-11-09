package com.chenggong.bootmq.rabbit.object;

import com.chenggong.bootmq.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * created By DCG
 * springboot 以及完美的支持对象的发送和接收，不需要格外的配置
 **/
@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {

  @RabbitHandler
  public void process(User user) {
    System.out.println("Receiver object : " + user);
  }
}
