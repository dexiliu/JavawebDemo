package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.News;
import com.service.NewsService;
import com.utils.AppException;

public class EditorNewsServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");  //����������ݵı���
		
		
		int id=-1;
		String id1=request.getParameter("id");
		if(id1!=null){
			id=Integer.parseInt(id1);
		}
		
		System.out.println("id1="+id);
		try{
			//��ʼ������ҵ���߼���
			NewsService newsService=new NewsService();
			List<News> newsList=null;
			newsList=newsService.getListById(id);//��ȡ�����б�
			if(newsService.DelNews(id)){
				System.out.println("ɾ���ɹ���");
			}
			if(newsList!=null){
				request.setAttribute("newsList",newsList);
				request.getRequestDispatcher("/editorNews.jsp").forward(request, response);
			}
		}catch (AppException e) {
			e.printStackTrace();
			//�ض����쳣ҳ��
			response.sendRedirect("toError");
		}
	}

}
