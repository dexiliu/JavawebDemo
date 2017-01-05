package com.zngsgw.ssh.test.news;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zngsgw.ssh.entity.demo.User;
import com.zngsgw.ssh.service.demo.UserServiceI;

public class NewsTest {

//	@Autowired
//	private UserServiceI userService;
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	UserServiceI userService=(UserServiceI)context.getBean("userService");
	User user=new User();
	
	@Test
	public void testUpdate() {
		
		user=userService.findById(1l);
		user.setUserName("hello");
		userService.update(user);
	}
	
	@Test
	public void testSave(){
		user.setId(3l);
		user.setUserName("wotreer");
		user.setPassword("123fgd456");
		userService.save(user);
	}

}
