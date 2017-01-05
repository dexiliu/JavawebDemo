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
		var mailbox=document.getElementById("mailBox").value;
		if(mailbox==""||mailbox.equals("")){
			alert("请正确填写邮箱地址！");
			return false;
		}
	}
	</script>
  </head>

  <body>
    <form action="forgetPassword.do?toMailBox" method="post" >
  		邮箱:<input type="text" name="mailBox" id="mailBox"/>
  		<br/>
		<p><button type="submit" onclick="return check()">找回密码</button></p>
	</form>                      
  </body>
</html>
