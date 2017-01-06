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
		//��ȡ�û�����Ϣ
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String role1=request.getParameter("role");
		if(role1!=null){
			role=Integer.parseInt(role1);
		}

		System.out.println("role="+role);
		System.out.println("name="+name);
		System.out.println("password="+password);
		
		//����ע�ᴦ���ʶ
		boolean flag = false;
		//ʵ����Userʵ�������
		User user = new User();
		//��ʼ���û�ҵ���߼���
		UserService userService = new UserService();
			
		try{
			//��������
			//���û���Ϣ��װ��user������
			user.setName(name);
			user.setPassword(password);
			user.setRole(role);
				
			//����ҵ���߼������û����
			flag = userService.addUser(user);
			if(flag) {
				//��ӳɹ�
				System.out.println("��ӳɹ�");
				request.getRequestDispatcher("/success3.jsp").forward(request, response);
			} else {
				//���ʧ��
				System.out.println("���ʧ��");
				request.getRequestDispatcher("/failure3.jsp").forward(request, response);
			}
		} catch (AppException e) {
			e.printStackTrace();
			// �ض����쳣ҳ��
			response.sendRedirect("toError");
		}
	}		
}
