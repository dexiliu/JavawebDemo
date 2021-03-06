﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.model.News" %>
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
		<script type="text/javascript">
			function check(){
				var title = document.getElementById("title").value;
				var newsTypeId = document.getElementById("newsTypeId").value;
				var content = document.getElementById("content").value;

				if (title == "") {
	 				alert("请填写标题！"); 
	 				// 返回false，阻止表单提交
			 		return false;
		 		}
		 		
		 		if (newsTypeId == "0") {
		 			alert("请选择新闻栏目！"); 
		 			return false;
		 		}
	
				if (content == "") {
		 			alert("请填写内容！"); 
		 			return false;
		 		}
			}
		</script>
	</head>

	<body>
		<!--  新闻表单   -->
		<form id="create" name="create" method="post"
			action="create">
			<table>
				<tr bgcolor="#E7E7E7">
					<td height="24" colspan="10">
						&nbsp;修改新闻&nbsp;
					</td>
					</tr>
					
		<%
			//获取新闻列表
			List<News> newsList = (List<News>)request.getAttribute("newsList");
			if(newsList != null) {
				int size = newsList.size();
				System.out.println("size=" + size);
				for(int i = 0; i < size; i++) {
					News news = (News)newsList.get(i);  //获取新闻对象
		 %>
				
				<tr>
					<td class="td">
						标题：
					</td>
					<td>
					
					
						<input type="text" name="title" value="<%=news.getTitle()%>" id="title" value="<%=news.getTitle() %>" size="60" />
					</td>
				</tr>
				<td class="td">
						栏目：
					</td>
					<td>
						<select id="newsTypeId" name="newsTypeId">
							<option value="0">
								请选择栏目
							</option>
							<option value="1">
								国际新闻
							</option>
							<option value="2">
								国内新闻
							</option>
							<option value="3">
								娱乐新闻
							</option>
							<option value="4">
								体育新闻
							</option>
							<option value="5">
								财经频道
							</option>
							<option value="6">
								汽车频道
							</option>
							<option value="7">
								电子频道
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td">
						来源：
					</td>
					<td>
						<input type="text" name="source"  value="<%=news.getSource() %>" id="source" />
					</td>
				</tr>
				<tr>
					<td class="td">
						作者：
					</td>
					<td>
						<input type="text" name="author" value="<%=news.getAuthor() %>"  id="author" />
					</td>
				</tr>
				<tr>
					<td class="td">
						修改时间：
					</td>
					<td>
					<%
					    Date date=new Date();
						SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String dates=matter.format(date);
					%>
						<input type="text" name="createTime" value="<%=dates %>" id="createTime" />
					</td>
				</tr>
				<tr>
					<td class="td">
						关键字：
					</td>
					<td>
						<input type="text" name="keywords" value="<%=news.getKeywords() %>"  id="keywords" size="60" />
					</td>
				</tr>
				<tr>
					<td class="td">
							内容：
					</td>
					<td>
						<textarea id="content" name="content"
							style="width:600px; height:230px;"><%=news.getContent() %></textarea>
					</td>
				</tr>
				
				<%
				}
			}
				%>
				<tr align="center">
					<td colspan="2">
	
						<input type="submit" value="修改" class="button"
							onclick="return check()" />
						<input type="reset" value="重置" class="button" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>