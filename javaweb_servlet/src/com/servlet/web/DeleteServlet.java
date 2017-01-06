package com.servlet.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.entity.User;
import com.servlet.service.UserService;
import com.servlet.service.impl.UserServiceImpl;
import com.servlet.util.Utils;

public class DeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserService userService=new UserServiceImpl();
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");    
		request.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		if(Utils.isNotEmpty(id)){
			userService.deleteUser(id);
		}
		
		List<User> userlist=this.getAllUsers();
		request.setAttribute("userlist", userlist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/userList.jsp");
		dispatcher.forward(request, response);
	}
	
	private List<User> getAllUsers(){
		List<User> list=new ArrayList<User>();
		list=userService.getAllUser();
		return list;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
