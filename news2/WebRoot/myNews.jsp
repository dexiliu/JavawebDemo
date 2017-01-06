<%@page import="com.model.News"%>
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
			<td height="24" colspan="4">&nbsp;新闻&nbsp;</td>
			<td>
				<form action="MyNewsServlet" method="post">
					状态: <select name="state">
						<!-- 使用c:if标签判断用户选择，并显示选中的项 -->
						<option value="0" <c:if test="${state==0 }" >selected</c:if>>
							待审核</option>
						<option value="1" <c:if test="${state==1 }">selected</c:if>>已发布</option>
					</select> <input type="submit" value="查询" />
				</form>
			</td>
		</tr>
		<tr>
		<th width="350px">标题</th>
		<th width="50px">作者</th>
		<th width="50px">来源</th>
		<th width="300px">录入时间</th>
		<th width="150px">状态</th>
		</tr>
		<%
			//获取新闻列表
			List<News> newsList = (List<News>)request.getAttribute("newsList");
		    int state=(Integer)request.getAttribute("state");
			if(newsList != null) {
				int size = newsList.size();
				System.out.println("size=" + size);
				for(int i = 0; i < size; i++) {
					News news = (News)newsList.get(i);  //获取新闻对象
					if(state==1){
		 %>
		 		<tr>
		 			<th align="left"><a href="ShowNewsServlet?id=<%=news.getId() %>" class="title" ><%=news.getTitle() %></a></th>
		 			<th><a><%=news.getAuthor() %></a></th>
		 			<th><a><%=news.getSource() %></a></th>
		 			<th><a><%=news.getCreateTime() %></a></th>
		 			<th>已发布</th>
		 		</tr>
		 		
		 <%
					}else{
		%>
					<tr>
					    <th align="left"><a href="ShowNewsServlet?id=<%=news.getId() %>" class="title" ><%=news.getTitle() %></a></th>
		 			    <th><a><%=news.getAuthor() %></a></th>
		 			    <th><a><%=news.getSource() %></a></th>
		 			    <th><a><%=news.getCreateTime() %></a></th>
						<td> 
						<a href="EditorNewsServlet?id=<%=news.getId() %>" target="main">编辑</a> 
						| <a href="DelNewsServlet?id=<%=news.getId() %>" target="main">删除</a></td>
					</tr>
		<%
					}
            
		 		}
		 	}
		  %>
		  
		  </table>
		</div>

		
	</body>
</html>