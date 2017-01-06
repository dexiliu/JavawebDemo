package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.News;
import com.service.NewsService;
import com.utils.AppException;


public class getSportsNewsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置请求的字符集为"UTF-8"
	    request.setCharacterEncoding("UTF-8");
	    
	    try{
			//初始化新闻类型id
			int id4=4;
	
			// 初始化新闻业务逻辑类
			NewsService newsService = new NewsService();

			// 声明新闻列表集合
			
			List<News> newsList4 = null;
			
			// 调用业务逻辑层获取新闻列表
			
			
			newsList4 = newsService.getList1(id4);
			
			if(newsList4!=null){
				request.setAttribute("newsList4", newsList4);
				request.getRequestDispatcher("/Sports.jsp").forward(request,
						response);
			}
            
            
			
	}catch (AppException e) {
		e.printStackTrace();
		// 重定向到异常页面
		response.sendRedirect("toError");
	}
	}

}
