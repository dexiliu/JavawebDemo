package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.UserService;
import com.utils.AppException;

public class LoginServlet extends HttpServlet {



	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置请求的字符集为"UTF-8"
		request.setCharacterEncoding("UTF-8");
		//获取用户名和密码
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//初始化提示信息
		String message = "";
		
		/**
		 * 处理登录请求,进行如下验证；用户名和密码都不能为空
		 * 
		 * 若不满足以上要求，则登录失败，给出提示信息
		 */
		System.out.println("name=" + name);
		if(name == "" || password == "") {
			System.out.println("---输入不正确---");
			System.out.println("用户名和密码都不能为空");
			message = "用户名和密码都不能为空！";
			//将message保存到request中
			request.setAttribute("message", message);
			//转发到登录页面
			request.getRequestDispatcher("toLogin").forward(request, response);
		} else {
			/**
			 * 进行登录处理，根据用户名和密码查询用户id,这里采用硬编码方式验证登录
			 * 登录成功后返回用户id值
			 */
			int userId = -1;
			
			try {
				//初始化业务逻辑类
				UserService userService = new UserService();
				//调用业务逻辑层查询用户
				userId = userService.login(name, password);
				System.out.println("userId=" + userId);
				if(userId > 0) { //登录成功
					//声明session
					HttpSession session = null;
					//使用request对象取得session
					session = request.getSession();
					//将用户id.用户名保存到session中
					session.setAttribute("userId", userId);
					session.setAttribute("userName", name);
					
					//声明角色
					int role = -1;
					//调用业务逻辑层获取用户对应的角色信息
					role = userService.getUserRole(userId);
					
					//根据用户的角色，进行页面跳转
					System.out.println("role=" + role);
					if(role == 1) {
						//重定向到管理员页面
						response.sendRedirect("toAdmin");
					} else {
						//重定向到编辑页面
						response.sendRedirect("toEditor");
					}
				} else {
					message = "用户名或密码错误!";
					//将message报存到request中
					request.setAttribute("message", message);
					//将本次登录的用户名传递到页面上显示
					request.setAttribute("userName", name);
					
					//转发到登录页面
					request.getRequestDispatcher("toLogin").forward(request, response);
				}
				
			}catch (AppException e) {
				e.printStackTrace();
				response.sendRedirect("toError");
			}
			
		} 
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       /*
		//设置请求的字符集为"utf-8"
		request.setCharacterEncoding("utf-8");
		//获取登录信息
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		//初始化用户id
		int userId=-1;
		//初始化提示信息
		String message="";
		*/
		/*
		 * 调用业务逻辑的对应方法处理业务逻辑
		 */
		 /*
		try{
			//初始化用户业务逻辑
			UserService userService=new UserService();
			//调用业务逻辑层进行用户登录
			userId=userService.login(name, password);
			if(userId>0){//登录成功 
				//声明session
				HttpSession session=null;
				//使用request对象取得session
				session=request.getSession();
				//将用户id、用户名保存到session 
				session.setAttribute("userId", userId);
				session.setAttribute("userName",name);
				//声明角色
				int role=-1;
				//调用业务逻辑层获取用户对应的角色信息
				role=userService.getUserRole(userId);
				
				//根据用户角色。进行页面跳转处理
				if(role==1){
					//重定向到管理员页面
					response.sendRedirect("toAdmin");
				}else{
					//重定向到编辑页面
					response.sendRedirect("toEditor");
				}
			}else{//登录失败
				//设置提示信息
				message="用户名或密码错误！";
				request.setAttribute("message", message);//将提示信息保存到request中
				//将用户名保存到request
				request.setAttribute("userName", name);
				//转到登录页面
				request.getRequestDispatcher("toLogin").forward(request, response);
			}
		}catch(AppException e){
			e.printStackTrace();
		}*/
		doGet(request,response);
	}

	
	

}
