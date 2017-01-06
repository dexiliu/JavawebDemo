package bean;

public class UserRole implements java.io.Serializable {
	private static final long serialVersionUID = -3485699073693738813L;

	private int userId;
	private int roleId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
