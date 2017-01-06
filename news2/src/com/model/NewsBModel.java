package com.model;

public class NewsBModel {

	private int id;//新闻id
	private String title;//新闻标题 
	private String creator;//录入者
	private String newsType;//新闻类别
	private String source;//新闻来源
	private String createTime;//创建时间
	
	/**
	 * 
	 * 无参构造方法，为对象属性赋初始值
	 */
	public NewsBModel(){
		this.id=0;
		this.title="";
		this.creator="";
		this.newsType="";
		this.source="";
		this.createTime="";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}


	public String getCreator() {
		return creator;
	}


	public void setCreator(String creator) {
		this.creator = creator;
	}


	public String getNewsType() {
		return newsType;
	}


	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getCreateTime() {
		return createTime;
	}


	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
