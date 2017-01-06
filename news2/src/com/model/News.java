package com.model;


/*
 * 新闻实体类News
 */

public class News {

	private int id;
	private String title;//新闻标题
	private String author;//作者
	private int newsTypeId;//新闻类别id
	private int userId;//录入者，用户id
	private String keywords;//关键字
	private String source;//新闻来源
	private String content;//新闻内容
	private String createTime;//创建时间
	private int click;//点击次数
	private int state;//新闻状态，0未发布，1已发布,2不通过
	private int del;//删除状态，0未删除，1已删除
	
	
	
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
