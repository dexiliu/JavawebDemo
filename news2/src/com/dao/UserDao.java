package com.dao;

import java.util.List;

import com.model.User;
import com.utils.AppException;

public interface UserDao {

	public boolean add(User user) throws AppException;
	
	public boolean isExist(String name) throws AppException;
	
	public int login(String name,String password) throws AppException;
	
	public int getRoleById(int id) throws AppException;
	
	public List<User> getUser() throws AppException;
	
	public boolean delUser(int userId) throws AppException;
	
	public List<User> getUserById(int id) throws AppException;
	
	public boolean ModifyUser(User user) throws AppException;

	public boolean addUser(User user) throws AppException;

}
