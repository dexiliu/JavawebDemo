<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  	
  <body>
    <div align="center">
    	<table border="1">
  			<tr>
  				<th>Id</th>
  				<th>UserName</th>
  				<th>Password</th>
  				<th>Email</th>
  				<th>Operation</th>
  			</tr>
  			<c:if test="${null != userlist }">
  			<c:forEach items="${userlist}" var="u">
  			<tr>
  				<td>${u.id}</td>
  				<td>${u.username}</td>
  				<td>${u.password}</td>
  				<td>${u.email}</td>
  				<td><a href="UpdateServlet?id=${u.id}">修改</a>|
  					<a href="DeleteServlet?id=${u.id}">删除</a>
  				</td>
  			</tr>
  			</c:forEach>
  			</c:if>
  		</table>
    </div>
  </body>
</html>
