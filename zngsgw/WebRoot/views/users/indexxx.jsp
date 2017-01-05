<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>home</title>
	
  </head>
   <%
	if(session.getAttribute("currentuser") == null){
		response.sendRedirect("/zngsgw/views/users/login.jsp");
	}
	%>
  <body>
  <center>
  	<a href="users.do?toAddForm">Add Users</a><br/>
  	<a href="users.do?list">Users Lists Page</a><br/>
  	<a href="news.do?goAddNews">Add News</a><br/>
  	<a href="news.do?goUpload">file upload</a><br/>
  	<a href="news.do?list">news list</a><br/>
  	<a href="product.do?goAddProduct">add product</a><br/>
  	<a href="product.do?list">product list</a><br/>

  </center>
  </body>
</html>
