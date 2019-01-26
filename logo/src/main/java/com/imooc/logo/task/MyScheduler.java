package com.imooc.logo.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler 
{
  //@Scheduled(fixedRate=2000)
  public void runJobA() 
  {
	  System.out.println("【***taskA间隔调度***】"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
  }
  
  //@Scheduled(cron="* * * * * ?")
  public void runJobB() 
  {
	  System.out.println("【***taskB间隔调度***】"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
  }
}
