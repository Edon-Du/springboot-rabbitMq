package com.chenggong.bootmq.test;

import com.chenggong.bootmq.rabbit.fanout.FanoutSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * created By DCG
 *
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqFanoutTest {

  @Autowired
  private FanoutSender fanoutSender;

  /**
   * Sender : hi, fanout msg
   *
   * fanout Receiver C: hi, fanout msg
   * fanout Receiver A  : hi, fanout msg
   * fanout Receiver B: hi, fanout msg
   */
  @Test
  public void fanout() throws Exception {
    fanoutSender.send();
  }
}
