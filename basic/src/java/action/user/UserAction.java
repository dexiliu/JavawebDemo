package action.user;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import service.RoleService;
import service.UserRoleService;
import service.UserService;
import action.base.BasicAction;
import bean.Role;
import bean.User;
import bean.UserRole;
import bean.querypage.UserQp;

public class UserAction extends BasicAction {
	private static final long serialVersionUID = 1L;

	private UserQp qp;
	private int id;
	private int[] roleIds;
	private User user;
	private String username;
	private String password;
	private String rememberMe;

	private UserService userService;
	private RoleService roleService;
	private UserRoleService userRoleService;
	
	/**
	 * 到登陆页面 。
	 */
	public String index() {
		return "index";
	}

	/**
	 * 用户登录 。
	 */
	public String login() {
		try {
			AuthenticationToken token = new UsernamePasswordToken(username,
					password);// username和password是从表单提交过来的
			Subject currentUser = SecurityUtils.getSubject();
			currentUser.login(token);
			return "login";
		} catch (AuthenticationException e) {
			errorMap.put("loginerror", "用户名或密码错误!");
			return "loginInput";
		}
	}

	/**
	 * 用户登出 。
	 */
	public String logout() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();

		return "logout";
	}
	
	
	public String add() {
		return "add";
	}
	
	public String edit() {
		// 用于给之前选中的角色设置选中状态
		List<UserRole> tUserRoles =  userRoleService.getByUserId(id);
		roleIds = new int[tUserRoles.size()];
		for (int i=0; i<tUserRoles.size(); i++) {
			roleIds[i] = tUserRoles.get(i).getRoleId();
		}
		
		user = userService.getById(id);
		return "edit";
	}
	
	public String save() {
		if(StringUtils.isBlank(user.getUsername()))
			errorMap.put("username", "用户名不能为空！");
		if(StringUtils.isBlank(user.getPassword()))
			errorMap.put("password", "请输入密码！");
		if(!StringUtils.equals(user.getPassword(), user.getRepeatPassword())) {
			errorMap.put("repeatPassword", "两次输入的密码不一致！");
		}
		if(StringUtils.isBlank(user.getName()))
			errorMap.put("name", "请输入昵称！");
		
		if(!errorMap.isEmpty()) return INPUT;
		
		// update
		if(id > 0) {
			User userIndb = userService.getById(id);
			userIndb.setUsername(user.getUsername());
			userIndb.setPassword(user.getPassword());
			userIndb.setName(user.getName());
			userService.update(userIndb);
			
		// add
		} else {
			userService.insert(user);	
		}
		
		// 处理用户拥有的角色（映射表），先删后加
		userRoleService.deleteByUserId(id);
		if (ArrayUtils.isNotEmpty(roleIds)) {
			for (int roleId : roleIds) {
				UserRole tUserRole = new UserRole();
				tUserRole.setUserId(id);
				tUserRole.setRoleId(roleId);
				userRoleService.insert(tUserRole);
			}
		}

		
		return SUCCESS;
	}
	
	public String list() {
		if(qp == null) qp = new UserQp();
		qp = (UserQp)userService.getPage(qp);
		
		return "list";
	}
	
	public List<Role> getRoles() {
		return roleService.getAll();
	}
	
	// ==================================================================
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}

	public UserQp getQp() {
		return qp;
	}

	public void setQp(UserQp qp) {
		this.qp = qp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(int[] roleIds) {
		this.roleIds = roleIds;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public UserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

}
