package com.zngsgw.ssh.service.demo;

import java.util.List;

import com.zngsgw.ssh.entity.demo.Role;

public interface RoleServiceI {

		public void save(Role role);
		
		public void update(Role role);
		
		public Role findById(Long id);
		
		public void delete(Long id);
		
		public List<Role> findAllList();
	   
	    public Role findByRoleName(String roleName);
}
