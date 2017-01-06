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
	 * ���޲ι��캯����ʼ��UserDaoʵ��
	 */
	public UserService() {
		userDao = new UserDaoImpl();
	}
	/**
	 * �û�ע��
	 */
	public boolean register(User user) throws AppException {
		System.out.println("register!");
		boolean flag = false; // �����ʶ
		try {
			//1.��֤������ͬ���û�
			if(!userDao.isExist(user.getName())) {
				//2.�����û���Ϣ
				flag = userDao.add(user);
				System.out.println("ע��ɹ�!");
			}
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("com.service.UserService.register");
		}
		
		return flag;
	}
	
	/**
	 * �û���¼���ɹ��󷵻��û�id
	 * @param name
	 * @param password
	 * @return
	 * @throws AppException
	 */
	public int login(String name,String password) throws AppException {
		int userId = -1;  //�����û����
		try {
			//��ȡ�û����
			userId = userDao.login(name, password);
		} catch(AppException e) {
			e.printStackTrace();
			throw new AppException("com.service.UserService.login");
		}
		//�����û����
		return userId;
	}
	
	/**
	 * ��ȡ�û���ɫ
	 * @param userId
	 * @return
	 * @throws AppException
	 */
    public int getUserRole(int userId) throws AppException{
    	int role=-1;//��ʼ����ɫ
    	try{
    		//��ȡ�û���Ӧ�Ľ�ɫ���
    		role=userDao.getRoleById(userId);
    	}catch(AppException e){
    		e.printStackTrace();
    		throw new AppException("com.service.UserService.getUserRole"); 
    	}
    	return role;
    }
    
    /**
     * ��ȡ�û���Ϣ
     * @return
     * @throws AppException
     */
    public List<User> getUser() throws AppException{
    	List<User> userList=null;//�����û���Ϣ�б�
    	try{
    		userList=userDao.getUser();
    	}catch(AppException e){
    		e.printStackTrace();
    		throw new AppException("com.service.UserService.getUser");
		}
    	return userList;
    }
    
    /**
     * �����û�idɾ���û���Ϣ
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
   		boolean flag = false; // �����ʶ
   		try {
   			flag = userDao.ModifyUser(user);
   			if(flag){
   				System.out.println("�޸ĳɹ�!");
   			}
   		} catch (AppException e) {
   			e.printStackTrace();
   			throw new AppException("com.service.UserService.ModifyUser");
   		}
   		
   		return flag;
   	}
   	
   	/**
   	 * ����û�
   	 * @param user
   	 * @return
   	 * @throws AppException
   	 */
   	public boolean addUser(User user) throws AppException{
   		boolean flag=false;
   		try{
   			flag=userDao.addUser(user);
   			if(flag){
   				System.out.println("��ӳɹ���");
   			}
   		}catch(AppException e){
   			e.printStackTrace();
   			throw new AppException("com.service.UserService.addUser");
   		}
   		return flag;
   	}
   	
   	
   	
}
