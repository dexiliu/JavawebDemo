package dao;

import java.util.List;

import bean.UserRole;
import dao.base.BasicDao;

public interface UserRoleDao extends BasicDao<UserRole> {
	void deleteByUserId(int userId);
	List<UserRole> getByUserId(int userId);
}
