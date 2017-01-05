<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>update user</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<style type="text/css">
	.even {
		background-color: silver;
	}
	</style>
  </head>
  <%
	if(session.getAttribute("currentuser") == null){
		response.sendRedirect("/zngsgw/views/users/login.jsp");
	}
	%>
  <body>
  
    <form:form action="users.do?doUpdate" method="post" modelAttribute="users" >
  		<form:input  path="id" value="${users.id }" hidden="true" readonly="true"/>
  		<form:errors path="id" cssClass="error" />
  		<br/>
		<form:label  path="useruame">User Name </form:label>
  		<form:input  path="useruame" value="${users.username }"/>
  		<form:errors path="useruame" cssClass="error" />
  		<br/>
  		<form:label  path="password">Password </form:label>
		<form:input  path="password" value="${users.password }"/>
		<form:errors path="password" cssClass="error" />
		
		<p><button type="submit">Submit</button></p>
	</form:form>
	 
	<!-- 
	 <h1>UserName</h1>
	 <h1>${user}</h1>
	 <h1>${user.id }</h1>
	 <form action="user.do?doUpdate" method="post">
	 			 <input type="text" name="id" value="${user.id }" readonly="true" hidden="true">
	 	UserName:<input type="text" id="userName" name="userName" value="${user.userName }">
	 	</br>
	 	Password:<input type="text" id="password" name="password" value="${user.password }">
	 	</br>
	 	<input type="submit" name="submit" value="submit">
	 </form>
	  -->
  </body>
</html>
