<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.model.News"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新闻系统 - 新闻详情页面</title>
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

	<body>
		

		<!-- menu start -->
		<br><br><br>
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
				<div class="place">
					<strong>当前位置:</strong>  &gt; 文章查看
				</div>
        <%
			//获取新闻列表
			List<News> newsList = (List<News>)request.getAttribute("newsList");
			if(newsList != null) {
				int size = newsList.size();
				for(int i = 0; i < size; i++) {
					News news = (News)newsList.get(i);  //获取新闻对象
		 %>
				<div class="viewbox">
					<div class="title">
						<h2>
							<%=news.getTitle() %>
						</h2>
					</div>
					<div class="info">
						<small>时间:</small><%=news.getCreateTime() %>
						<small>来源:</small><%=news.getSource() %>
						<small>作者:</small><%=news.getAuthor() %>
						<small>点击:</small><%=news.getClick() %>
					</div>
					<div class="content">
						<%=news.getContent() %>
					</div>
					</div>
		<%
		 		}
		 	}
		%>
			</div>
			</div>
			<!-- left end -->
			
		<!-- main end -->
		
		<!-- footer start -->
		<div class="footer">
			<p>Copyright&nbsp;&copy;&nbsp;C2组&nbsp;&nbsp;版权所有</p>
		</div>
		<!-- footer end -->
	</body>
</html>