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


public class GetUserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");  //设置输出内容的编码
		
		try {
		//初始化用户业务逻辑类
		UserService userService=new UserService();
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		//声明用户列表集合
		List<User> userList=null;
		//调用业务逻辑层获取用户列表
		userList=userService.getUserById(id);
		if(userList!=null){
			//将userList保存到request中
			request.setAttribute("userList",userList);
			//转发到用户信息显示页面
			request.getRequestDispatcher("/editorUser.jsp").forward(request, response);
		}else{
			System.out.println("没获到用户列表！");
		}
		
		} catch (AppException e) {
			e.printStackTrace();
			//重定向到异常页面
			response.sendRedirect("toError");
		}
	}

}
