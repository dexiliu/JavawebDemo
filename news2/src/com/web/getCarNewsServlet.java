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


public class getCarNewsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置请求的字符集为"UTF-8"
	    request.setCharacterEncoding("UTF-8");
	    
	    try{
			//初始化新闻类型id
			int id6=6;
	
			// 初始化新闻业务逻辑类
			NewsService newsService = new NewsService();

			// 声明新闻列表集合
			
			List<News> newsList6 = null;
			
			// 调用业务逻辑层获取新闻列表
			
			
			newsList6 = newsService.getList1(id6);
			
			if(newsList6!=null){
				request.setAttribute("newsList6", newsList6);
				request.getRequestDispatcher("/Car.jsp").forward(request,
						response);
			}
            
            
			
	}catch (AppException e) {
		e.printStackTrace();
		// 重定向到异常页面
		response.sendRedirect("toError");
	}
	}

}
