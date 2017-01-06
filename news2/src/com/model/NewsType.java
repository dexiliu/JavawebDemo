package com.model;

/*
 * 新闻栏目实体类NewsType
 */

public class NewsType {

	private int id;
	private String name;//类型名称
	private String description;//描述
	private String createTime;//创建时间
	private int orders;//用于排序，默认0不排序，备用字段
	private int del;//删除状态，0代表未删除，1代表已删除
	

	
	
	public NewsType() {
		this.id = 0;
		this.name = "";
		this.description = "";
		this.createTime = "";
		this.orders = 0;
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




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getCreateTime() {
		return createTime;
	}




	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}




	public int getOrders() {
		return orders;
	}




	public void setOrders(int orders) {
		this.orders = orders;
	}




	public int getDel() {
		return del;
	}




	public void setDel(int del) {
		this.del = del;
	}
	
	
	
	
}
