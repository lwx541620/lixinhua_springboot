package com.imooc.logo.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyHealthIndicator implements HealthIndicator {

	@Override
	public Health health() 
	{
		// TODO Auto-generated method stub
		return Health.down().withDetail("hello", "world").build();
	}

}
