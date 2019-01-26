package com.imooc.logo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.imooc.logo.vo.Dept;

@Mapper
public interface IDeptDAO 
{
   public List<Dept> findAll();
   
   public boolean doCreate(Dept dept);
}
