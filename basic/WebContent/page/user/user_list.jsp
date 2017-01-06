<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="main">
	<form name="form1" action="list.do" method="post">
		<fieldset style="float: left;" class="display-options">
			<input type="text" name="qp.name" value="${qp.name}"> &nbsp;
			<input type="button" onclick="submitWithoutNumber()" value="查询" class="button2">
		</fieldset>

		<div class="clearfix">
			&nbsp;
		</div>

		<table cellspacing="1">
			<thead>
				<tr>
					<th style="width: 15%;">
						用户名
					</th>
					<th>
						昵称
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
					<td>${data.username }</td>
					<td>${data.name }</td>
					<td><a href="edit.do?id=${data.id }">修改</a></td>
				</tr>
				</c:forEach>
			</tbody>

		</table>
		<%@ include file="../tag/pagination.jsp"%>
	</form>
	<a href="add.do">添加</a>
</div>