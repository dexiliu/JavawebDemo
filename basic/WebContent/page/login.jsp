<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<div id="main">
	<h1>
		用户登录
	</h1>
	<p>
		管理员登录：admin/123，拥有所有权限<br/>
		老师登录：teacher/123，拥有所有学生操作权限<br/>
		班长登录：monitor/123，拥有查询学生权限<br/>
	</p>
	<form action="${ctx}/login.do" method="post">
		<input type="hidden" name="id" value="${id }"/>
		<fieldset>
			<dl>
				<dt>
					<label for="username">
						User Name:
					</label>
					<br>
					<span></span>
				</dt>
				<dd>
					<input type="text" name="username" value="${username }"/>
				</dd>
			</dl>
			<dl>
				<dt>
					<label for="username">
						Password:
					</label>
					<br>
					<span></span>
				</dt>
				<dd>
					<input type="text" name="password" value="${password }"/>
				</dd>
			</dl>
		</fieldset>
		${errorMap.loginerror}
		<br><br>
		<input type="submit" value="提交" class="button2" />
	</form>
</div>