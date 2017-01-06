<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<div id="main">
	<h1>
		编辑用户信息
	</h1>
	<p>
	</p>
	<form action="save.do" method="post">
		<input type="hidden" name="id" value="${id }"/>
		<fieldset>
			<dl>
				<dt>
					<label for="username">
						用户名:
					</label>
					<br>
					<span></span>
				</dt>
				<dd>
					<input type="text" name="user.username" value="${user.username }"/>
					${errorMap.username}
				</dd>
			</dl>
			<dl>
				<dt>
					<label for="username">
						密码:
					</label>
					<br>
					<span></span>
				</dt>
				<dd>
					<input type="password" name="user.password" value="${user.password }"/>
					${errorMap.password}
				</dd>
			</dl>
			<dl>
				<dt>
					<label for="username">
						重复密码:
					</label>
					<br>
					<span></span>
				</dt>
				<dd>
					<input type="password" name="user.repeatPassword" value="${user.repeatPassword }"/>
					${errorMap.repeatPassword}
				</dd>
			</dl>
			<dl>
				<dt>
					<label for="username">
						昵称:
					</label>
					<br>
					<span></span>
				</dt>
				<dd>
					<input type="text" name="user.name" value="${user.name }"/>
					${errorMap.name}
				</dd>
			</dl>
			<dl>
				<dt>
					<label for="username">
						拥有角色:
					</label>
					<br>
					<span></span>
				</dt>
				<dd>
					<table cellspacing="1">
						<thead>
							<tr>
								<th style="width: 1%;">
									<input type="checkbox" id="selectall" onChange="selectAll('selectall','roleIds');">
								</th>
								<th>
									角色名
								</th>
							</tr>
						</thead>
						<tbody>							
							<c:forEach items="${roles}" var="data" >
							<c:set value="" var="checked"/>
							<tr>
								<c:forEach items="${roleIds }" var="innerData">
								    <c:if test="${innerData==data.id}">
								      <c:set value="checked" var="checked"/>
								    </c:if>
								</c:forEach>
								<td><input type="checkbox" name="roleIds" value="${data.id}" ${checked }></td>
								<td>${data.name}</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</dd>
			</dl>
		</fieldset>
		<br>
		<input type="submit" value="提交" class="button2" />
	</form>
</div>
<script type="text/javascript" src="${ctx}/static/js/selectall.js"></script>