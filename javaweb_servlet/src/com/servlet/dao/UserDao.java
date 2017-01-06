package com.servlet.dao;

import java.util.List;

import com.servlet.entity.User;

public interface UserDao {

	/**
	 * ����û�
	 * @param user
	 */
	public void addUser(User user);
	
	public List<User> getAllUser();
	
	public void deleteUser(int id);
	
	public void updateUser(User user);
	
}
