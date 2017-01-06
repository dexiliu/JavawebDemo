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

		//设置请求的字符集为"utf-8"
		request.setCharacterEncoding("utf-8");
		
		//声明session
		HttpSession session=null;
		//使用request对象取得sesssion
		session=request.getSession();
		Integer userId=(Integer)session.getAttribute("userId");
		
		//若用户没有登录，则转移到登录页面
		if(userId==null){
			response.sendRedirect("toLogin");
		}else{
			//转发到新用户页面
			request.getRequestDispatcher("/newUser.jsp").forward(request, response);
		}
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}



}
