<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>add user</title>
    
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
    <form action="users.do?add" method="post"  >
  		Username:<input type="text" name="username" id="username"/>
  		<br/>
		Password:<input type="password"  name="password" id="password"/>
		<br/>
		
		<p><button type="submit">Submit</button></p>
	</form>
  </body>
</html>
