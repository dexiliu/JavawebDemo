package com.zngsgw.ssh.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {
	
	
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//获得在下面代码中要用的request,response,session对象
		HttpServletRequest servletRequest = (HttpServletRequest)request;
		HttpServletResponse servletResponse = (HttpServletResponse)response;
		HttpSession session=servletRequest.getSession();
		String name=(String)session.getAttribute("name");
		System.out.println("name1="+name);
		
		//获得用户请求的URI
		String path=servletRequest.getRequestURI();
		System.out.println("path="+path);
		
		//判断
		if(path.indexOf("version")!=-1&& name==null){
			//
			servletResponse.sendRedirect("http://www.znyunxt.cn/ep/");
		}else{
			chain.doFilter(request, response);
			if(name!=null||!"".equals(name)){
				session.removeAttribute("name");
				System.out.println("name2=========="+name);
			}
		}
	}

	public void destroy() {

	}

}
