package com.dao;

import java.util.List;

import com.model.News;
import com.utils.AppException;

public interface NewsDao {

	public boolean add(News news) throws AppException;
	
	public List<News> getList(int state) throws AppException;
	
	public List<News> getListByuserId(int userId,int state) throws AppException;
	
	public List<News> getListById(int id) throws AppException;
	
	public List<News> getListByNewsTypeId(int newsTypeId) throws AppException;
	
	public List<News> getLatestList() throws AppException;
	
	public List<News> getListByClick() throws AppException;
	
	public List<News> getList1(int newsTypeId) throws AppException;
	
	public boolean ModifyNewsState(int id,int state) throws AppException;
	
	public List<News> searchNews(String content) throws AppException;
	
	public boolean DelNews(int id) throws AppException;
	
	public void addClick(int id) throws AppException;
}

