package com.chenggong.bootmq.test;

import com.chenggong.bootmq.rabbit.topic.TopicSender;
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
public class RabbitMqTopicTest {

  @Autowired
  private TopicSender topicSender;

  /**
   * Topic Receiver2  : hi, i am message 1
   * Topic Receiver1  : hi, i am message 1
   * Topic Receiver2  : hi, i am messages 2
   */
  @Test
  public void topic() throws Exception {
    topicSender.send1();
    topicSender.send2();
  }

}
