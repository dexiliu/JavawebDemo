package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import service.PermissionService;
import bean.Permission;
import dao.PermissionDao;

public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionDao permissionDao;
	
	@Override
	public void insert(Permission permission) {
		permissionDao.insert(permission);
	}

	@Override
	public void deleteById(int id) {
		permissionDao.deleteById(id);
	}
	
	@Override
	public void update(Permission permission) {
		permissionDao.update(permission);
	}

	@Override
	public Permission getById(int id) {
		return permissionDao.getById(id);
	}

	@Override
	public List<Permission> getAll() {
		return permissionDao.getAll();
	}

	@Override
	public List<Permission> getByUserId(int userId) {
		return permissionDao.getByUserId(userId);
	}

}
