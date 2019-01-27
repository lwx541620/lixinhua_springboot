package com.imooc.logo.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Dept对象",description="部门对象Dept")
public class Dept implements Serializable 
{
   
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="部门编号",name="deptno",required=true)
	private Long deptno;
	@ApiModelProperty(value="部门名称",name="dname",required=true)	
	private String dname;
	
	public Long getDeptno() 
	{
		return deptno;
	}
	public void setDeptno(Long deptno) 
	{
		this.deptno = deptno;
	}
	public String getDname() 
	{
		return dname;
	}
	public void setDname(String dname) 
	{
		this.dname = dname;
	}
	@Override
	public String toString() 
	{
		return "Dept [deptno=" + deptno + ", dname=" + dname + "]";
	}
   
}
