package com.imooc.logo.controller;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.logo.service.IDeptService;
import com.imooc.logo.vo.Dept;

@Controller
@RequestMapping(value="/dept")
public class DeptController 
{
	private final static Logger log=LoggerFactory.getLogger(DeptController.class);
	
	@Autowired
	private IDeptService deptService;
	
   @RequestMapping(value="/list",method=RequestMethod.GET)
   @ResponseBody
   public List<Dept> list() 
   {
	   List<Dept> deptList=deptService.list(); 
	   return deptList;	  
   }
   @GetMapping("/add")
   @ResponseBody
   public  String addDept() 
   {
	   Dept dept=new Dept();
	   Random random=new Random(1000);
	   int number=random.nextInt();
	   dept.setDname("dept"+number);
	   deptService.add(dept);
	   return "success";
   }
}
