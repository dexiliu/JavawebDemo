package service;

import bean.User;
import bean.querypage.Page;
import bean.querypage.UserQp;

public interface UserService {
	public void insert(User user);

	public void update(User user);
	
	public Page getPage(UserQp qp);
	
	public User getById(int id);
	
	public User getByUserName(String username);
}
