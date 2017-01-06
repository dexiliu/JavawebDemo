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

	private NewsDao newsDao=null;//����һ��newsDao�ӿڶ���
	
	/*
	 * �޲ι��췽��������ʼ�����ݷ��ʲ�ʵ��
	 */
	public NewsService(){
		newsDao= new NewsDaoImpl();
	}
	
	/*
	 * ��������
	 * 
	 */
	public boolean createNews(News news) throws AppException{
		boolean flag=false;//�����ʶ
		
		try{
			flag=newsDao.add(news);//����������Ϣ
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.createNews");
		}
		return flag;
	}
	
	/**
	 * ͨ������״̬����ȡ������Ϣ
	 * @param state
	 * @return
	 * @throws AppException
	 */
	public List<News> getList( int state) throws AppException{
		List<News> newsList=null;//���������б�
		try{
			newsList=newsDao.getList(state);//��ѯ�ѷ����������б�
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.getList");
		}
		return newsList;
	}
	
	/**
	 * ͨ���û�id������id����ȡ������Ϣ
	 * @param userId
	 * @return
	 * @throws AppException
	 */
	public List<News> getListByuserId(int userId,int state) throws AppException{
		List<News> newsList=null;//���������б�
		try{
			newsList=newsDao.getListByuserId(userId,state);//��ѯ�ѷ����������б�
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.getListByuserId");
		}
		return newsList;
	}
	
	/**
	 * ͨ������id����ȡ������Ϣ
	 * @param id
	 * @return
	 * @throws AppException
	 */
	public List<News> getListById(int id) throws AppException{
		List<News> newsList=null;//���������б�
		try{
			newsList=newsDao.getListById(id);//��ѯ�ѷ����������б�
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.getListById");
		}
		return newsList;
	}
	
	/**
	 * �����������ͻ�ȡ���ű���
	 * @param newsTypeId
	 * @return newsList
	 * @throws AppException
	 */
	public List<News> getListByNewsTypeId(int newsTypeId) throws AppException{
		List<News> newsList=null;//���������б�
		try{
			newsList=newsDao.getListByNewsTypeId(newsTypeId);//��ѯ�ѷ����������б�
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.getListByNewsTypeId");
		}
		return newsList;
	}
	
	/**
	 * ��ȡ���µ�����
	 * 
	 * @throws AppException
	 */
	public List<News> getLatestList() throws AppException{
		List<News> newsList=null;//���������б�
		try{
			newsList=newsDao.getLatestList();//��ѯ�ѷ����������б�
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.getLatestList");
		}
		return newsList;
	}
	
	/**
	 * ��ȡ�������ߵ�����
	 * @return newsList
	 * @throws AppException
	 */
	public List<News> getListByClick() throws AppException{
		List<News> newsList=null;//���������б�
		try{
			newsList=newsDao.getListByClick();//��ѯ�ѷ����������б�
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.getListByClick");
		}
		return newsList;
	}
	
	/**
	 * ��ȡ����
	 * @return newsList
	 * @throws AppException
	 */
	public List<News> getList1(int newsTypeId) throws AppException{
		List<News> newsList=null;//���������б�
		try{
			newsList=newsDao.getList1(newsTypeId);//��ѯ�ѷ����������б�
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("com.service.NewsService.getList1()");
		}
		return newsList;
	}
	
	/**
	 * �������
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
	 * ��������
	 * @param content
	 * @return
	 * @throws AppException
	 */
    public List<News> searchNews(String content) throws AppException{
    	List<News> newsList=null;//���������б�
		try{
			newsList=newsDao.searchNews(content);//��ѯ�ѷ����������б�
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
     * �����
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
