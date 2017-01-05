package com.zngsgw.ssh.service.demo;



import java.util.List;

import com.zngsgw.ssh.entity.demo.Permission;

public interface PermissionServiceI {

		public void save(Permission permission);
		
		public void update(Permission permission);
		
		public Permission findById(Long id);
		
		public void delete(Long id);
		
		public List<Permission> findAllList();
	   
	    public Permission findByPermissionName(String permissionName);
}
