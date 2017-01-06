package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.News;
import com.service.NewsService;
import com.utils.AppException;

public class createNewsServlet extends HttpServlet {
	
       
	/*
	 * ����post��ʽ�Ĵ�����������
	 * 
	 */
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����������ַ���Ϊ"utf-8"
		request.setCharacterEncoding("utf-8");
		
		//����session
		HttpSession session=null;
		//ʹ��request����ȡ��session
		session=request.getSession();
		Integer userId=(Integer)session.getAttribute("userId");
		
		//���û�û�е�¼������ת����¼ҳ��
		if(userId==null){
			response.sendRedirect("toLogin");
		}
		
		//��ȡ���ŵ�������Ϣ
		String newsType=request.getParameter("newsTypeId");
		System.out.println("id=" + newsType);
		int newsTypeId=Integer.parseInt(newsType);
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String source=request.getParameter("source");
		String keywords=request.getParameter("keywords");
		String content=request.getParameter("content");
		String createTime=request.getParameter("createTime");
		
		//��ʼ����ʾ��Ϣ
		String message="";
		
		//��ʼ��������Ϣ���󣬲�Ϊ�Ķ�������ֵ
		News news=new News();
		news.setUserId(userId);
		news.setNewsTypeId(newsTypeId);
		news.setTitle(title);
		news.setAuthor(author);
		news.setKeywords(keywords);
		news.setSource(source);
		news.setContent(content);
		news.setCreateTime(createTime);
		news.setState(0);//��������״̬Ϊ��δ��ˡ�
		
		try{
			//��ʼ������ҵ���߼���
			NewsService newsService=new NewsService();
			//�����ɹ���ʧ�ܣ����ش�������ҳ�棬������ʾ��Ϣ
			if(newsService.createNews(news)){
				message="�ɹ���";
				//�����δ�����������Ϣ���ݵ�ҳ������ʾ
				request.setAttribute("news", news);
			}else{
				message="ʧ�ܣ�";
			}
			
			//��message���浽request��
			request.setAttribute("message", message);
			//ת������������ҳ��
			request.getRequestDispatcher("toCreateNews").forward(request, response);
		}catch(AppException e){
			e.printStackTrace();
			//�ض����쳣ҳ��
			response.sendRedirect("toError");
		}
	}

}
