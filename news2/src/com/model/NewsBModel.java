package com.model;

public class NewsBModel {

	private int id;//����id
	private String title;//���ű��� 
	private String creator;//¼����
	private String newsType;//�������
	private String source;//������Դ
	private String createTime;//����ʱ��
	
	/**
	 * 
	 * �޲ι��췽����Ϊ�������Ը���ʼֵ
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
