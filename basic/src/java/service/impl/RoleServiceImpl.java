package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import service.RoleService;
import bean.Role;
import dao.RoleDao;

public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public void insert(Role role) {
		roleDao.insert(role);
	}

	@Override
	public void deleteById(int id) {
		roleDao.deleteById(id);
	}

	@Override
	public void update(Role role) {
		roleDao.update(role);
	}
	
	@Override
	public Role getById(int id) {
		return roleDao.getById(id);
	}

	@Override
	public List<Role> getAll() {
		return roleDao.getAll();
	}
	
	public List<Role> getByUserId(int userId){
		return roleDao.getByUserId(userId);
	}
}
