<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<c:set var="currentTab" value="${pageContext.request.servletPath}"/>
<c:set var="currentTab" value="${fn:substringAfter(currentTab, '/')}"/>
<c:set var="currentTab" value="${fn:substringBefore(currentTab, '/')}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
		<title>DevNote</title>
		
		<!-- css include -->
		<link rel="stylesheet" href="${ctx}/static/css/main.css" type="text/css"/>
		
		<!-- js include -->
		<script type="text/javascript" src="${ctx}/static/jquery/jquery-1.7.2.min.js"></script>
		
	</head>
	<body>
		<div id="wrap">
			<div id="page-header">
				<p>
					<shiro:user>你好, <shiro:principal/> <a href="${ctx}/logout.do">退出</a></shiro:user>
				</p>
			</div>
			<div id="page-body">
				<div id="tabs">
					<ul>
						<li <c:if test="${currentTab=='student' }">id="activetab"</c:if>>
							<a href="${ctx }/student/list.do"><span>学生管理</span>
							</a>
						</li>
						
						<shiro:hasAnyRoles name="admin">
						<li <c:if test="${currentTab=='permission' }">id="activetab"</c:if>>
							<a href="${ctx }/permission/list.do"><span>权限管理</span>
							</a>
						</li>
						<li <c:if test="${currentTab=='role' }">id="activetab"</c:if>>
							<a href="${ctx }/role/list.do"><span>角色管理</span>
							</a>
						</li>
						<li <c:if test="${currentTab=='user' }">id="activetab"</c:if>>
							<a href="${ctx }/user/list.do"><span>用户管理</span>
							</a>
						</li>
						</shiro:hasAnyRoles>
					</ul>
				</div>

				<div id="acp">
					<div class="panel">
						<span class="corners-top"><span></span>
						</span>
						<div id="content">

							<div id="menu">
								<ul>
									<li>
										<a href="#"><span>子菜单 或</span>
										</a>
									</li>
									<li>
										<a href="#"><span>其他内容</span>
										</a>
									</li>
									<li>
										&nbsp;
									</li>
								</ul>
							</div>
							<sitemesh:body/>
						</div>
						<span class="corners-bottom"><span></span>
						</span>
						<div class="clear"></div>
					</div>
				</div>

			</div>

			<div id="page-footer">
				<p>
					DevNote &copy;2013
				</p>
			</div>

		</div>
	</body>
</html>