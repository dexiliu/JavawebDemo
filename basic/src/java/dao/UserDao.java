package dao;

import bean.User;
import dao.base.BasicDao;

public interface UserDao extends BasicDao<User> {
	User getByUserName(String username);
}
