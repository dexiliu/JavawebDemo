package com.zngsgw.ssh.entity.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity(name="t_role")
public class Role implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String roleName;
	private List<Permission> permissionList;
	private List<User> userList;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public String getRoleName() {
		return roleName;
	}
	@OneToMany(mappedBy="role")
	public List<Permission> getPermissionList() {
		return permissionList;
	}
	@ManyToMany
	@JoinTable(name="t_user_role",joinColumns={@JoinColumn(name="role_id")},
	inverseJoinColumns={@JoinColumn(name="user_id")})
	public List<User> getUserList() {
		return userList;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	@Transient
	public List<String> getPermissionsName(){
		List<String> list=new ArrayList<String>();
		List<Permission> perlist=getPermissionList();
		for(Permission per:perlist){
			list.add(per.getPermissionName());
		}
		return list;
	}
	
}
