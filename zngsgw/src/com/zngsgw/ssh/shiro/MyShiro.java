package com.zngsgw.ssh.shiro;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

import com.zngsgw.ssh.entity.demo.Role;
import com.zngsgw.ssh.entity.demo.User;
import com.zngsgw.ssh.service.demo.UserServiceI;

@Service
@Transactional
public class MyShiro extends AuthorizingRealm {

	@Resource
	private UserServiceI userService;
	
	/**
	 * 权限认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//获取登录时输入的用户名
		String loginName=(String)principalCollection.fromRealm(getName()).iterator().next();
		//到数据库查是否有此对象
		User user=userService.findByUserName(loginName);
		if(user!=null){
			//权限信息对象info，用来存放查出的用户的所有角色（role）及权限（permission）
			SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
			//用户的角色集合
			info.setRoles(user.getRolesName());
			//用户的角色对应的所有权限，如果只使用角色定义访问权限，下面四行可以不要
			List<Role> roleList=user.getRoleList();
			for(Role role:roleList){
				info.addStringPermissions(role.getPermissionsName());
			}
			return info;
		}
		return null;
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken) throws AuthenticationException {
		//UsernamePasswordToken对象用来存放提交的登录信息
		UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
		//查出是否有此用户
		User user=userService.findByUserName(token.getUsername());
		if(user!=null){
			//若存在，将此用户存放到登录谁info中
			return new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),getName());
		}
		return null;
	}

}
