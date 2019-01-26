package com.imooc.logo.config;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectInfoContributor implements InfoContributor
{
	@Override
	public void contribute(Builder builder) {
		// TODO Auto-generated method stub
		builder.withDetail("hello1", "nihao");
		builder.withDetail("hello2", "nihao");
		builder.withDetail("hello3", "nihao");
		builder.withDetail("hello4", "nihao");

	}

}
