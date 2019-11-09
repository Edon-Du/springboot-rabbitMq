package com.chenggong.bootmq.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * created By DCG
 * topic 是 RabbitMQ 中最灵活的一种方式，可以根据routingKey自由模式匹配队列
 **/
@Configuration
public class TopicRabbitConfig {

  final static String message = "topic.message";
  final static String messages = "topic.messages";

  @Bean
  public Queue queueMessage() {
    return new Queue(TopicRabbitConfig.message);
  }

  @Bean
  public Queue queueMessages() {
    return new Queue(TopicRabbitConfig.messages);
  }

  /**
   * 容器内注入一个交换机 name = topicExchange
   */
  @Bean
  TopicExchange exchange() {
    return new TopicExchange("topicExchange");
  }

  /**
   * name = topicExchange 的交换机绑定的第一个队列
   */
  @Bean
  Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
    return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
  }

  /**
   * name = topicExchange 的交换机绑定的第二个队列
   */
  @Bean
  Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
    return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
  }
}
