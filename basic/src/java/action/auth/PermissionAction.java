package action.auth;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import service.PermissionService;
import action.base.BasicAction;
import bean.Permission;

public class PermissionAction extends BasicAction {
	private static final long serialVersionUID = 1L;

	private int id;
	private Permission permission;
	
	private PermissionService permissionService;
	
	public String add() {
		return "add";
	}
	
	public String edit() {
		permission = permissionService.getById(id);
		return "edit";
	}
	
	public String save() {
		if(StringUtils.isBlank(permission.getValue()))
			errorMap.put("value", "请输入权限值！");
		if(!errorMap.isEmpty()) return INPUT;
		
		// update
		if(id > 0) {
			Permission permissionIndb = permissionService.getById(id);
			permissionIndb.setName("");
			permissionIndb.setValue(permission.getValue());
			permissionService.update(permissionIndb);
			
		// add
		} else {
			permission.setName("");
			permissionService.insert(permission);	
		}
		
		return SUCCESS;
	}
	
	public String delete() {
		permissionService.deleteById(id);
		
		return SUCCESS;
	}
	
	public String list() {
		List<Permission> permissions = permissionService.getAll();
		super.getRequest().setAttribute("permissions", permissions);
		
		return "list";
	}
	
	// ==================================================================
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public PermissionService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

}
