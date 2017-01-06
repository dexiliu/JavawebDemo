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
		request.setCharacterEncoding("UTF-8");  //����������ݵı���
		
		int id=-1;
		//��ȡ�û���Ϣ
		String id1=request.getParameter("id");
		if(id1!=null){
			id=Integer.parseInt(id1);
		}
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String role1=request.getParameter("role");
        int role=Integer.parseInt(role1);
		
		
		//����ע�ᴦ���ʶ
		boolean flag = false;
		
		try{
			//ʵ�����û�ҵ���߼���
			UserService userService=new UserService();
			//ʵ����Userʵ�������
			User user = new User();
			
			//��װ�û���Ϣ
			
			user.setName(name);
			user.setPassword(password);
			user.setRole(role);
			user.setId(id);
			flag=userService.ModifyUser(user);
			if(flag){
				System.out.println("�޸ĳɹ���");
				request.getRequestDispatcher("/success2.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/failure2.jsp").forward(request, response);
				System.out.println("�޸�ʧ�ܣ�");
			}
		} catch (AppException e) {
			e.printStackTrace();
			//�ض����쳣ҳ��
			response.sendRedirect("toError");
		}
	}

}
