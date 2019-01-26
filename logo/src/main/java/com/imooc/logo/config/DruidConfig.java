package com.imooc.logo.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfig 
{
	@SuppressWarnings("rawtypes")
	@Bean
	public ServletRegistrationBean druidServlet() 
	   {
	   ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
	   servletRegistrationBean.addInitParameter("allow", "127.0.0.1,169.254.5.74");
	   servletRegistrationBean.addInitParameter("deny", "169.254.5.75");
	   servletRegistrationBean.addInitParameter("loginUsername", "hello");
	   servletRegistrationBean.addInitParameter("loginPassword", "world");
	   servletRegistrationBean.addInitParameter("resetEnable", "false");
	   return servletRegistrationBean;
      }	

   @SuppressWarnings({ "rawtypes", "unchecked" })
   @Bean
   public FilterRegistrationBean filterRegistrationBean() 
   {
	FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
	filterRegistrationBean.setFilter(new WebStatFilter());
	filterRegistrationBean.addUrlPatterns("/*");
	filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.css,/druid/*");
	return filterRegistrationBean;
   }
   
   @Bean
   @ConfigurationProperties(prefix="spring.datasource")	
   public DataSource druidDataSource() 
   {
	   return new DruidDataSource();
   }
}
