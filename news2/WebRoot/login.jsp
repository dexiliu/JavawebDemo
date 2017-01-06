<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新闻系统 - 登录页面</title>
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function check(){
				//获取输入信息：用户名、密码。“.value”即获取此元素的值。
				var name = document.getElementById("name").value;
				var password = document.getElementById("password").value;

				//验证用户名不为空
				if (name == "") {
	 				// 在页面弹出提示框
	 				alert("请填写用户名！"); 
	 				// 返回false，阻止表单提交
			 		return false;
		 		}
	
				if (password == "") {
		 			alert("请填写密码！"); 
		 			return false;
		 		}
			}
		</script>
	</head>

	<body>
		<!-- header start -->
		<div class="header">
			<div class="toplinks">
				<span><a href="ColumnNewsId1"><img alt="" src="images/return.png" width="105" height="25"/></a>
				<a href="register.jsp"><img alt="注册" src="images/register.png" width="105" height="25"/></a>
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

		<!-- main start -->
		<div class="main">
			<form action="login" method="post">
				<div class="register_main">
					<table>
						<tr>
							<td width="60">
								用户名：
							</td>
							<td width="180">
								<!-- 为元素定义id属性，可通过document对象访问 -->
								<input type="text" name="name" id="name" value="" />
							</td>
							<td width="220"></td>
						</tr>

						<tr>
							<td>
								密&nbsp;&nbsp;&nbsp;码：
							</td>
							<td>
								<input type="password" name="password" id="password" value="" />
							</td>
							<td></td>
						</tr>

						<tr>
							<td colspan="3">
								<!-- 此处显示提示信息 -->
							</td>
						</tr>

						<tr>
							<td colspan="3">
								<!-- 为提交按钮设置onclick事件，当点击鼠标时，会触发调用JavaScript
								函数，进行表单验证，通过return将函数的结果返回，以阻止表单验证失败后提交-->
								<input type="submit" value="" class="button" onclick="return check()"/>
							</td>
						</tr>
					</table>
				</div>
			</form>
			</div>
		<!-- main end -->

		<!-- footer start -->
		<div class="footer">
			<p>Copyright&nbsp;&copy;&nbsp;C2组&nbsp;&nbsp;版权所有</p>
		</div>
		<!-- footer end -->
	</body>
</html>