package com.model;

/*
 *�û�ʵ����User
 */

public class User {

	private int id;
	private String name;//�û�����
	private String password;//����
	private int role;//�û���ɫ 
	private int del;//ɾ��״̬��0δɾ����1��ɾ��
	
    
    
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
