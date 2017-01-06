package com.servlet.service;

import java.util.List;

import com.servlet.entity.User;

public interface UserService {

	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 获取所有用户
	 * @return
	 */
	public List<User> getAllUser();
	
	public void deleteUser(int id);
	
	public void updateUser(User user);
}
