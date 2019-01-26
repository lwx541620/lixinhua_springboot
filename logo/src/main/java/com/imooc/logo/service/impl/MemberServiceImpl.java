package com.imooc.logo.service.impl;

import org.springframework.stereotype.Service;
import com.imooc.logo.service.IMemberService;
import com.imooc.logo.vo.Member;
@Service
public class MemberServiceImpl implements IMemberService
{
	@Override
	public Member get(long mid) 
	{
		// TODO Auto-generated method stub
		Member vo=new Member();
		vo.setMid(mid+"");
		vo.setAge(15);
		vo.setSalary(55555.0);
		return vo;
	}
}
