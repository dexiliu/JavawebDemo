package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ToNewUserServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//����������ַ���Ϊ"utf-8"
		request.setCharacterEncoding("utf-8");
		
		//����session
		HttpSession session=null;
		//ʹ��request����ȡ��sesssion
		session=request.getSession();
		Integer userId=(Integer)session.getAttribute("userId");
		
		//���û�û�е�¼����ת�Ƶ���¼ҳ��
		if(userId==null){
			response.sendRedirect("toLogin");
		}else{
			//ת�������û�ҳ��
			request.getRequestDispatcher("/newUser.jsp").forward(request, response);
		}
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}



}
