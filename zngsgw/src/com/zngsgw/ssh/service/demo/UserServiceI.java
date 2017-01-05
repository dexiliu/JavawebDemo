package com.zngsgw.ssh.service.demo;



import java.util.List;

import com.zngsgw.ssh.entity.demo.User;

public interface UserServiceI {

	//ԭ��ӿ��ṩ�ķ�����Ӧ��Serviceʵ��
		public void save(User user);
		
		public void update(User user);
		
		public User findById(Long id);
		
		public void delete(Long id);
		
		public List<User> findAllList();
	   
	    public User findByUserName(String userName);
}
