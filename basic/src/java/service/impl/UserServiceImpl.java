package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import bean.User;
import bean.querypage.Page;
import bean.querypage.UserQp;

import service.UserService;
import dao.UserDao;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public User getById(int id) {
		return userDao.getById(id);
	}
	
	public User getByUserName(String username){
		return userDao.getByUserName(username);
	}

	@Override
	public Page getPage(UserQp qp) {
		qp.setTotalElements(userDao.getCountByQueryBean(qp));
		qp.setDatas(userDao.getByQueryBean(qp));
		return qp;
	}
	
}
