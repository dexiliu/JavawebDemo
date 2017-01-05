package com.zngsgw.ssh.service.demo;

import java.util.List;

import com.zngsgw.ssh.entity.demo.Users;

public interface UsersServiceI {

		public void save(Users users);
		
		public void update(Users users);
		
		public Users findById(Long id);
		
		public void delete(Long id);
		
		public List<Users> findAllList();
	   
	    public Users findByUsername(String username);
}
