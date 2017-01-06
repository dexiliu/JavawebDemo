<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.model.News"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻系统 - 首页</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
			function check(){
				//获取输入信息，“.value”即获取此元素的值。
				var name = document.getElementById("name").value;

				//验证搜索输入内容不为空
				if (name == "") {
	 				// 在页面弹出提示框
	 				alert("请填写搜索关键词！"); 
	 				// 返回false，阻止表单提交
			 		return false;
		 		}
			}
		</script>
</head>

<%
	String userName = (String) session.getAttribute("userName");
%>

<body>
	<!-- header start -->
	<div class="header">
		<div class="toplinks">
			<%
				if (userName != null) {
			%>
			<p>
				您好：<%=userName%>，欢迎使用新闻系统！ 
				<span>
				<a href="javascript:history.back();"><img alt="返回上一页" src="images/returnback.png" width="105" height="25"/></a>
				<a href="LogoutServlet" target="_top"><img alt="注销" src="images/logout.png" width="105" height="25"/></a>
				</span>
				<%
					} else {
				%>
				<span>
				<a href="register.jsp"><img alt="注册" src="images/register.png" width="105" height="25"/></a>
				<a href="login.jsp"><img alt="登录" src="images/login.png" width="105" height="25"></a>
				</span>
				<%
					}
				%>
			
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
			<li><a href="ColumnNewsId1"><span>主页</span> </a></li>

			<li><a href="getInternationalNewsServlet"><span>国际新闻</span> </a></li>

			<li><a href="getDomesticNewsServlet"><span>国内新闻</span> </a></li>

			<li><a href="getEntertainmentNewsServlet"><span>娱乐新闻</span> </a></li>

			<li><a href="getSportsNewsServlet"><span>体育新闻</span> </a></li>

			<li><a href="getFinanceNewsServlet"><span>财经频道</span> </a></li>

			<li><a href="getCarNewsServlet"><span>汽车频道</span> </a></li>

			<li><a href="getElectronicNewsServlet"><span>电子频道</span> </a></li>
		</ul>

		<form action="SearchNewsServlet" method="post">
			<input type="hidden" name="newstypeId" value="0" /> 
			<input name="name" id="name" type="text" class="search-keyword" id="search-keyword" value="在这里搜索..." /> 
			<input type="submit" class="search-submit" value="搜索" />
		</form>
	</div>
	<!-- menu end -->

	<!-- main start -->
	<div class="main">
		<!-- left start -->
		<div class="left">
			<dl class="tbox">
				<dt>
					<strong><a href="getInternationalNewsServlet">国际新闻</a> </strong><span class="more"><a
						href="getInternationalNewsServlet">更多...</a> </span>
				</dt>

				<%
					//获取新闻列表
					List<News> newsList1 = (List<News>) request
							.getAttribute("newsList1");
					if (newsList1 != null) {
						int size = newsList1.size();
						for (int i = 0; i < size; i++) {
							News news = (News) newsList1.get(i); //获取新闻对象
				%>
				<dd>
					<ul class="ico3">
						<li><a href="ShowNewsServlet?id=<%=news.getId()%>"
							class="title"><%=news.getTitle()%></a></li>
					</ul>
				</dd>
				<%
					}
					}
				%>
			</dl>

			<dl class="tbox">
				<dt>
					<strong><a href="getDomesticNewsServlet">国内新闻</a> </strong><span class="more"><a
						href="getDomesticNewsServlet">更多...</a> </span>
				</dt>

				<%
					//获取新闻列表
					List<News> newsList2 = (List<News>) request
							.getAttribute("newsList2");
					if (newsList2 != null) {
						int size = newsList2.size();
						for (int i = 0; i < size; i++) {
							News news = (News) newsList2.get(i); //获取新闻对象
				%>
				<dd>
					<ul class="ico3">
						<li><a href="ShowNewsServlet?id=<%=news.getId()%>"
							class="title"><%=news.getTitle()%></a></li>
					</ul>
				</dd>
				<%
					}
					}
				%>
			</dl>

			<dl class="tbox">
				<dt>
					<strong><a href="getEntertainmentNewsServlet">娱乐新闻</a> </strong><span class="more"><a
						href="getEntertainmentNewsServlet">更多...</a> </span>
				</dt>

				<%
					//获取新闻列表
					List<News> newsList3 = (List<News>) request
							.getAttribute("newsList3");
					if (newsList3 != null) {
						int size = newsList3.size();
						for (int i = 0; i < size; i++) {
							News news = (News) newsList3.get(i); //获取新闻对象
				%>
				<dd>
					<ul class="ico3">


						<li><a href="ShowNewsServlet?id=<%=news.getId()%>"
							class="title"><%=news.getTitle()%></a></li>

					</ul>
				</dd>

				<%
					}
					}
				%>
			</dl>

			<dl class="tbox">
				<dt>
					<strong><a href="getSportsNewsServlet">体育新闻</a> </strong><span class="more"><a
						href="getSportsNewsServlet">更多...</a> </span>
				</dt>

				<%
					//获取新闻列表
					List<News> newsList4 = (List<News>) request
							.getAttribute("newsList4");
					if (newsList4 != null) {
						int size = newsList4.size();
						for (int i = 0; i < size; i++) {
							News news = (News) newsList4.get(i); //获取新闻对象
				%>
				<dd>
					<ul class="ico3">


						<li><a href="ShowNewsServlet?id=<%=news.getId()%>"
							class="title"><%=news.getTitle()%></a></li>

					</ul>
				</dd>
				<%
					}
					}
				%>
			</dl>

			<dl class="tbox">
				<dt>
					<strong><a href="getFinanceNewsServlet">财经频道</a> </strong><span class="more"><a
						href="getFinanceNewsServlet">更多...</a> </span>
				</dt>

				<%
					//获取新闻列表
					List<News> newsList5 = (List<News>) request
							.getAttribute("newsList5");
					if (newsList5 != null) {
						int size = newsList5.size();
						for (int i = 0; i < size; i++) {
							News news = (News) newsList5.get(i); //获取新闻对象
				%>
				<dd>
					<ul class="ico3">

						<li><a href="ShowNewsServlet?id=<%=news.getId()%>"
							class="title"><%=news.getTitle()%></a></li>
					</ul>
				</dd>
				<%
					}
					}
				%>
			</dl>

			<dl class="tbox">
				<dt>
					<strong><a href="getCarNewsServlet">汽车频道</a> </strong><span class="more"><a
						href="getCarNewsServlet">更多...</a> </span>
				</dt>

				<%
					//获取新闻列表
					List<News> newsList6 = (List<News>) request
							.getAttribute("newsList6");
					if (newsList6 != null) {
						int size = newsList6.size();
						for (int i = 0; i < size; i++) {
							News news = (News) newsList6.get(i); //获取新闻对象
				%>
				<dd>
					<ul class="ico3">

						<li><a href="ShowNewsServlet?id=<%=news.getId()%>"
							class="title"><%=news.getTitle()%></a></li>
					</ul>
				</dd>
				<%
					}
					}
				%>
			</dl>

		
	</div>
	<!-- left end -->

	<!-- right start -->
	<div class="right">
		<dl class="tbox">
			<dt>
				<strong>最新更新</strong>
			</dt>

			<%
				//获取新闻列表
				List<News> newsList = (List<News>) request.getAttribute("newsList");
				if (newsList != null) {
					int size = newsList.size();
					for (int i = 0; i < size; i++) {
						News news = (News) newsList.get(i); //获取新闻对象
			%>
			<dd>
				<ul class="ico1">

					<li><a href="ShowNewsServlet?id=<%=news.getId()%>"
						class="title"><%=news.getTitle()%></a></li>

				</ul>
			</dd>
			<%
				}
				}
			%>
		</dl>

		<dl class="tbox">
			<dt>
				<strong>热点内容</strong>
			</dt>

			<%
				//获取新闻列表
				List<News> newsList8 = (List<News>) request
						.getAttribute("newsList8");
				if (newsList8 != null) {
					int size = newsList8.size();
					for (int i = 0; i < size; i++) {
						News news = (News) newsList8.get(i); //获取新闻对象
			%>
			<dd>
				<ul class="ico2">
					<li><a href="ShowNewsServlet?id=<%=news.getId()%>"
						class="title"><%=news.getTitle()%></a></li>
				</ul>
			</dd>
			<%
				}
				}
			%>
		</dl>
	</div>
	<!-- right end -->
	</div>
	<!-- main end -->

	<!-- footer start -->
	<div class="footer">
		<p>Copyright&nbsp;&copy;&nbsp;C2组&nbsp;&nbsp;版权所有</p>
	</div>
	<!-- footer end -->
</body>

</html>