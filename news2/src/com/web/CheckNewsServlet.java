package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.News;
import com.service.NewsService;
import com.utils.AppException;


public class CheckNewsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");  //����������ݵı���
		
		boolean flag=false;
		
		try{
			//��ʼ������ҵ���߼���
			NewsService newsService=new NewsService();
			//��ȡ��Ҫ�޸�״̬������id
			String id1=request.getParameter("id");
			String state1 = request.getParameter("state");
			int state=Integer.parseInt(state1);
			int id=Integer.parseInt(id1);
			flag=newsService.ModifyNewsState(id,state);
			if(state==1){
				request.getRequestDispatcher("/success.jsp").forward(request, response);
			}else if(state==2){
				request.getRequestDispatcher("/failure.jsp").forward(request, response);
			}
		}catch (AppException e) {
			e.printStackTrace();
			//�ض����쳣ҳ��
			response.sendRedirect("toError");
		}
	}

}
