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
		//��ȡ�û�����������ظ�����
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		//����ע�ᴦ���ʶ
		boolean flag = false;
		//��ʼ����ʾ��Ϣ
		String message = "";
		//ʵ����Userʵ�������
		User user = new User();
		//��ʼ���û�ҵ���߼���
		UserService userService = new UserService();
		/**
		 * ����ע�����󣬽���������֤:
		 * 1���û���\������ظ����붼����Ϊ��.
		 * 2���ظ����������Ҫ����һ��
		 * 3���û���ҪΨһ
		 * ������������Ҫ����ע��ʧ��
		 */
		if(name == "" || password == "" || password2 =="") {
			System.out.println("---���벻��ȷ��---");
			System.out.println("�û�����������ظ����붼����Ϊ��");
			message = "�û�����������ظ����붼����Ϊ��";
		} else if(!password2.equals(password)){
			System.out.println("---���벻��ȷ��---");
			System.out.println("---������������벻ͬ---");
			message = "������������벻ͬ";
		} else {
			System.out.println("�û���:" + name);
			System.out.println("����:" + password);
			
			try{
				//��������
				//���û���Ϣ��װ��user������
				user.setName(name);
				user.setPassword(password);
				
				System.out.println(user.getName());
				//����ҵ���߼������û�ע��
				flag = userService.register(user);
				if(flag) {
					//ע��ɹ���������ʾ��Ϣ
					message = "ע��ɹ�";
					System.out.println("ע��ɹ�");
				} else {
					//ע��ʧ�ܣ�������ʾ��Ϣ
					message = "ע��ʧ��,�û����Ѵ���";
					System.out.println("ע��ʧ��");
				}
				
			
			} catch (AppException e) {
				e.printStackTrace();
				//ϵͳ�쳣��������ʾ��Ϣ
				message = "ϵͳ�쳣";
			}
			
				
		}
		//��message���浽request��
		request.setAttribute("message", message);
		//ת����ע��ҳ��
		request.getRequestDispatcher("/toRegister").forward(request, response);		
	}


}
