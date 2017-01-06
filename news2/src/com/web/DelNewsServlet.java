package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.NewsService;
import com.utils.AppException;


public class DelNewsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����������ַ���Ϊ"utf-8"
		request.setCharacterEncoding("utf-8");
		
		
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		
		try{
			NewsService newsService=new NewsService();
			if(newsService.DelNews(id)){
				//ת������������ҳ��
				request.getRequestDispatcher("success5.jsp").forward(request, response);
			}
		}catch(AppException e){
			e.printStackTrace();
			//�ض����쳣ҳ��
			response.sendRedirect("toError");
		}
		
	}

}
