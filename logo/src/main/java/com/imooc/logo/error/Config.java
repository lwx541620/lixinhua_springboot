package com.imooc.logo.error;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class Config 
{
	
	@Bean
	public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer()
	{
		return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>()
		{
			@Override
			public void customize(ConfigurableWebServerFactory factory) 
			{
				// TODO Auto-generated method stub
				ErrorPage errorPage400=new ErrorPage(HttpStatus.BAD_REQUEST,"/error-400.html");
				ErrorPage errorPage404=new ErrorPage(HttpStatus.NOT_FOUND,"/error-404.html");
				ErrorPage errorPage405=new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED,"/error-405.html");
				ErrorPage errorPage500=new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error-500.html");
				factory.addErrorPages(errorPage400,errorPage404,errorPage405,errorPage500);
			}};
	}

}
