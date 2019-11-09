package com.chenggong.bootmq.rabbit.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * created By DCG
 * 测试 一对多 多对多 发送者1
 **/
@Component
public class NeoSender {
  @Autowired
  private AmqpTemplate rabbitTemplate;

  public void send(int i) {
    String context = "spirng boot neo queue"+" ****** "+i;
    System.out.println("Sender1 : " + context);
    this.rabbitTemplate.convertAndSend("neo", context);
  }
}
