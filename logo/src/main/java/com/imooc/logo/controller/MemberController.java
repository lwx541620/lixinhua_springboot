package com.imooc.logo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.logo.service.IMemberService;
import com.imooc.logo.vo.Member;

@Controller
public class MemberController 
{
   @Autowired
   private IMemberService iMemberService;
	
   @GetMapping(value="/member")	   
   public String member(Model model) 
   {
	   Member member=new Member();
	   member.setMid("101");
	   member.setAge(60);
	   member.setBirthday(new Date());
	   member.setSalary(188.5);
	   model.addAttribute("member", member);
	   return "member";
   }
  @InitBinder
  public void initBinder(WebDataBinder binder) 
  {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	CustomDateEditor custom=new CustomDateEditor(sdf,true);
	binder.registerCustomEditor(Date.class,custom);
  }
  
   @GetMapping(value="/get")
   @ResponseBody
   public String get() 
   {
	   return "hellowrold";
   }
   @RequestMapping(value="/pre",method=RequestMethod.GET)
   public String addPre() 
   {
	   return "add_pre";
   }
   @RequestMapping(value="/add",method=RequestMethod.POST)
   @ResponseBody
   public Object add(@Valid Member member,BindingResult result) {
	   if(result.hasErrors()) {
		   Iterator<ObjectError> iterator= result.getAllErrors().iterator();
		   while(iterator.hasNext()) {
			   ObjectError error=iterator.next();
			   System.out.println("错误编码:"+error.getCode()+"错误消息:"+error.getDefaultMessage());
		   }
		   return result.getAllErrors();
	   }else {
		   return member;
	   }
   }
   @RequestMapping(value="/member_add_pre",method=RequestMethod.GET)
   public String memberPreAdd() 
   {
	   return "member_add";
   }
   @RequestMapping(value="/member_add",method=RequestMethod.POST)
   @ResponseBody
   public Object memberAdd(Member member) 
   {
	  return member; 
   }
   
   @RequestMapping(value="/member_get",method=RequestMethod.GET)
   @ResponseBody
   public Object get(long mid) 
   {
	   Member member=iMemberService.get(mid);
	   return member;
   }
}
