package com.springsecurity.entity;

public class DbUser {

	private String username;
	private String password;
	private Integer access;
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public Integer getAccess() {
		return access;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAccess(Integer access) {
		this.access = access;
	}
	
	
}
