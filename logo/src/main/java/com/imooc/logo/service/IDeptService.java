package com.imooc.logo.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.logo.vo.Dept;

public interface IDeptService 
{
  public List<Dept> list();
  
  @Transactional(propagation=Propagation.REQUIRED)
  public boolean add(Dept dept);
}
