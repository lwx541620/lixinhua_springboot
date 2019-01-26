package com.imooc.logo.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public abstract class AbstractBaseController 
{
	@Autowired
	private MessageSource messageSource;
	
	public String getMessage(String key,String... args) 
	{	
		return messageSource.getMessage(key, args, Locale.getDefault());
	}
}
