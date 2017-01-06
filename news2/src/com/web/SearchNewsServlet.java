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


public class SearchNewsServlet extends HttpServlet {
	
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String keywords=request.getParameter("name");
		System.out.println("关键字是:"+keywords);
		if(keywords==null){
			request.getRequestDispatcher("/failure.jsp").forward(request, response);
		}else{
			try{
				NewsService newsService=new NewsService();
				List<News> newsList=null;
				newsList=newsService.searchNews(keywords);
				if(newsList!=null){
					request.setAttribute("newsList",newsList);
					request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
				}
			}catch (AppException e) {
				e.printStackTrace();
				// 重定向到异常页面
				response.sendRedirect("toError");
			}
		}
	}
}
