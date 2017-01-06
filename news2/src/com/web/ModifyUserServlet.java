package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.UserService;
import com.utils.AppException;


public class ModifyUserServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");  //设置输出内容的编码
		
		int id=-1;
		//获取用户信息
		String id1=request.getParameter("id");
		if(id1!=null){
			id=Integer.parseInt(id1);
		}
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String role1=request.getParameter("role");
        int role=Integer.parseInt(role1);
		
		
		//声明注册处理标识
		boolean flag = false;
		
		try{
			//实例化用户业务逻辑类
			UserService userService=new UserService();
			//实例化User实体类对象
			User user = new User();
			
			//封装用户信息
			
			user.setName(name);
			user.setPassword(password);
			user.setRole(role);
			user.setId(id);
			flag=userService.ModifyUser(user);
			if(flag){
				System.out.println("修改成功！");
				request.getRequestDispatcher("/success2.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/failure2.jsp").forward(request, response);
				System.out.println("修改失败！");
			}
		} catch (AppException e) {
			e.printStackTrace();
			//重定向到异常页面
			response.sendRedirect("toError");
		}
	}

}
