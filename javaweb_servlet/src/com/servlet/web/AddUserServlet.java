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

public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService=new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");    
		request.setCharacterEncoding("UTF-8");
		this.save(request);
		
		List<User> userlist=this.getAllUsers();
		request.setAttribute("userlist", userlist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/userList.jsp");
		dispatcher.forward(request, response);
//		response.sendRedirect("http://localhost:8081/javaweb_servlet/jsp/userList.jsp");
	}
	
	private void save(HttpServletRequest request){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		if(Utils.isNotEmpty(username) && Utils.isNotEmpty(password) && Utils.isNotEmpty(email)){
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			userService.addUser(user);
		}
		request.removeAttribute("username");
		request.removeAttribute("password");
		request.removeAttribute("email");
	}
	
	private List<User> getAllUsers(){
		List<User> list=new ArrayList<User>();
		list=userService.getAllUser();
		return list;
	}

}
