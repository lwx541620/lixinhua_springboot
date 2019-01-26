package com.imooc.logo;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import com.imooc.logo.service.IDeptService;
import com.imooc.logo.service.IMessageProducerService;
import com.imooc.logo.vo.Dept;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogoApplicationTests 
{
	private static Logger logger=LoggerFactory.getLogger(LogoApplicationTests.class);
	@Autowired
	private DataSource datasource;
	@Autowired
	private IDeptService deptService;
	@Autowired
	private IMessageProducerService producerService;
	
	@Autowired
	private JavaMailSender mailSender;
	@Test
	public void contextLoads()
	{
	}
	/*@Test
	 * public void test11() throws SQLException {
	 * System.out.println(datasource.getConnection()); }
	 * 
	 * @Test public void test22() throws SQLException {
	 * System.out.println(deptService.list()); }
	 */
	
	/*
	 * @Test public void test33() throws SQLException { logger.debug("hello world");
	 * logger.error("eoorooe"); Dept dept=new Dept(); dept.setDname("test2222");
	 * this.deptService.add(dept); }
	 */
	
	/*
	 * @Test public void test55() { producerService.sendMessage("hello wrold"); }
	 */
	
	@Test
	public void test66() 
	{
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("568623537@qq.com");
		message.setTo("fclixiang@sina.com");
		message.setSubject("测试邮件");
		message.setText("好好学习，天天向上");
		mailSender.send(message);
	}
	
}

