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
		</style>
		<script type="text/javascript">
			function check(){
				var productName = document.getElementById("productName").value;
				var content = document.getElementById("content").value;

				if (productName == "") {
	 				alert("请填写产品名称！"); 
	 				// 返回false，阻止表单提交
			 		return false;
		 		}
		 		

				if (content == "") {
		 			alert("请填写产品描述！"); 
		 			return false;
		 		}
			}
		</script>
	</head>
	<%
	if(session.getAttribute("currentuser") == null){
		response.sendRedirect("/zngsgw/views/user/login.jsp");
	}
	%>
	<body>
		<form id="create" name="createProductform" method="post"
			action="product.do?doUpdate" >
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
						<input type="text" name="productName" value="${product.productName }" id="productName"  size="60" />
					</td>
				</tr>
				
				<tr>
					<td class="td">
						价格：
					</td>
					<td>
						<input type="text" name="price"  value="${product.price }" id="price" />
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
							产品描述：
					</td>
					<td>
						<textarea id="description" name="description"
							style="width:600px; height:230px;">${product.description }</textarea>
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