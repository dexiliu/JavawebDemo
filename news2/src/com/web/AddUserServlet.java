package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.UserService;
import com.utils.AppException;


public class AddUserServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		int role=-1;
		//获取用户名信息
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String role1=request.getParameter("role");
		if(role1!=null){
			role=Integer.parseInt(role1);
		}

		System.out.println("role="+role);
		System.out.println("name="+name);
		System.out.println("password="+password);
		
		//声明注册处理标识
		boolean flag = false;
		//实例化User实体类对象
		User user = new User();
		//初始化用户业务逻辑类
		UserService userService = new UserService();
			
		try{
			//处理请求
			//将用户信息封装到user对象中
			user.setName(name);
			user.setPassword(password);
			user.setRole(role);
				
			//调用业务逻辑进行用户添加
			flag = userService.addUser(user);
			if(flag) {
				//添加成功
				System.out.println("添加成功");
				request.getRequestDispatcher("/success3.jsp").forward(request, response);
			} else {
				//添加失败
				System.out.println("添加失败");
				request.getRequestDispatcher("/failure3.jsp").forward(request, response);
			}
		} catch (AppException e) {
			e.printStackTrace();
			// 重定向到异常页面
			response.sendRedirect("toError");
		}
	}		
}
