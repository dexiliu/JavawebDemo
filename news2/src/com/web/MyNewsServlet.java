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
import com.service.UserService;
import com.utils.AppException;

public class MyNewsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// ����������ַ���Ϊ"UTF-8"
		request.setCharacterEncoding("UTF-8");
   
		int state=-1;
		String state1=request.getParameter("state");
		if(null!=state1){
			
			state=Integer.parseInt(state1);
		}
		request.setAttribute("state", state);
		
		int userId = -1;
		try {

			//����session
			HttpSession session = null;
			//ʹ��request����ȡ��session
			session = request.getSession();
			userId=(Integer) session.getAttribute("userId");
			System.out.println("userId=" + userId);
			// ��ʼ������ҵ���߼���
			NewsService newsService = new NewsService();

			// ���������б���
			List<News> newsList = null;
			// ����ҵ���߼����ȡ�����б�
			newsList = newsService.getListByuserId(userId,state);
			// ��newsList���浽request��
			request.setAttribute("newsList", newsList);
			// ת�����ҵ�����ҳ��
			request.getRequestDispatcher("/myNews.jsp").forward(request,
					response);
		} catch (AppException e) {
			e.printStackTrace();
			// �ض����쳣ҳ��
			response.sendRedirect("toError");
		}
	}

}
