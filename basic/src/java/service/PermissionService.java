package service;

import java.util.List;

import bean.Permission;

public interface PermissionService {
	public void insert(Permission permission);

	public void deleteById(int id);
	
	public void update(Permission permission);
	
	public Permission getById(int id);
	
	public List<Permission> getAll();
	
	public List<Permission> getByUserId(int userId);
	
}
