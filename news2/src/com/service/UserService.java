package com.service;

import java.util.List;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.model.News;
import com.model.User;
import com.utils.AppException;

public class UserService {
	
	private UserDao userDao = null;
	
	/**
	 * 用无参构造函数初始化UserDao实例
	 */
	public UserService() {
		userDao = new UserDaoImpl();
	}
	/**
	 * 用户注册
	 */
	public boolean register(User user) throws AppException {
		System.out.println("register!");
		boolean flag = false; // 定义标识
		try {
			//1.验证不存在同名用户
			if(!userDao.isExist(user.getName())) {
				//2.保存用户信息
				flag = userDao.add(user);
				System.out.println("注册成功!");
			}
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("com.service.UserService.register");
		}
		
		return flag;
	}
	
	/**
	 * 用户登录，成功后返回用户id
	 * @param name
	 * @param password
	 * @return
	 * @throws AppException
	 */
	public int login(String name,String password) throws AppException {
		int userId = -1;  //声明用户编号
		try {
			//获取用户编号
			userId = userDao.login(name, password);
		} catch(AppException e) {
			e.printStackTrace();
			throw new AppException("com.service.UserService.login");
		}
		//返回用户编号
		return userId;
	}
	
	/**
	 * 获取用户角色
	 * @param userId
	 * @return
	 * @throws AppException
	 */
    public int getUserRole(int userId) throws AppException{
    	int role=-1;//初始化角色
    	try{
    		//获取用户对应的角色编号
    		role=userDao.getRoleById(userId);
    	}catch(AppException e){
    		e.printStackTrace();
    		throw new AppException("com.service.UserService.getUserRole"); 
    	}
    	return role;
    }
    
    /**
     * 获取用户信息
     * @return
     * @throws AppException
     */
    public List<User> getUser() throws AppException{
    	List<User> userList=null;//声明用户信息列表
    	try{
    		userList=userDao.getUser();
    	}catch(AppException e){
    		e.printStackTrace();
    		throw new AppException("com.service.UserService.getUser");
		}
    	return userList;
    }
    
    /**
     * 根据用户id删除用户信息
     * @param userId
     * @return
     * @throws AppException
     */
    public boolean delUser(int userId) throws AppException{
    	boolean flag=false;
    	
    	try{
    		flag=userDao.delUser(userId);
    	}catch(AppException e){
    		e.printStackTrace();
    		throw new AppException("com.service.UserService.delUser");
		}
    	return flag;
    }
    
    /**
     * 
     * @param id
     * @return
     * @throws AppException
     */
    public List<User> getUserById(int id) throws AppException{
    	List<User> userList=null;
    	try{
    		userList=userDao.getUserById(id);
    	}catch(AppException e){
    		e.printStackTrace();
    		throw new AppException("com.service.UserService.getUserById");
		}
    	return userList;
    }
    
    
   	public boolean ModifyUser(User user) throws AppException {
   		boolean flag = false; // 定义标识
   		try {
   			flag = userDao.ModifyUser(user);
   			if(flag){
   				System.out.println("修改成功!");
   			}
   		} catch (AppException e) {
   			e.printStackTrace();
   			throw new AppException("com.service.UserService.ModifyUser");
   		}
   		
   		return flag;
   	}
   	
   	/**
   	 * 添加用户
   	 * @param user
   	 * @return
   	 * @throws AppException
   	 */
   	public boolean addUser(User user) throws AppException{
   		boolean flag=false;
   		try{
   			flag=userDao.addUser(user);
   			if(flag){
   				System.out.println("添加成功！");
   			}
   		}catch(AppException e){
   			e.printStackTrace();
   			throw new AppException("com.service.UserService.addUser");
   		}
   		return flag;
   	}
   	
   	
   	
}
