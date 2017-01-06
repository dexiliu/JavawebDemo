package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.NewsDao;
import com.dao.impl.NewsDaoImpl;
import com.model.News;
import com.model.PageModel;
import com.utils.AppException;
import com.utils.DBUtil;

public class NewsService {

	private NewsDao newsDao=null;//定义一个newsDao接口对象
	
	/*
	 * 无参构造方法用来初始化数据访问层实例
	 */
	public NewsService(){
		newsDao= new NewsDaoImpl();
	}
	
	/*
	 * 创建新闻
	 * 
	 */
	public boolean createNews(News news) throws AppException{
		boolean flag=false;//定义标识
		
		try{
			flag=newsDao.add(news);//保存新闻信息
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.createNews");
		}
		return flag;
	}
	
	/**
	 * 通过新闻状态来获取新闻信息
	 * @param state
	 * @return
	 * @throws AppException
	 */
	public List<News> getList( int state) throws AppException{
		List<News> newsList=null;//声明新闻列表
		try{
			newsList=newsDao.getList(state);//查询已发布的新闻列表
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.getList");
		}
		return newsList;
	}
	
	/**
	 * 通过用户id和新闻id来获取新闻信息
	 * @param userId
	 * @return
	 * @throws AppException
	 */
	public List<News> getListByuserId(int userId,int state) throws AppException{
		List<News> newsList=null;//声明新闻列表
		try{
			newsList=newsDao.getListByuserId(userId,state);//查询已发布的新闻列表
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.getListByuserId");
		}
		return newsList;
	}
	
	/**
	 * 通过新闻id来获取新闻信息
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public List<News> getListById(int id) throws AppException{
		List<News> newsList=null;//声明新闻列表
		try{
			newsList=newsDao.getListById(id);//查询已发布的新闻列表
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.getListById");
		}
		return newsList;
	}
	
	/**
	 * 根据新闻类型获取新闻标题
	 * @param newsTypeId
	 * @return newsList
	 * @throws AppException
	 */
	public List<News> getListByNewsTypeId(int newsTypeId) throws AppException{
		List<News> newsList=null;//声明新闻列表
		try{
			newsList=newsDao.getListByNewsTypeId(newsTypeId);//查询已发布的新闻列表
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.getListByNewsTypeId");
		}
		return newsList;
	}
	
	/**
	 * 获取最新的新闻
	 * 
	 * @throws AppException
	 */
	public List<News> getLatestList() throws AppException{
		List<News> newsList=null;//声明新闻列表
		try{
			newsList=newsDao.getLatestList();//查询已发布的新闻列表
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.getLatestList");
		}
		return newsList;
	}
	
	/**
	 * 获取点击率最高的新闻
	 * @return newsList
	 * @throws AppException
	 */
	public List<News> getListByClick() throws AppException{
		List<News> newsList=null;//声明新闻列表
		try{
			newsList=newsDao.getListByClick();//查询已发布的新闻列表
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.getListByClick");
		}
		return newsList;
	}
	
	/**
	 * 获取新闻
	 * @return newsList
	 * @throws AppException
	 */
	public List<News> getList1(int newsTypeId) throws AppException{
		List<News> newsList=null;//声明新闻列表
		try{
			newsList=newsDao.getList1(newsTypeId);//查询已发布的新闻列表
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.getList1()");
		}
		return newsList;
	}
	
	/**
	 * 审核新闻
	 * @param id
	 * @param state
	 * @return
	 * @throws AppException
	 */
	public boolean ModifyNewsState(int id,int state) throws AppException{
		boolean flag=false;
		
		try{
			flag=newsDao.ModifyNewsState(id,state);
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.ModifyNewsState");
		}
		return flag;
	}
	
	/**
	 * 搜索新闻
	 * @param content
	 * @return
	 * @throws AppException
	 */
    public List<News> searchNews(String content) throws AppException{
    	List<News> newsList=null;//声明新闻列表
		try{
			newsList=newsDao.searchNews(content);//查询已发布的新闻列表
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.searchNews");
		}
		return newsList;
   	}
    
  
    
    public boolean DelNews(int id) throws AppException{
    	boolean flag=false;
    	try{
    		flag=newsDao.DelNews(id);
    	}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.DelNews");
		}
    	return flag;
    }
    
    /**
     * 点击率
     * @param id
     * @throws AppException
     */
    public void addClick(int id) throws AppException{
    	
    	try{
    		newsDao.addClick(id);
    	}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.addClick");
		}
    }
}
