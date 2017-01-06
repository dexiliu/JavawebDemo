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
		// ����������ַ���Ϊ"UTF-8"
	    request.setCharacterEncoding("UTF-8");
	    
	    try{
			//��ʼ����������id
			int id1=1;
			
			// ��ʼ������ҵ���߼���
			NewsService newsService = new NewsService();

			// ���������б���
			List<News> newsList1 = null;
			
			// ����ҵ���߼����ȡ�����б�
			
			newsList1 = newsService.getList1(id1);
			
			// ��newsList���浽request��
			if(newsList1!=null){
				System.out.println("newsList1�ѻ�ȡ����");
				request.setAttribute("newsList1", newsList1);
				request.getRequestDispatcher("/International.jsp").forward(request,
						response);
			}else{
				System.out.println("newsList1��ȡ������");
			}
			
			
	}catch (AppException e) {
		e.printStackTrace();
		// �ض����쳣ҳ��
		response.sendRedirect("toError");
	}
	}
}
