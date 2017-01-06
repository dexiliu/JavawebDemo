package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.News;
import com.service.NewsService;
import com.utils.AppException;

public class IndexServlet extends HttpServlet {

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");  //设置输出内容的编码
        
        int state=-1;
		String state1=request.getParameter("state");
		
		if(null!=state1){
			
			state=Integer.parseInt(state1);
		}
		
		request.setAttribute("state",state);
		
		try{
			//初始化新闻业务逻辑类
			NewsService newsService=new NewsService();
			//声明新闻列表集合
			List<News> newsList=null;
			//调用业务逻辑层获取新闻列表
			newsList=newsService.getList(state);
			//将newsList保存到request中
			request.setAttribute("newsList", newsList);
			//转发
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}catch(AppException e){
			e.printStackTrace();
			//重定向到异常页面
			response.sendRedirect("toError");
		}
	}

}
