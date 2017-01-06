package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.News;
import com.service.NewsService;
import com.utils.AppException;

public class IndexServlet extends HttpServlet {

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");  //����������ݵı���
        
        int state=-1;
		String state1=request.getParameter("state");
		
		if(null!=state1){
			
			state=Integer.parseInt(state1);
		}
		
		request.setAttribute("state",state);
		
		try{
			//��ʼ������ҵ���߼���
			NewsService newsService=new NewsService();
			//���������б���
			List<News> newsList=null;
			//����ҵ���߼����ȡ�����б�
			newsList=newsService.getList(state);
			//��newsList���浽request��
			request.setAttribute("newsList", newsList);
			//ת��
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}catch(AppException e){
			e.printStackTrace();
			//�ض����쳣ҳ��
			response.sendRedirect("toError");
		}
	}

}
