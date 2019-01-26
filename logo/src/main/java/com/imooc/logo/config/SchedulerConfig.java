package com.imooc.logo.config;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class SchedulerConfig implements SchedulingConfigurer 
{
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) 
	{
		// TODO Auto-generated method stub
		taskRegistrar.setScheduler(Executors.newScheduledThreadPool(20));
	}
}
