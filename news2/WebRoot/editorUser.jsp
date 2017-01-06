<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.model.User" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新闻系统 - 创建新闻页面</title>
		<link href="css/admin.css" rel="stylesheet" type="text/css" />
		<style type="text/css"> <!--内部样式表-->
			tr{
				height:22px;
			}
			.td{
				text-align:center;
			}
		</style>
		
	</head>

	<body>
		<!--  新闻表单   -->
		<form action="ModifyUserServlet"  name="ModifyUserServlet" method="post">
			<table>
				<tr bgcolor="#E7E7E7">
					<td height="24" colspan="10">
						&nbsp;编辑用户&nbsp;
					</td>
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
					<td class="td">
						用户id：
					</td>
					<td>
						<input type="text" name="id" value="<%=user.getId()%>" id="id" size="60" />
					</td>
				</tr>
		 
				<tr>
					<td class="td">
						用户名：
					</td>
					<td>
						<input type="text" name="name" value="<%=user.getName()%>" id="name" size="60" />
					</td>
				</tr>
				
				<tr>
					<td class="td">
						密码：
					</td>
					<td>
						<input type="text" name="password" value="<%=user.getPassword() %>"  id="password" size="60" />
					</td>
				</tr>
				
				<tr>
					<td class="td">
						用户角色：
					</td>
					<td>
						<input type="text" name="role" value="<%=user.getRole()%>" id="role" size="60" />
						0代表普通编辑员，1代表管理员
					</td>
				</tr>
				
				<%
				}
			}
				%>
				<tr align="center">
					<td colspan="2">
	
						<input type="submit" value="提交" class="button"
							 />
						<input type="reset" value="重置" class="button" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>