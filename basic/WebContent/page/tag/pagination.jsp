<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" href="${ctx}/static/jquery/pagination.css"
	type="text/css">
<script type="text/javascript" src="${ctx}/static/js/pagination.js"></script>

<div class="pagination" style="float: right;">
	<input type="hidden" id="qp_number" name="qp.number" value="${qp.number }">
	<c:if test="${qp.totalPages != 0}">
		<c:choose>
			<c:when test="${qp.firstPage}">
		      <span class="current prev">上一页</span>
		    </c:when>
		    <c:otherwise>  
		       <a href="javascript:onPrev();" class="prev">上一页</a>
		    </c:otherwise>
	    </c:choose>
		
		<c:forEach var="x" begin="1" end="${qp.totalPages}">
			<c:choose>
				<c:when test="${qp.number==x}">
			      <span class="current">${x }</span>
			    </c:when>
			    <c:otherwise>  
			      <a href="javascript:goPage(${x });">${x }</a>
			    </c:otherwise>
		    </c:choose>
		</c:forEach>
		
		<c:choose>
			<c:when test="${qp.lastPage}"> 
		      <span class="current next">下一页</span>
		    </c:when>
		    <c:otherwise>  
		      <a href="javascript:onNext();" class="next">下一页</a>
		    </c:otherwise>
	    </c:choose>
    </c:if>
</div>
