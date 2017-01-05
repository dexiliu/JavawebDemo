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
		response.sendRedirect("/zngsgw/views/user/login.jsp");
	}
	%>
  <body>
   <c:if test="${fn:length(lists) > 0}">
	<table cellpadding="5">	
		<tr>
			<th>id</th>
			<th>产品名称</th>
			<th>产品价格</th>
			<th>Operation</th>
		</tr>
		<c:forEach items="${lists}" var="product" varStatus="status">
				<table>
				<tr>
				<th>${product.id }</th>
				
				<th><a href="product.do?productDetail&id=${product.id}">${product.productName }</a></th>
				
				<th>${product.price }</th>
				
				<th><a href="product.do?goUpdate&id=${product.id }" target="main">编辑</a>| <a href="product.do?delete&id=${product.id }">删除</a></th>
				</tr>
			</table>
		</c:forEach>
	</table>
</c:if>
  </body>
</html>
