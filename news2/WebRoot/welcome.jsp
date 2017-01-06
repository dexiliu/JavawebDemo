<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新闻系统 - 欢迎</title>
		<link href="css/admin.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<div class="content">
			<p>
				欢迎进入新闻系统！
				<br />
				<%
					    Date date=new Date();
						SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String dates=matter.format(date);
					%>
				现在时间：<%=dates%>
			</p>
	</body>
</html>