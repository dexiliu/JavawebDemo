<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新闻系统 - 编辑管理页面</title>
	</head>
	
	<!-- 框架结构：上、中(左边、右边)、下 -->
	<frameset rows="72,*,70" cols="*" frameborder="no">
	  <frame src="header2.jsp" name="topframe" scrolling="no">
	  <frameset cols="180,*" frameborder="no">
		<frame src="adminMenu.jsp" noresize name="menu" scrolling="no">
		<frame src="welcome.jsp" noresize name="main" scrolling="auto">
	  </frameset>
	  <frame src="footer.jsp" name="bottomframe" scrolling="no">
	</frameset>
	
	<!-- 对不支持Frame框架的浏览器，设置提示信息 -->
	<noframes>
		<body>您的浏览器不支持框架！</body>
	</noframes>
</html>