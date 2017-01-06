/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import service.PermissionService;
import service.RoleService;
import service.UserService;
import bean.Permission;
import bean.Role;
import bean.User;

public class ShiroDbRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;
	
	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = userService.getByUserName(token.getUsername());
		if (user != null) {
			return new SimpleAuthenticationInfo(new ShiroUser(user.getId(),
					user.getUsername(), user.getName()), user.getPassword(),
					getName());
		} else {
			return null;
		}
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 加载用户的roles
		List<Role> roles = roleService.getByUserId(shiroUser.id);
		List<String> stringRoles = new ArrayList<String>(roles.size());
		for (Role role : roles) {
			stringRoles.add(role.getName());
		}
		info.addRoles(stringRoles);
		
		// 加载用户的permissions
		List<Permission> permissions = permissionService.getByUserId(shiroUser.id);
		Set<String> stringPermissions = new HashSet<String>(permissions.size());
		for (Permission permission : permissions) {
			stringPermissions.add(permission.getValue());
		}
		info.setStringPermissions(stringPermissions);
		
		return info;
	}

	//
	// /**
	// * 设定Password校验的Hash算法与迭代次数.
	// */
	// @PostConstruct
	// public void initCredentialsMatcher() {
	// HashedCredentialsMatcher matcher = new
	// HashedCredentialsMatcher(AccountService.HASH_ALGORITHM);
	// matcher.setHashIterations(AccountService.HASH_INTERATIONS);
	//
	// setCredentialsMatcher(matcher);
	// }
	//
	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {
		private static final long serialVersionUID = -1373760761780840081L;
		private int id;
		private String username;
		private String name;

		public ShiroUser(int id, String username, String name) {
			this.id = id;
			this.username = username;
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public String getUsername() {
			return username;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public void setName(String name) {
			this.name = name;
		}

		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return name;
		}

		// /**
		// * 重载equals,只计算loginName;
		// */
		// @Override
		// public int hashCode() {
		// return HashCodeBuilder.reflectionHashCode(this, "loginName");
		// }
		//
		// /**
		// * 重载equals,只比较loginName
		// */
		// @Override
		// public boolean equals(Object obj) {
		// return EqualsBuilder.reflectionEquals(this, obj, "loginName");
		// }
	}
}
