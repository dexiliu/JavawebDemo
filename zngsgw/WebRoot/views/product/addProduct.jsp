<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
			form {
				margin: 0;
			}
			textarea {
				display: block;
			}
		</style>
		<link rel="stylesheet" href="js/KindEditor/default.css" />
		<script charset="utf-8" src="js/KindEditor/kindeditor-min.js"></script>
		<script charset="utf-8" src="js/KindEditor/zh_CN.js"></script>
		<script type="text/javascript">
			var editor;
			KindEditor.ready(function(K){
				editor=K.create('textarea[name="description"]');
			});
		</script>
		<script type="text/javascript">
			function check(){
				var productName = document.getElementById("productName").value;
				var description=document.getElementById("description").value;

				if (productName == "") {
	 				alert("请填写产品名称！"); 
	 				// 返回false，阻止表单提交
			 		return false;
		 		}
		 		

				//if (description == "") {
		 		//	alert("请填写产品描述！"); 
		 		//	return false;
		 		//}
			}
		</script>
	</head>
	<%
	if(session.getAttribute("currentuser") == null){
		response.sendRedirect("/zngsgw/views/user/login.jsp");
	}
	%>
	<body>
		<form id="create" name="createNewsform" method="post"
			action="product.do?addProduct" enctype="multipart/form-data" >
			<table>
				<tr bgcolor="#E7E7E7">
					<td height="24" colspan="10">
						&nbsp;添加产品&nbsp;
					</td>
				</tr>
				<tr>
					<td class="td">
						名称：
					</td>
					<td>
						<input type="text" name="productName" value="" id="productName"  size="60" />
					</td>
				</tr>
				<tr>
					<td class="td">
						图片：
					</td>
					<td>
						<input type="file" name="photoPath" id="photoPath"/>
					</td>
				</tr>
				<tr>
					<td class="td">
						价格：
					</td>
					<td>
						<input type="text" name="price"  value="" id="price" />
					</td>
				</tr>
				
				<tr>
					<td class="td">
						创建时间：
					</td>
					<td>
					<%
					    Date date=new Date();
						SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String dates=matter.format(date);
					%>
						<input type="text" name="createTime" readonly=true value="<%=dates %>" id="createTime" />
					</td>
				</tr>
				
				<tr>
					<td class="td">
							产品描述：
					</td>
					<td>
						<textarea id="description" name="description"
							style="width:600px; height:230px;">${description }</textarea>
					</td>
				</tr>
				
				<tr align="center">
					<td colspan="2">
	
						<input type="submit" value="提交" class="button"
							onclick="return check()" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>