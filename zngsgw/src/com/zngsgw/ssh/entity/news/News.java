package com.zngsgw.ssh.entity.news;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="t_news")
public class News implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String author;
	private String title;
	private String source;
	private String keywords;
	private String content;
	private String photoPath;
	private String createTime;
	private String creater;
	private String lastUpdater;
	private String lastUpdateTime;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	@Column(length=16)
	public String getAuthor() {
		return author;
	}
	@Column(length=100)
	public String getTitle() {
		return title;
	}
	@Column(length=32)
	public String getSource() {
		return source;
	}
	@Lob
	public String getContent() {
		return content;
	}
	@Column(length=100)
	public String getPhotoPath() {
		return photoPath;
	}
	public String getCreateTime() {
		return createTime;
	}
	@Column(length=50)
	public String getKeywords() {
		return keywords;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getLastUpdater() {
		return lastUpdater;
	}
	public void setLastUpdater(String lastUpdater) {
		this.lastUpdater = lastUpdater;
	}
	public String getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public void setCreateTime(String createTime2) {
		this.createTime = createTime2;
	}
	
	
}
