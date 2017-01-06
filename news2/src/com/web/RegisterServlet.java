package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.UserService;
import com.utils.AppException;

public class RegisterServlet extends HttpServlet {


	


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//获取用户名、密码和重复密码
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		//声明注册处理标识
		boolean flag = false;
		//初始化提示信息
		String message = "";
		//实例化User实体类对象
		User user = new User();
		//初始化用户业务逻辑类
		UserService userService = new UserService();
		/**
		 * 处理注册请求，进行如下验证:
		 * 1、用户名\密码和重复密码都不能为空.
		 * 2、重复密码和密码要保持一致
		 * 3、用户名要唯一
		 * 若不满足以上要求，则注册失败
		 */
		if(name == "" || password == "" || password2 =="") {
			System.out.println("---输入不正确！---");
			System.out.println("用户名、密码和重复密码都不能为空");
			message = "用户名、密码和重复密码都不能为空";
		} else if(!password2.equals(password)){
			System.out.println("---输入不正确！---");
			System.out.println("---两次输入的密码不同---");
			message = "两次输入的密码不同";
		} else {
			System.out.println("用户名:" + name);
			System.out.println("密码:" + password);
			
			try{
				//处理请求
				//将用户信息封装到user对象中
				user.setName(name);
				user.setPassword(password);
				
				System.out.println(user.getName());
				//调用业务逻辑进行用户注册
				flag = userService.register(user);
				if(flag) {
					//注册成功，设置提示信息
					message = "注册成功";
					System.out.println("注册成功");
				} else {
					//注册失败，设置提示信息
					message = "注册失败,用户名已存在";
					System.out.println("注册失败");
				}
				
			
			} catch (AppException e) {
				e.printStackTrace();
				//系统异常，设置提示信息
				message = "系统异常";
			}
			
				
		}
		//将message保存到request中
		request.setAttribute("message", message);
		//转发到注册页面
		request.getRequestDispatcher("/toRegister").forward(request, response);		
	}


}
