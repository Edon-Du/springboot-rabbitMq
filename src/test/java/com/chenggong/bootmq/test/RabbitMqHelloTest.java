package com.chenggong.bootmq.test;

import com.chenggong.bootmq.model.User;
import com.chenggong.bootmq.rabbit.hello.HelloSender;
import com.chenggong.bootmq.rabbit.many.NeoSender;
import com.chenggong.bootmq.rabbit.many.NeoSender2;
import com.chenggong.bootmq.rabbit.object.ObjectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * created By DCG
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

  @Autowired
  private HelloSender helloSender;

  @Autowired
  private NeoSender neoSender;

  @Autowired
  private NeoSender2 neoSender2;

  @Test
  public void hello() throws Exception {
    helloSender.send();
  }

  /**
   * 一个发送者，N个接收者，经测试会均匀的将消息发送个N个接收者  轮询接收的
   * Receiver 1: spirng boot neo queue ****** 0
   * Receiver 2: spirng boot neo queue ****** 1
   * Receiver 1: spirng boot neo queue ****** 2
   * Receiver 2: spirng boot neo queue ****** 3
   * Receiver 1: spirng boot neo queue ****** 4
   * Receiver 2: spirng boot neo queue ****** 5
   * Receiver 1: spirng boot neo queue ****** 6
   * Receiver 2: spirng boot neo queue ****** 7
   * Receiver 1: spirng boot neo queue ****** 8
   * Receiver 2: spirng boot neo queue ****** 9
   */
  @Test
  public void oneToMany() throws Exception {
    for (int i = 0; i < 100; i++) {
      neoSender.send(i);
    }
  }

  /**
   * Receiver 1: spirng boot neo queue ****** 0
   * Receiver 2: spirng boot neo456 queue ****** 0
   * Receiver 3: spirng boot neo queue ****** 1
   * Receiver 2: spirng boot neo queue ****** 2
   * Receiver 1: spirng boot neo456 queue ****** 1
   * Receiver 3: spirng boot neo456 queue ****** 2
   * Receiver 2: spirng boot neo456 queue ****** 3
   * 接收端仍然会均匀的接收到消息
   */
  @Test
  public void manyToMany() throws Exception {
    for (int i = 0; i < 10; i++) {
      neoSender.send(i);
      neoSender2.send(i);
    }
  }


  @Autowired
  private ObjectSender objectSender;

  @Test
  public void object() throws Exception {
    objectSender.send(new User().setName("哈哈").setPass("啊啊啊啊啊啊啊啊啊"));
  }


}
