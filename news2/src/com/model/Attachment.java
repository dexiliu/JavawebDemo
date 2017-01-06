package com.model;


/*
 * 合同附件实体类Attachment
 */

public class Attachment {

	private int id;
	private int newsId;
	private String fileName;//文件名称
	private String path;//文件路径
	private String type;//文件类型
	private String uploadTime;//文件上传时间
	private int del;//文件的删除状态，‘0’未删除，‘1’已删除
	
	
	public Attachment() {
		
		this.id = 0;
		this.newsId = 0;
		this.fileName = "";
		this.path = "";
		this.type = "";
		this.uploadTime = "";
		this.del = 0;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNewsId() {
		return newsId;
	}


	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getUploadTime() {
		return uploadTime;
	}


	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}


	public int getDel() {
		return del;
	}


	public void setDel(int del) {
		this.del = del;
	}

	
	
}
