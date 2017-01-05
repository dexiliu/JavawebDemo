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
 	 String currentuser=(String)session.getAttribute("currentuser");
	if( currentuser== null){
		response.sendRedirect("/zngsgw/login.jsp");
	}
	%>
  <body>
  <h3>登录者：${ currentuser}</h3> <a href="user.do?logout" >退出</a>
   <c:if test="${fn:length(newsLists) > 0}">
	<table cellpadding="5">	
		<tr>
			<th>id</th>
			<th>标题</th>
			<th>发布时间 </th>
			<th>作者</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${newsLists}" var="news" varStatus="status">
			<table>
				<tr>
				<th>${news.id }</th>
				
				<th><a href="news.do?newsDetail&id=${news.id}">${news.title }</a></th>
				
				<th>${news.createTime }</th>
				
				<th>${news.author }</th>
			
				<th><a href="news.do?goUpdate&id=${news.id }" target="main">编辑</a>| <a href="news.do?delete&id=${news.id }">删除</a></th>
				</tr>
			</table>
		</c:forEach>
	</table>
</c:if>
  </body>
</html>
