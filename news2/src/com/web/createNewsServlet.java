package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.News;
import com.service.NewsService;
import com.utils.AppException;

public class createNewsServlet extends HttpServlet {
	
       
	/*
	 * 处理post方式的创建新闻请求
	 * 
	 */
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求的字符集为"utf-8"
		request.setCharacterEncoding("utf-8");
		
		//声明session
		HttpSession session=null;
		//使用request对象取得session
		session=request.getSession();
		Integer userId=(Integer)session.getAttribute("userId");
		
		//若用户没有登录，则跳转到登录页面
		if(userId==null){
			response.sendRedirect("toLogin");
		}
		
		//获取新闻的数据信息
		String newsType=request.getParameter("newsTypeId");
		System.out.println("id=" + newsType);
		int newsTypeId=Integer.parseInt(newsType);
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String source=request.getParameter("source");
		String keywords=request.getParameter("keywords");
		String content=request.getParameter("content");
		String createTime=request.getParameter("createTime");
		
		//初始化提示信息
		String message="";
		
		//初始化新闻信息对象，并为改对象设置值
		News news=new News();
		news.setUserId(userId);
		news.setNewsTypeId(newsTypeId);
		news.setTitle(title);
		news.setAuthor(author);
		news.setKeywords(keywords);
		news.setSource(source);
		news.setContent(content);
		news.setCreateTime(createTime);
		news.setState(0);//设置新闻状态为“未审核”
		
		try{
			//初始化新闻业务逻辑类
			NewsService newsService=new NewsService();
			//操作成功或失败，返回创建新闻页面，给出提示信息
			if(newsService.createNews(news)){
				message="成功！";
				//将本次创建的新闻信息传递到页面上显示
				request.setAttribute("news", news);
			}else{
				message="失败！";
			}
			
			//将message保存到request中
			request.setAttribute("message", message);
			//转发到创建新闻页面
			request.getRequestDispatcher("toCreateNews").forward(request, response);
		}catch(AppException e){
			e.printStackTrace();
			//重定向到异常页面
			response.sendRedirect("toError");
		}
	}

}
