package com.imooc.logo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.logo.dao.IDeptDAO;
import com.imooc.logo.service.IDeptService;
import com.imooc.logo.vo.Dept;

@Service
public class DeptServiceImpl implements IDeptService 
{
	@Autowired
	private IDeptDAO deptDAO;
	
	@Override
	public List<Dept> list() 
	{
		 List<Dept> deptList= deptDAO.findAll();
		 return deptList;
	}

	@Override
	public boolean add(Dept dept) 
	{
		boolean isSuccess=deptDAO.doCreate(dept);
		return isSuccess;
	}
}
