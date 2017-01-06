<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="main">
	<form name="form1" action="list.do" method="post">
		<fieldset style="float: left;" class="display-options">
		</fieldset>

		<div class="clearfix">
			&nbsp;
		</div>

		<table cellspacing="1">
			<thead>
				<tr>
					<th style="width: 15%;">
						角色名
					</th>
					<th style="width: 15%;">
						显示顺序
					</th>
					<th style="width: 15%;">
						操作
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${roles}" var="data" varStatus="status">
				<c:choose>
				    <c:when test="${status.count%2==0}">
				      <c:set value="row2" var="trClass"/>
				    </c:when>
				    <c:otherwise>  
				      <c:set value="row1" var="trClass"/>
				    </c:otherwise>
				</c:choose>
				<tr class="${trClass }">
					<td>${data.name }</td>
					<td>${data.weight }</td>
					<td>
						<a href="edit.do?id=${data.id }">修改</a>
						<a href="javascript:onDelete(${data.id})">删除</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>

		</table>
	</form>
	<a href="add.do">添加</a>
</div>
<script type="text/javascript">
	function onDelete(id) {
		if (confirm('确定删除？')) {
		     window.location.href='delete.do?id='+id;
		}
	}
</script>