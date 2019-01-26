package com.imooc.logo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig 
{
  public final  static String EXCHANGE="mldn.microboot.exchange";
  public final  static String ROUNTINGKEY="mldn.microboot.rountingkey";
  public final  static String QUEUE_NAME="mldn.microboot.queue";
  
  @Bean
  public Binding bindingExchangeQueue(DirectExchange exchange,Queue queue) 
  {
	  return  BindingBuilder.bind(queue).to(exchange).with(ROUNTINGKEY);
  }
  
  @Bean
  public DirectExchange getDirectExchange() 
  {
	  return new DirectExchange(EXCHANGE,true,true);
  }
  
  @Bean
  public Queue queue() 
  {
	  return new Queue(QUEUE_NAME);
  }
}
