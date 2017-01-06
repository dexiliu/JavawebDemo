package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.UserService;
import com.utils.AppException;


public class DelUserByuserId extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");  //设置输出内容的编码

		boolean flag=false;
		try{
			//初始化用户业务逻辑类
			UserService userService=new UserService();
			
			String id1=request.getParameter("id");
			int id=Integer.parseInt(id1);
			flag=userService.delUser(id);
			if(flag){
				//转发到删除成功页面
				request.getRequestDispatcher("/success1.jsp").forward(request, response);
			}else{
				//转发到删除失败页面
				request.getRequestDispatcher("/failure1.jsp").forward(request, response);
			}
		}catch (AppException e) {
			e.printStackTrace();
			//重定向到异常页面
			response.sendRedirect("toError");
		}
	}

}
