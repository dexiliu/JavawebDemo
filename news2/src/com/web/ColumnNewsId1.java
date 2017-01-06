package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.News;
import com.service.NewsService;
import com.utils.AppException;


public class ColumnNewsId1 extends HttpServlet {
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置请求的字符集为"UTF-8"
		request.setCharacterEncoding("UTF-8");
		
        try{
			//初始化新闻类型id
			int id1=1;
			int id2=2;
			int id3=3;
			int id4=4;
			int id5=5;
			int id6=6;
			int id7=7;
			// 初始化新闻业务逻辑类
			NewsService newsService = new NewsService();

			// 声明新闻列表集合
			List<News> newsList = null;
			List<News> newsList1 = null;
			List<News> newsList2 = null;
			List<News> newsList3 = null;
			List<News> newsList4 = null;
			List<News> newsList5 = null;
			List<News> newsList6 = null;
			List<News> newsList7 = null;
			List<News> newsList8 = null;
			// 调用业务逻辑层获取新闻列表
			newsList=newsService.getLatestList();
			newsList1 = newsService.getListByNewsTypeId(id1);
			newsList2 = newsService.getListByNewsTypeId(id2);
			newsList3 = newsService.getListByNewsTypeId(id3);
			newsList4 = newsService.getListByNewsTypeId(id4);
			newsList5 = newsService.getListByNewsTypeId(id5);
			newsList6 = newsService.getListByNewsTypeId(id6);
			newsList7 = newsService.getListByNewsTypeId(id7);
			newsList8 = newsService.getListByClick();
			// 将newsList保存到request中
			request.setAttribute("newsList", newsList);
			request.setAttribute("newsList1", newsList1);
			request.setAttribute("newsList2", newsList2);
			request.setAttribute("newsList3", newsList3);
			request.setAttribute("newsList4", newsList4);
			request.setAttribute("newsList5", newsList5);
			request.setAttribute("newsList6", newsList6);
			request.setAttribute("newsList7", newsList7);
			request.setAttribute("newsList8", newsList8);
			// 转发到我的新闻页面
			request.getRequestDispatcher("/firstPage.jsp").forward(request,
						response);
		} catch (AppException e) {
			e.printStackTrace();
			// 重定向到异常页面
			response.sendRedirect("toError");
		}
	}

}
