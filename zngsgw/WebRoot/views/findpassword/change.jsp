<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>找回密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">
	function check(){
		var password1=document.getElementById("password1").value;
		var password2=document.getElementById("password2").value;
		if(password1==""||password2==""){
			alert("请填写密码！");
			return false;
		}
		if(password1!=password2){
			alert("密码不一致！");
			return false;
		}
	}
	</script>
  </head>

  <body>
    <form action="forgetPassword.do?changePassword" method="post" >
  		新密码&nbsp;&nbsp;&nbsp;&nbsp;:<input type="password" name="password1" id="password1"/>
  		<br/>
  		重复输入密码:<input type="password" name="password2" id="password2"/>
  		<br/>
		<p><button type="submit" onclick="return check()">确定</button></p>
	</form>                        
  </body>
</html>
