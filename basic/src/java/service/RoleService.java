package service;

import java.util.List;

import bean.Role;

public interface RoleService {
	public void insert(Role role);

	public void deleteById(int id);
	
	public void update(Role role);
	
	public Role getById(int id);
	
	public List<Role> getAll();
	
	public List<Role> getByUserId(int userId);
	
}
