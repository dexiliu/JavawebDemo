package dao;

import java.util.List;

import bean.RolePermission;
import dao.base.BasicDao;

public interface RolePermissionDao extends BasicDao<RolePermission> {
	void deleteByRoleId(int roleId);
	List<RolePermission> getByRoleId(int roleId);
}
