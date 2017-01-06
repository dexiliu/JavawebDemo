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
		
		//����������ַ���Ϊ"UTF-8"
		request.setCharacterEncoding("UTF-8");
		//��ȡ�û���������
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//��ʼ����ʾ��Ϣ
		String message = "";
		
		/**
		 * �����¼����,����������֤���û��������붼����Ϊ��
		 * 
		 * ������������Ҫ�����¼ʧ�ܣ�������ʾ��Ϣ
		 */
		System.out.println("name=" + name);
		if(name == "" || password == "") {
			System.out.println("---���벻��ȷ---");
			System.out.println("�û��������붼����Ϊ��");
			message = "�û��������붼����Ϊ�գ�";
			//��message���浽request��
			request.setAttribute("message", message);
			//ת������¼ҳ��
			request.getRequestDispatcher("toLogin").forward(request, response);
		} else {
			/**
			 * ���е�¼���������û����������ѯ�û�id,�������Ӳ���뷽ʽ��֤��¼
			 * ��¼�ɹ��󷵻��û�idֵ
			 */
			int userId = -1;
			
			try {
				//��ʼ��ҵ���߼���
				UserService userService = new UserService();
				//����ҵ���߼����ѯ�û�
				userId = userService.login(name, password);
				System.out.println("userId=" + userId);
				if(userId > 0) { //��¼�ɹ�
					//����session
					HttpSession session = null;
					//ʹ��request����ȡ��session
					session = request.getSession();
					//���û�id.�û������浽session��
					session.setAttribute("userId", userId);
					session.setAttribute("userName", name);
					
					//������ɫ
					int role = -1;
					//����ҵ���߼����ȡ�û���Ӧ�Ľ�ɫ��Ϣ
					role = userService.getUserRole(userId);
					
					//�����û��Ľ�ɫ������ҳ����ת
					System.out.println("role=" + role);
					if(role == 1) {
						//�ض��򵽹���Աҳ��
						response.sendRedirect("toAdmin");
					} else {
						//�ض��򵽱༭ҳ��
						response.sendRedirect("toEditor");
					}
				} else {
					message = "�û������������!";
					//��message���浽request��
					request.setAttribute("message", message);
					//�����ε�¼���û������ݵ�ҳ������ʾ
					request.setAttribute("userName", name);
					
					//ת������¼ҳ��
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
		//����������ַ���Ϊ"utf-8"
		request.setCharacterEncoding("utf-8");
		//��ȡ��¼��Ϣ
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		//��ʼ���û�id
		int userId=-1;
		//��ʼ����ʾ��Ϣ
		String message="";
		*/
		/*
		 * ����ҵ���߼��Ķ�Ӧ��������ҵ���߼�
		 */
		 /*
		try{
			//��ʼ���û�ҵ���߼�
			UserService userService=new UserService();
			//����ҵ���߼�������û���¼
			userId=userService.login(name, password);
			if(userId>0){//��¼�ɹ� 
				//����session
				HttpSession session=null;
				//ʹ��request����ȡ��session
				session=request.getSession();
				//���û�id���û������浽session 
				session.setAttribute("userId", userId);
				session.setAttribute("userName",name);
				//������ɫ
				int role=-1;
				//����ҵ���߼����ȡ�û���Ӧ�Ľ�ɫ��Ϣ
				role=userService.getUserRole(userId);
				
				//�����û���ɫ������ҳ����ת����
				if(role==1){
					//�ض��򵽹���Աҳ��
					response.sendRedirect("toAdmin");
				}else{
					//�ض��򵽱༭ҳ��
					response.sendRedirect("toEditor");
				}
			}else{//��¼ʧ��
				//������ʾ��Ϣ
				message="�û������������";
				request.setAttribute("message", message);//����ʾ��Ϣ���浽request��
				//���û������浽request
				request.setAttribute("userName", name);
				//ת����¼ҳ��
				request.getRequestDispatcher("toLogin").forward(request, response);
			}
		}catch(AppException e){
			e.printStackTrace();
		}*/
		doGet(request,response);
	}

	
	

}
