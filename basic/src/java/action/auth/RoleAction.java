package action.auth;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import service.PermissionService;
import service.RolePermissionService;
import service.RoleService;
import action.base.BasicAction;
import bean.Permission;
import bean.Role;
import bean.RolePermission;

public class RoleAction extends BasicAction {
	private static final long serialVersionUID = 1L;

	private int id;
	private int[] permissionIds;
	private Role role;
	
	private RoleService roleService;
	private PermissionService permissionService;
	private RolePermissionService rolePermissionService;
	
	public String add() {
		return "add";
	}
	
	public String edit() {
		// 用于给之前选中的权限设置选中状态
		List<RolePermission> tRolePermissions =  rolePermissionService.getByRoleId(id);
		permissionIds = new int[tRolePermissions.size()];
		for (int i=0; i<tRolePermissions.size(); i++) {
			permissionIds[i] = tRolePermissions.get(i).getPermissionId();
		}
		
		role = roleService.getById(id);
		return "edit";
	}
	
	public String save() {
		if(StringUtils.isBlank(role.getName()))
			errorMap.put("name", "请输入角色名！");
		if(!errorMap.isEmpty()) return INPUT;
		
		// update
		if(id > 0) {
			Role roleIndb = roleService.getById(id);
			roleIndb.setName(role.getName());
			roleIndb.setWeight(role.getWeight());
			roleService.update(roleIndb);
			
		// add
		} else {
			roleService.insert(role);
			id = role.getId();
		}
		
		// 处理角色拥有的权限（映射表），先删后加
		rolePermissionService.deleteByRoleId(id);
		if (ArrayUtils.isNotEmpty(permissionIds)) {
			for (int permissionId : permissionIds) {
				RolePermission tRolePermission = new RolePermission();
				tRolePermission.setRoleId(id);
				tRolePermission.setPermissionId(permissionId);
				rolePermissionService.insert(tRolePermission);
			}
		}
		
		return SUCCESS;
	}
	
	public String delete() {
		roleService.deleteById(id);
		
		return SUCCESS;
	}
	
	public String list() {
		List<Role> roles = roleService.getAll();
		super.getRequest().setAttribute("roles", roles);
		
		return "list";
	}
	
	public List<Permission> getPermissions() {
		return permissionService.getAll();
	}
	
	// ==================================================================
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int[] getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(int[] permissionIds) {
		this.permissionIds = permissionIds;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public PermissionService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public RolePermissionService getRolePermissionService() {
		return rolePermissionService;
	}

	public void setRolePermissionService(RolePermissionService rolePermissionService) {
		this.rolePermissionService = rolePermissionService;
	}
	
}
