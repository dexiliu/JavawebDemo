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
		request.setCharacterEncoding("UTF-8");  //����������ݵı���
		
		try {
		//��ʼ���û�ҵ���߼���
		UserService userService=new UserService();
		//�����û��б���
		List<User> userList=null;
		//����ҵ���߼����ȡ�û��б�
		userList=userService.getUser();
		//��userList���浽request��
		request.setAttribute("userList",userList);
		//ת�����û���Ϣ��ʾҳ��
		request.getRequestDispatcher("/userList.jsp").forward(request, response);
		} catch (AppException e) {
			e.printStackTrace();
			//�ض����쳣ҳ��
			response.sendRedirect("toError");
		}
	}

}
