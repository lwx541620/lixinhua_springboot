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
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
@Controller
@RequestMapping(value="/dept")

@Api(value="用户controller",tags={"用户操作接口"})
public class DeptController 
{
	private final static Logger log=LoggerFactory.getLogger(DeptController.class);
	
	@Autowired
	private IDeptService deptService;
	
   @ApiOperation(value="实现部门的查询",notes="查询部门数量")
   @ApiImplicitParams({
	   @ApiImplicitParam(name="id",value="部门编号id",required=true,dataType="String")
   })
   @RequestMapping(value="/list",method=RequestMethod.GET)
   @ResponseBody
   public List<Dept> list(String id,Dept dept) 
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
