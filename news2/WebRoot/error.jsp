<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻系统 - 异常信息页面</title>
<meta name="description" content="软酷新闻发布系统" />
<meta name="keywords" content="软酷网 新闻发布" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<!-- header start -->
		<div class="header">
			<div class="toplinks">
				<span><a href="register.jsp"><img alt="注册" src="images/register.png" width="105" height="25"/></a>
				<a href="login.jsp"><img alt="登录" src="images/login.png" width="105" height="25"></a></span>
			</div>

			<h1>
				<a href="ColumnNewsId1"><img src="images/logo.gif" width="960"
						height="150" alt="新闻系统" /> </a>
			</h1>
		</div>
		<!-- header end -->

		<!-- menu start -->
		<div class="menu">
			<ul>
				<li>
					<a href="ColumnNewsId1"><span>主页</span> </a>
				</li>

				<li>
					<a href="getInternationalNewsServlet"><span>国际新闻</span> </a>
				</li>

				<li>
					<a href="getDomesticNewsServlet"><span>国内新闻</span> </a>
				</li>

				<li>
					<a href="getEntertainmentNewsServlet"><span>娱乐新闻</span> </a>
				</li>

				<li>
					<a href="getSportsNewsServlet"><span>体育新闻</span> </a>
				</li>

				<li>
					<a href="getFinanceNewsServlet"><span>财经频道</span> </a>
				</li>

				<li>
					<a href="getCarNewsServlet"><span>汽车频道</span> </a>
				</li>

				<li>
					<a href="getElectronicNewsServlet"><span>电子频道</span> </a>
				</li>
			</ul>

			<form action="SearchNewsServlet" method="post">
				<input type="hidden" name="newstypeId" value="0" />
				<input name="name" type="text" class="search-keyword"
					id="search-keyword" value="在这里搜索..." />
				<input type="submit" class="search-submit" value="搜索" />
			</form>
		</div>
		<!-- menu end -->
	<!-- header end -->

	<!-- main start -->
	<div class="main">
		<p align="center" style="font-size: 14px; margin: 160px auto;">
			系统繁忙，请稍后再试…… <br /> 【<a href="javascript:history.back();">点击这里返回上一页</a>】
		</p>
	</div>
	<!-- main end -->

	<!-- footer start -->
	<div class="footer">
		<p>Copyright&nbsp;&copy;&nbsp;C2组&nbsp;&nbsp;版权所有</p>
	</div>
	<!-- footer end -->
</body>
</html>