package com.chenggong.bootmq.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


/**
 * created By DCG
 **/
@Configuration
public class HeadersRabbitConfig {

  @Bean
  public Queue headersQueue() {
    return new Queue("headersQueue");
  }

  @Bean
  public Queue headersQueue1() {
    return new Queue("headersQueue1");
  }

  @Bean
  HeadersExchange headersExchange(){
    return new HeadersExchange("headersExchange");
  }

  @Bean
  Binding bindingExchangeOne(@Qualifier("headersQueue") Queue queue, HeadersExchange headersExchange){
    Map<String, Object> map = new HashMap<>();
    map.put("One", "A");
    map.put("Two", "B");
    //whereAll 表示全部匹配
    return BindingBuilder.bind(queue).to(headersExchange).whereAny(map).match();
  }

  @Bean
  Binding bindingExchangeTwo(@Qualifier("headersQueue1") Queue queue, HeadersExchange headersExchange){
    Map<String, Object> map = new HashMap<>();
    map.put("One", "A");
    map.put("Two", "B");
    //whereAny 表示部分匹配
    return BindingBuilder.bind(queue).to(headersExchange).whereAny(map).match();
  }




}
