package dao;

import java.util.List;

import bean.Role;
import dao.base.BasicDao;

public interface RoleDao extends BasicDao<Role> {
	List<Role> getByUserId(int userId);
}
