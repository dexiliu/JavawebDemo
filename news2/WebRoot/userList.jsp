<%@page import="com.model.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!-- 引入JSTL核心标签库 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<td height="24" colspan="4">&nbsp;用户信息&nbsp;</td>
			
		</tr>
		<tr>
		<th width="50px">用户id</th>
		<th width="100px">用户名</th>
		<th width="100px">用户密码</th>
		<th width="50px">用户角色</th>
		<th width="50px">操作</th>
		
		</tr>
		<%
			//获取新闻列表
			List<User> userList = (List<User>)request.getAttribute("userList");
			if(userList != null) {
				int size = userList.size();
				for(int i = 0; i < size; i++) {
					User user = (User)userList.get(i);  //获取用户对象
		 %>
		 		<tr>
		 			<th align="left"><a><%=user.getId() %></a></th>
		 			<th><a><%=user.getName() %></a></th>
		 			<th><a><%=user.getPassword() %></a></th>
		 			<th><a><%=user.getRole() %></a></th>
		 			<td><a href="GetUserServlet?id=<%=user.getId() %>" target="main">编辑</a>| <a href="DelUserByuserId?id=<%=user.getId() %>" target="main">删除</a></td>		 			
		 		</tr>
		 <% 
		 		}
		 	}
		  %>
		  
		  </table>
		</div>

		<!-- footer start -->
		<div class="footer">
			<p>Copyright&nbsp;&copy;&nbsp;C2组&nbsp;&nbsp;版权所有</p>
		</div>
		<!-- footer end -->
	</body>
</html>