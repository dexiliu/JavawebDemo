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


public class getElectronicNewsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ����������ַ���Ϊ"UTF-8"
	    request.setCharacterEncoding("UTF-8");
	    
	    try{
			//��ʼ����������id
			int id7=7;
	
			// ��ʼ������ҵ���߼���
			NewsService newsService = new NewsService();

			// ���������б���
			
			List<News> newsList7 = null;
			
			// ����ҵ���߼����ȡ�����б�
			
			
			newsList7 = newsService.getList1(id7);
			
			if(newsList7!=null){
				request.setAttribute("newsList7", newsList7);
				request.getRequestDispatcher("/Electronic.jsp").forward(request,
						response);
			}
            
            
			
	}catch (AppException e) {
		e.printStackTrace();
		// �ض����쳣ҳ��
		response.sendRedirect("toError");
	}
	}

}
