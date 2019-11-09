package com.chenggong.bootmq.rabbit.object;

import com.chenggong.bootmq.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * created By DCG
 * 发送者
 **/
@Component
public class ObjectSender {

  @Autowired
  private AmqpTemplate rabbitTemplate;

  public void send(User user) {
    System.out.println("Sender object: " + user.toString());
    this.rabbitTemplate.convertAndSend("object", user);
  }
}
