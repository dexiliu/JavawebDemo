package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import service.UserRoleService;
import bean.UserRole;
import dao.UserRoleDao;

public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Override
	public void insert(UserRole userRole) {
		userRoleDao.insert(userRole);
	}

	@Override
	public void deleteByUserId(int userId) {
		userRoleDao.deleteByUserId(userId);
	}

	@Override
	public List<UserRole> getByUserId(int userId) {
		return userRoleDao.getByUserId(userId);
	}

}
