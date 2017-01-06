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


public class getInternationalNewsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置请求的字符集为"UTF-8"
	    request.setCharacterEncoding("UTF-8");
	    
	    try{
			//初始化新闻类型id
			int id1=1;
			
			// 初始化新闻业务逻辑类
			NewsService newsService = new NewsService();

			// 声明新闻列表集合
			List<News> newsList1 = null;
			
			// 调用业务逻辑层获取新闻列表
			
			newsList1 = newsService.getList1(id1);
			
			// 将newsList保存到request中
			if(newsList1!=null){
				System.out.println("newsList1已获取到！");
				request.setAttribute("newsList1", newsList1);
				request.getRequestDispatcher("/International.jsp").forward(request,
						response);
			}else{
				System.out.println("newsList1获取不到！");
			}
			
			
	}catch (AppException e) {
		e.printStackTrace();
		// 重定向到异常页面
		response.sendRedirect("toError");
	}
	}
}
