<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<div id="header" class="clearfix">
			<h1><a href="${pageContext.request.contextPath}/${id}">${blogMap.blogVo.blogTitle}</a></h1>
			<c:choose>
				<c:when test="${sessionScope.loginUser.id == null}">
				<!-- 로그인 전 메뉴 -->
					<ul class="clearfix">
						<li><a class="btn_s" href="${pageContext.request.contextPath}/user/loginForm">로그인</a></li>
					</ul>	
				</c:when>
				<c:otherwise>
				<!-- 로그인 후 메뉴 -->
				<!-- 자신의 블로그일때만 관리 메뉴가 보인다. -->
						<!--<c:if test="${loginUser.id == blogMap.blogVo.id}"></c:if>-->
					<ul class="clearfix">
							<li><a class="btn_s" href="${pageContext.request.contextPath}/${id}/admin/basic">내블로그 관리</a></li>
							<li><a class="btn_s" href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
		 			</ul>
		 		</c:otherwise>
		 	</c:choose>
		</div>
		<!-- //header -->
