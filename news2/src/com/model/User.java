package com.model;

/*
 *用户实体类User
 */

public class User {

	private int id;
	private String name;//用户名称
	private String password;//密码
	private int role;//用户角色 
	private int del;//删除状态，0未删除，1已删除
	
    
    
	public User() {
		this.id = 0;
		this.name = "";
		this.password = "";
		this.role = 0;
		this.del = 0;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getRole() {
		return role;
	}



	public void setRole(int role) {
		this.role = role;
	}



	public int getDel() {
		return del;
	}



	public void setDel(int del) {
		this.del = del;
	}

	
	
	
}
