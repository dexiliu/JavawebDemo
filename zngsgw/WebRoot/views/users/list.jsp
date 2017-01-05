<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>user list</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	
  </head>
  <%
	if(session.getAttribute("currentuser") == null){
		response.sendRedirect("/zngsgw/views/users/login.jsp");
	}
	%>
  <body>
   <c:if test="${fn:length(usersLists) > 0}">
	<table cellpadding="5">	
		<tr>
			<th>id</th>
			<th>Name</th>
			<th>Password</th>
			<th>Operation</th>
		</tr>
		<c:forEach items="${usersLists}" var="users" varStatus="status">
				<td>${users.id}</td>
				<td>${users.username}</td>
				<td>${users.password}</td>
				<td><a href="users.do?goUpdate&id=${users.id }" target="main">编辑</a>| <a href="users.do?delete&id=${users.id }">删除</a></td>
				
		</c:forEach>
	</table>
</c:if>
  </body>
</html>
