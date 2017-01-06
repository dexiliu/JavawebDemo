package com.servlet.service.impl;

import java.util.List;

import com.servlet.dao.UserDao;
import com.servlet.dao.impl.UserDaoImpl;
import com.servlet.entity.User;
import com.servlet.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao=new UserDaoImpl();
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	@Override
	public List<User> getAllUser() {
		
		return userDao.getAllUser();
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
		
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

}
