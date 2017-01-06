package service;

import java.util.List;

import bean.UserRole;

public interface UserRoleService {
	public void insert(UserRole userRole);
	
	void deleteByUserId(int userId);
	
	List<UserRole> getByUserId(int userId);
}
