package bean;

public class RolePermission implements java.io.Serializable {
	private static final long serialVersionUID = -4601735052238990131L;
	
	private int roleId;
	private int permissionId;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

}
