package com.imooc.logo.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imooc.logo.config.ProducerConfig;
import com.imooc.logo.service.IMessageProducerService;


@Service
public class MessageProducerServiceImpl implements IMessageProducerService
{
	
   @Autowired
   private RabbitTemplate rabbitTemplate;
   
	@Override
	public void sendMessage(String message)
	{
		rabbitTemplate.convertAndSend(ProducerConfig.EXCHANGE, ProducerConfig.ROUNTINGKEY, message);
	}

}
