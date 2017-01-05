<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻系统 - 创建新闻页面</title>
<style type="text/css">
<!--
内部样式表-->tr {
	height: 22px;
}

.td {
	text-align: center;
}

form {
	margin: 0;
}

textarea {
	display: block; .
	btn-upload {position: relative;
	display: inline-block;
	height: 36px;
	*display: inline;
	overflow: hidden;
	vertical-align: middle;
	cursor: pointer
}

}
</style>
<!-- kindEditor-->
<link rel="stylesheet" href="js/KindEditor/default.css" />
<script charset="utf-8" src="js/KindEditor/kindeditor-min.js"></script>
<script charset="utf-8" src="js/KindEditor/zh_CN.js"></script>
<script type="text/javascript">
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="content"]');
	});
</script>


<script type="text/javascript">
	function check() {
		var title = document.getElementById("title").value;
		var content = document.getElementById("content").value;

		if (title == "") {
			alert("请填写标题！");
			// 返回false，阻止表单提交
			return false;
		}

		//if (content == "") {
		//	alert("请填写内容！"); 
		//	return false;
		//}
	}
</script>
</head>
<%
	if (session.getAttribute("currentuser") == null) {
		response.sendRedirect("/zngsgw/views/user/login.jsp");
	}
%>
<body>
	<!--  新闻表单   -->
	<form id="create" name="createNewsform" method="post"
		action="news.do?createNews" enctype="multipart/form-data">
		<table>
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="10">&nbsp;创建新闻&nbsp;</td>
			</tr>
			<tr>
				<td class="td">标题：</td>
				<td><input type="text" name="title" value="" id="title"
					size="60" /></td>
			</tr>
			<tr>
				 
				<td class="td">图片：</td>
				<td><input type="file" name="photoPath" id="photoPath" /></td>
			
			</tr>
			<tr>
				<td class="td">来源：</td>
				<td><input type="text" name="source" value="" id="source" /></td>
			</tr>
			<tr>
				<td class="td">作者：</td>
				<td><input type="text" name="author" value="" id="author" /></td>
			</tr>
			<tr>
				<td class="td">创建时间：</td>
				<td>
					<%
						Date date = new Date();
						SimpleDateFormat matter = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");
						String dates = matter.format(date);
					%> <input type="text" name="createTime" readonly=true
					value="<%=dates%>" id="createTime" />
				</td>
			</tr>
			<tr>
				<td class="td">关键字：</td>
				<td><input type="text" name="keywords" value="" id="keywords"
					size="60" /></td>
			</tr>
			<tr>
				<td class="td">内容：</td>
				<td><textarea id="content" name="content"
						style="width:600px; height:230px;"></textarea></td>
			</tr>

			<tr align="center">
				<td colspan="2"><input type="submit" value="提交" class="button"
					onclick="return check()" /> <input type="reset" value="重置"
					class="button" /></td>
			</tr>
		</table>
	</form>

</body>
</html>