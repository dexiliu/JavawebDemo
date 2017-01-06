<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新闻系统 - 页头</title>
		<link href="css/admin.css" rel="stylesheet" type="text/css" />
	</head>
	<%
		String userName = (String) session.getAttribute("userName");
	 %>
	<body>
		<!-- header start -->
		<div class="header">
			<div class="toplinks">
				您好：<%=userName %>，欢迎使用新闻系统！
				<span>
				<a href="ColumnNewsId1" target="_top"><img alt="返回首页" src="images/return.png" width="105" height="25"/></a>
				<a href="LogoutServlet" target="_top"><img alt="注销" src="images/logout.png" width="105" height="25"/></a>
				</span>
			</div>
			
		</div>
		<!-- header end -->
	</body>
</html>