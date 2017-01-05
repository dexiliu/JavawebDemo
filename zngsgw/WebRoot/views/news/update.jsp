<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
		tr{
				height:22px;
			}
			.td{
				text-align:center;
			}
			form {
				margin: 0;
			}
			textarea {
				display: block;
	}
	</style>
	<!-- kindEditor-->				
		<link rel="stylesheet" href="js/KindEditor/default.css" />
		<script charset="utf-8" src="js/KindEditor/kindeditor-min.js"></script>
		<script charset="utf-8" src="js/KindEditor/zh_CN.js"></script>
		<script type="text/javascript">
			var editor;
			KindEditor.ready(function(K){
				editor=K.create('textarea[name="content"]');
			});
		</script>
  </head>
  <%
	if(session.getAttribute("currentuser") == null){
		response.sendRedirect("/zngsgw/views/user/login.jsp");
	}
	%>
  <body>
  
    <form id="update" name="updateNewsform" method="post"
			action="news.do?doUpdate"  >
			<table>
				<tr bgcolor="#E7E7E7">
					<td height="24" colspan="10">
						&nbsp;修改新闻&nbsp;
					</td>
				</tr>
				<tr>
					
					<td>
						<input type="text" name="id" value="${news.id}" id="id" hidden="true"  size="60" />
					</td>
				</tr>
				<tr>
					<td class="td">
						标题：
					</td>
					<td>
						<input type="text" name="title" value="${news.title}" id="title"  size="60" />
					</td>
				</tr>
				
				<tr>
					<td class="td">
						来源：
					</td>
					<td>
						<input type="text" name="source"  value="${news.source}" id="source" />
					</td>
				</tr>
				<tr>
					<td class="td">
						作者：
					</td>
					<td>
						<input type="text" name="author" value="${news.author }"  id="author" />
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
						<input type="text" name="lastUpdateTime" readonly=true value="<%=dates %>" id="lastUpdateTime" />
					</td>
				</tr>
				<tr>
					<td class="td">
						关键字：
					</td>
					<td>
						<input type="text" name="keywords" value="${news.keywords }"  id="keywords" size="60" />
					</td>
				</tr>
				<tr>
					<td class="td">
							内容：
					</td>
					<td>
						<textarea id="content" name="content" 
							style="width:600px; height:230px;">${news.content }</textarea>
					</td>
				</tr>
				
				<tr align="center">
					<td colspan="2">
	
						<input type="submit" value="修改" 
							onclick="return check()" />
					</td>
				</tr>
			</table>
		</form>
  </body>
</html>
