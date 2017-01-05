package com.zngsgw.ssh.entity.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 用户实体
 * 
 * 
 */
@Entity(name="c_user")
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3105563317606820243L;
	private Long id;
	private String username; // 用户名
	private String password; // 密码
	private String chineseName; // 姓名
	private Boolean enabled; // 是否可用
	private String mainRole; // 基础角色
	private String uniqueId; // 各系统的之间用户唯一id（memberId）

	public Users() {
	}

	public Users(Long id) {
		setId(id);

	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users(Boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name="user_name")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="pass_word")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="chinese_name")
	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	@Column(name="enabled")
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name="mainRole")
	public String getMainRole() {
		return mainRole;
	}

	public void setMainRole(String mainRole) {
		this.mainRole = mainRole;
	}

	@Column(name="unique_id")
	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

}
