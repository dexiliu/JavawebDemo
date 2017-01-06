package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.UserService;
import com.utils.AppException;


public class GetUserListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");  //设置输出内容的编码
		
		try {
		//初始化用户业务逻辑类
		UserService userService=new UserService();
		//声明用户列表集合
		List<User> userList=null;
		//调用业务逻辑层获取用户列表
		userList=userService.getUser();
		//将userList保存到request中
		request.setAttribute("userList",userList);
		//转发到用户信息显示页面
		request.getRequestDispatcher("/userList.jsp").forward(request, response);
		} catch (AppException e) {
			e.printStackTrace();
			//重定向到异常页面
			response.sendRedirect("toError");
		}
	}

}
