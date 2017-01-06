
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新闻系统 - 首页</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
	</head>
	

	<body>
		
		

	<div class="main">
		<table>
			<tr bgcolor="#E7E7E7">
				<td>
					<form action="ToManagerUserServlet" method="post">
							<ul class="c1 ico3">
							    <br><br><br>
							    <li><a href="GetUserListServlet">查看用户</a></li>
							    <br>
								<li><a href="addUser.jsp">增加用户</a></li>
							</ul>
					</form>
				</td>
			</tr>
		</table>
	</div>

	
	</body>
</html>