package com.imooc.logo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TestController {
	MultipartFile file=null;
	@RequestMapping(value="/inner", method=RequestMethod.GET)
	public String inner(HttpServletRequest request,Model model) 
	{
		request.setAttribute("request", "request demo");
		request.getSession().setAttribute("session", "session demo");
		request.getServletContext().setAttribute("context", "context demo");
		model.addAttribute("hello","david");	
		return "inner";
	}
	
	
	@RequestMapping(value="/lesson", method=RequestMethod.GET)
	public String lesson(Model model) 
	{
		model.addAttribute("hello","david");
		model.addAttribute("name","<span style='color:red;'>laoli</span>");
		return "lesson";
	}
	@RequestMapping(value="/show", method=RequestMethod.GET)
	public String index(@RequestParam(name="name")String name,Model model) 
	{
		model.addAttribute("hello","david");
		model.addAttribute("name",name);
		return "view/message_show";
	}

}
