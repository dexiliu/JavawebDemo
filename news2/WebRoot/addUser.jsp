<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新闻系统 - 创建新闻页面</title>
		<link href="css/admin.css" rel="stylesheet" type="text/css" />
		<style type="text/css"> <!--内部样式表-->
			tr{
				height:22px;
			}
			.td{
				text-align:center;
			}
		</style>
		
		<script type="text/javascript">
			function check(){
				//获取输入信息，“.value”即获取此元素的值。
				var name = document.getElementById("name").value;
				var password = document.getElementById("password").value;
				var password2 = document.getElementById("password2").value;
				var role=document.getElementById("role").value;

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
		 		if(role==0||role==1){
		 			alert("添加成功！")
		 		    return true;
		 		}
			}
		</script>
		
	</head>

	<body>
		<!--  新闻表单   -->
		<form action="AddUserServlet"  name="AddUserServlet" method="post">
			<table>
			<tr bgcolor="#E7E7E7">
					<td height="24" colspan="10">
						&nbsp;添加用户&nbsp;
					</td>
				</tr>
						<tr>
							<td width="80"> 用户名： </td>
							<td width="480">
								<input type="text" name="name" id="name" value="" size="60"/>
								会员名须以字母开头，至少4位（可用字母、数字、下划线；建议用email作会员名）。
							</td>
							</tr>
						
								
							

						<tr>
							<td> 密码： </td>
							<td>
								<input type="password" name="password" id="password" value=""  size="60"/>
								密码设置请勿过于简单，至少6位；建议使用数字、字母混合排列，区分大小写。
							</td>
							<td align="left"></td>
						</tr>
						
								
							
						
						<tr>
							<td> 重复密码： </td>
							<td>
								<input type="password" name="password2" id="password2" value="" size="60"/>
								重复密码设置一定要与上边密码设置一致。
							</td>
							<td align="left"></td>
						</tr>
						
								
							
						<tr>
							<td> 用户角色： </td>
							<td>
								<input type="role" name="role" id="role" value="0" size="60"/>
								0代表普通编辑员，1代表管理员。
							</td>
							<td align="left"></td>
						</tr>
						
								
				
						<tr>
							<td colspan="3">
								<input type="submit" value="提交" class="button" onclick="return check()"/>
							</td>
						</tr>
					</table>
		</form>
	</body>
</html>