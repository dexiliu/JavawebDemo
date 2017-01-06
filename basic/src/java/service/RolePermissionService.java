package service;

import java.util.List;

import bean.RolePermission;

public interface RolePermissionService {
	public void insert(RolePermission rolePermission);
	
	void deleteByRoleId(int roleId);
	
	List<RolePermission> getByRoleId(int roleId);
}
