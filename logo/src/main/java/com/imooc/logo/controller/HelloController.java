package com.imooc.logo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController extends AbstractBaseController
{
	
	
	
	@GetMapping("/helloworld")	
	public String home(@RequestParam(name="id") String id) 
	{				
		String name=super.getMessage("welcome.nihao",id);
		return "hello world"+name;
	}

}
