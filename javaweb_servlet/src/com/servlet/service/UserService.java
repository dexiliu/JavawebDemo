package com.servlet.service;

import java.util.List;

import com.servlet.entity.User;

public interface UserService {

	/**
	 * ����û�
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * ��ȡ�����û�
	 * @return
	 */
	public List<User> getAllUser();
	
	public void deleteUser(int id);
	
	public void updateUser(User user);
}
