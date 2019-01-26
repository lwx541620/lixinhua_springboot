package com.imooc.logo.config;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect 
{
  private static Logger log=LoggerFactory.getLogger(ServiceAspect.class);
  
  @Around("execution(* com.imooc.logo.service..*.*(..))")
  public Object arroundInvoke(ProceedingJoinPoint point) throws Throwable
  {
	  log.info("【***Service-before***】执行参数"+Arrays.toString(point.getArgs()));
	  Object obj=point.proceed(point.getArgs());
	  log.info("【***Service-after***】返回结果"+obj);
	  return obj;
  }
}
