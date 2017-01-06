package com.model;


/*
 * ����ʵ����News
 */

public class News {

	private int id;
	private String title;//���ű���
	private String author;//����
	private int newsTypeId;//�������id
	private int userId;//¼���ߣ��û�id
	private String keywords;//�ؼ���
	private String source;//������Դ
	private String content;//��������
	private String createTime;//����ʱ��
	private int click;//�������
	private int state;//����״̬��0δ������1�ѷ���,2��ͨ��
	private int del;//ɾ��״̬��0δɾ����1��ɾ��
	
	
	
	public News() {

		this.id = 0;
		this.title = "";
		this.author = "";
		this.newsTypeId = 0;
		this.userId = 0;
		this.keywords = "";
		this.source = "";
		this.content = "";
		this.createTime = "";
		this.click =0;
		this.state = 0;
		this.del = 0;
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



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public int getNewsTypeId() {
		return newsTypeId;
	}



	public void setNewsTypeId(int newsTypeId) {
		this.newsTypeId = newsTypeId;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getKeywords() {
		return keywords;
	}



	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}



	public String getSource() {
		return source;
	}



	public void setSource(String source) {
		this.source = source;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getCreateTime() {
		return createTime;
	}



	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}



	public int getClick() {
		return click;
	}



	public void setClick(int click) {
		this.click = click;
	}



	public int getState() {
		return state;
	}



	public void setState(int state) {
		this.state = state;
	}



	public int getDel() {
		return del;
	}



	public void setDel(int del) {
		this.del = del;
	}


	
	
}
