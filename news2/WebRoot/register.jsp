﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新闻系统 - 注册页面</title>
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function check(){
				//获取输入信息，“.value”即获取此元素的值。
				var name = document.getElementById("name").value;
				var password = document.getElementById("password").value;
				var password2 = document.getElementById("password2").value;

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
		 		
		 		if (password2 == "" || password2 != password) {
		 			alert("重复密码需要与密码保持一致！"); 
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
			<form action="register" method="post">
				<div class="register_main">
					<table>
						<tr>
							<td width="80"> 用户名： </td>
							<td width="480">
								<input type="text" name="name" id="name" value="" />
							</td>
							<td align="left"></td>
						</tr>
						<tr>
							<td class="info" colspan="3">
								会员名须以字母开头，至少4位（可用字母、数字、下划线；建议用email作会员名）。
							</td>
						</tr>

						<tr>
							<td> 密码： </td>
							<td>
								<input type="password" name="password" id="password" value="" />
							</td>
							<td align="left"></td>
						</tr>
						<tr>
							<td class="info" colspan="3">
								密码设置请勿过于简单，至少6位；建议使用数字、字母混合排列，区分大小写。
							</td>
						</tr>
						<tr>
							<td> 重复密码： </td>
							<td>
								<input type="password" name="password2" id="password2" value="" />
							</td>
							<td align="left"></td>
						</tr>
						<tr>
							<td class="info" colspan="3">
								重复密码设置一定要与上边密码设置一致。
							</td>
						</tr>
						<td colspan="2" style="text-align:center;color:red;">
					<%
					    if(request.getAttribute("message")!=null){
					%>
					<%=request.getAttribute("message")%>
					<%}%>
					</td>
				</tr>
						<tr>
							<td colspan="3">
								  <input type="submit" value=""  class="button1" onclick="return check()"/>
								
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