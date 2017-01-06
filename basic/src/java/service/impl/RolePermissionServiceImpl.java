package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import service.RolePermissionService;
import bean.RolePermission;
import dao.RolePermissionDao;

public class RolePermissionServiceImpl implements RolePermissionService {
	@Autowired
	private RolePermissionDao rolePermissionDao;
	
	@Override
	public void insert(RolePermission rolePermission) {
		rolePermissionDao.insert(rolePermission);
	}

	@Override
	public void deleteByRoleId(int roleId) {
		rolePermissionDao.deleteByRoleId(roleId);
	}

	@Override
	public List<RolePermission> getByRoleId(int roleId) {
		return rolePermissionDao.getByRoleId(roleId);
	}

}
