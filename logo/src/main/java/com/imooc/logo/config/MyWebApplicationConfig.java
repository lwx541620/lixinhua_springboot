package com.imooc.logo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.imooc.logo.util.MyInterceptor;

@Configuration
public class MyWebApplicationConfig implements WebMvcConfigurer  
{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/member_add");
	}

}
