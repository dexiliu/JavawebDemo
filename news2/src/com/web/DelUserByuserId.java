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
		request.setCharacterEncoding("UTF-8");  //����������ݵı���

		boolean flag=false;
		try{
			//��ʼ���û�ҵ���߼���
			UserService userService=new UserService();
			
			String id1=request.getParameter("id");
			int id=Integer.parseInt(id1);
			flag=userService.delUser(id);
			if(flag){
				//ת����ɾ���ɹ�ҳ��
				request.getRequestDispatcher("/success1.jsp").forward(request, response);
			}else{
				//ת����ɾ��ʧ��ҳ��
				request.getRequestDispatcher("/failure1.jsp").forward(request, response);
			}
		}catch (AppException e) {
			e.printStackTrace();
			//�ض����쳣ҳ��
			response.sendRedirect("toError");
		}
	}

}
