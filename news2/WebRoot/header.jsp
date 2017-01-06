<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻系统 - 页头</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<!-- header start -->
	<div class="header">
		<div class="toplinks">
		<%
		    String name=(String)session.getAttribute("userName");
		%>
		您好，<%=name %>,欢迎使用新闻系统！
			<span>【<a href="register.jsp">注册</a>】【<a href="login.jsp">登录</a>】
			</span>
		</div>
		<h1>
			<a href="#"><img src="images/logo.png" height="56" width="260"
				alt="新闻系统" /></a>
		</h1>
	</div>
	
	<div class="menu">
		<ul>
			<li><a href="ColumnNewsId1"><span>主页</span> </a></li>

			<li><a href="newsType.jsp"><span>国际新闻</span> </a></li>

			<li><a href="newsType.jsp"><span>国内新闻</span> </a></li>

			<li><a href="newsType.jsp"><span>娱乐新闻</span> </a></li>

			<li><a href="newsType.jsp"><span>体育新闻</span> </a></li>

			<li><a href="newsType.jsp"><span>财经频道</span> </a></li>

			<li><a href="newsType.jsp"><span>汽车频道</span> </a></li>

			<li><a href="newsType.jsp"><span>电子频道</span> </a></li>
		</ul>

		<form action="" method="post">
			<input type="hidden" name="newstypeId" value="0" /> 
			<input name="name" type="text" class="search-keyword" id="search-keyword"
				value="在这里搜索..." />
		    <input type="submit" class="search-submit" value="搜索" />
		</form>
	</div>
	<!-- header end -->
</body>
</html>