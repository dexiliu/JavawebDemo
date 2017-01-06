package dao;

import java.util.List;

import bean.Permission;
import dao.base.BasicDao;

public interface PermissionDao extends BasicDao<Permission> {
	List<Permission> getByUserId(int userId);
}
