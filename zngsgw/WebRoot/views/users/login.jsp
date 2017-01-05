<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
		function check(){
			//获取输入信息：用户名、密码。“.value”即获取此元素的值。
			var name = document.getElementById("username").value;
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
  <p>${msg }</p>
    <form action="users.do?login" method="post" >
  		UserName:<input type="text"  name="username" id="username" value=""/>
  		<br/>
		Password:<input type="password"  name="password" id="password" value=""/>
		<br/>
		<p><button type="submit" onclick="return check()">Login</button> <button type="reset">Reset</button>
		<a href="forgetPassword.do?toFind">忘记密码？</a>
		</p>
	</form>
  </body>
</html>
