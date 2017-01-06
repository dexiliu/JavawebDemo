<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.model.News"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新闻系统 - 栏目新闻列表</title>
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
				<a href="ColumnNewsId1"><img src="images/logo.gif" width="960" height="150"
						alt="新闻系统" /> </a>
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

		<!-- main start -->
		<div class="main">
			<!-- left start -->
			<div class="left">
			    <!-- place start -->
				<div class="place">
					<strong>当前位置:</strong> 国内新闻 &gt; 文章列表
				</div>
				<!-- place end -->
				<ul class="newslist">
				<%
					//获取新闻列表
					List<News> newsList2 = (List<News>)request
							.getAttribute("newsList2");
					if (newsList2 != null){
						int size = newsList2.size();
						for (int i = 0; i < size; i++) {
							News news = (News) newsList2.get(i); //获取新闻对象
				%>
					<li>
						<a href="ShowNewsServlet?id=<%=news.getId()%>"
							class="title"><%=news.getTitle()%></a>
						<small>日期：</small><%=news.getCreateTime() %>
						<small>点击：</small><%=news.getClick() %>
					</li>
				<%
					}
					}
				%>
				</ul>
				
				
			</div>
			<!-- left end -->

			<!-- right start -->
			<div class="right">
				<dl class="tbox">
					<dt>
						<strong>最新更新</strong>
					</dt>
					<dd>
						<ul class="ico1">
							<li>
								<a href="#">你所不知道的白岩松</a>
							</li>
							<li>
								<a href="#">你所不知道的白岩松</a>
							</li>
							<li>
								<a href="#">你所不知道的白岩松</a>
							</li>
							<li>
								<a href="#">你所不知道的白岩松</a>
							</li>
							<li>
								<a href="#">你所不知道的白岩松</a>
							</li>

						</ul>
					</dd>
				</dl>

				<dl class="tbox">
					<dt>
						<strong>热点内容</strong>
					</dt>
					<dd>
						<ul class="ico2">
							<li>
								<a href="#">教师节，那些代课老师们</a>
							</li>
							<li>
								<a href="#">十堰他日必大兴</a>
							</li>
							<li>
								<a href="#">城市千金，我要远离农村婆婆</a>
							</li>
							<li>
								<a href="#">你所不知道的白岩松</a>
							</li>
							<li>
								<a href="#">菲律宾总统再次将香港旅客被劫杀惨剧当笑料</a>
							</li>
							<li>
								<a href="#">十堰他日必大兴</a>
							</li>
							<li>
								<a href="#">十堰他日必大兴</a>
							</li>
							<li>
								<a href="#">你所不知道的白岩松</a>
							</li>
							<li>
								<a href="#">你所不知道的白岩松</a>
							</li>
							<li>
								<a href="#">你所不知道的白岩松</a>
							</li>
						</ul>
					</dd>
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