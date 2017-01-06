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


public class ShowNewsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ����������ַ���Ϊ"UTF-8"
		request.setCharacterEncoding("UTF-8");
		
		
		try{
			
		    String idtype=request.getParameter("id");
		    int id=Integer.parseInt(idtype);
			// ��ʼ������ҵ���߼���
			NewsService newsService = new NewsService();

			// ���������б���
			List<News> newsList = null;
			// ����ҵ���߼����ȡ�����б�
			newsList = newsService.getListById(id);
			newsService.addClick(id);
			// ��newsList���浽request��
			request.setAttribute("newsList", newsList);
			// ת�����ҵ�����ҳ��
			request.getRequestDispatcher("/showNews.jsp").forward(request,
					response);
		} catch (AppException e) {
			e.printStackTrace();
			// �ض����쳣ҳ��
			response.sendRedirect("toError");
		}
	}

}
