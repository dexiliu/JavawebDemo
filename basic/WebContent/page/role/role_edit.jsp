<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<div id="main">
	<h1>
		编辑角色信息
	</h1>
	<p>
	</p>
	<form action="save.do" method="post">
		<input type="hidden" name="id" value="${id }"/>
		<fieldset>
			<dl>
				<dt>
					<label for="username">
						角色名:
					</label>
					<br>
					<span></span>
				</dt>
				<dd>
					<input type="text" name="role.name" value="${role.name }"/>
					${errorMap.name}
				</dd>
			</dl>
			
			<dl>
				<dt>
					<label for="username">
						显示顺序:
					</label>
					<br>
					<span></span>
				</dt>
				<dd>
					<input type="text" name="role.weight" value="${role.weight }"/>
				</dd>
			</dl>
			
			<dl>
				<dt>
					<label for="username">
						拥有权限:
					</label>
					<br>
					<span></span>
				</dt>
				<dd>
					<table cellspacing="1">
						<thead>
							<tr>
								<th style="width: 1%;">
									<input type="checkbox" id="selectall" onChange="selectAll('selectall','permissionIds');">
								</th>
								<th>
									权限值
								</th>
							</tr>
						</thead>
						<tbody>							
							<c:forEach items="${permissions}" var="data" >
							<c:set value="" var="checked"/>
							<tr>
								<c:forEach items="${permissionIds }" var="innerData">
								    <c:if test="${innerData==data.id}">
								      <c:set value="checked" var="checked"/>
								    </c:if>
								</c:forEach>
								<td><input type="checkbox" name="permissionIds" value="${data.id}" ${checked }></td>
								<td>${data.value}</td>
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