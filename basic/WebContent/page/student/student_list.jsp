<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div id="main">
	<form name="form1" action="list.do" method="post">
		<fieldset style="float: left;" class="display-options">
			Name（模糊查询）
			<input type="text" name="qp.name" value="${qp.name}"> &nbsp;
			Email（等值查询）
			<input type="text" name="qp.email" value="${qp.email}"> &nbsp;
			<input type="button" onclick="submitWithoutNumber()" value="查询" class="button2">
		</fieldset>

		<div class="clearfix">
			&nbsp;
		</div>

		<table cellspacing="1">
			<thead>
				<tr>
					<th style="width: 5%;">
						Id
					</th>
					<th style="width: 15%;">
						Name
					</th>
					<th>
						Email
					</th>
					<th style="width: 15%;">
						操作
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${qp.datas}" var="data" varStatus="status">
				<c:choose>
				    <c:when test="${status.count%2==0}">
				      <c:set value="row2" var="trClass"/>
				    </c:when>
				    <c:otherwise>  
				      <c:set value="row1" var="trClass"/>
				    </c:otherwise>
				</c:choose>
				<tr class="${trClass }">
					<td>${data.id }</td>
					<td>${data.name }</td>
					<td>${data.email }</td>
					<td>
						<shiro:hasPermission name="student:edit">
						<a href="edit.do?id=${data.id }">修改</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="student:delete">
						<a href="javascript:onDelete(${data.id})">删除</a>
						</shiro:hasPermission>
					</td>
				</tr>
				</c:forEach>
			</tbody>

		</table>
		<%@ include file="../tag/pagination.jsp"%>
	</form>
	<shiro:hasPermission name="student:add">
	<a href="add.do">添加</a>
	</shiro:hasPermission>
</div>
<script type="text/javascript">
	function onDelete(id) {
		if (confirm('确定删除？')) {
		     window.location.href='delete.do?id='+id;
		}
	}
</script>