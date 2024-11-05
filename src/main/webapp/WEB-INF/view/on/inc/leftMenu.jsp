<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<ul class="list-group text-center bg-light">
	<li class="list-group-item bg-light">
		<a href="${pageContext.request.contextPath}/on/main">홈으로</a>
	</li>
	<li class="list-group-item bg-light">
		<a href="${pageContext.request.contextPath}/on/staffOne">${loginStaff.username}님</a>
	</li>
	<li class="list-group-item bg-light">
		<a href="${pageContext.request.contextPath}/on/logout">로그아웃</a>
	</li>
	
	<li class="list-group-item bg-light fw-bold">
		::: 지점 관리 :::
	</li>
	
	<li class="list-group-item bg-light">
		<a href="">지점 추가</a>
	</li>
	
	<li class="list-group-item bg-light">
		<a href="">지점 수정</a>
	</li>
	
	<li class="list-group-item bg-light fw-bold">
		::: STAFF 관리 :::
	</li>
	
	<li class="list-group-item bg-light">
		<a href="${pageContext.request.contextPath}/on/staffList">STAFF 리스트</a>
	</li>
	<li class="list-group-item bg-light">
		<a href="${pageContext.request.contextPath}/on/addStaff">STAFF 추가</a>
	</li>
	
	
	<li class="list-group-item bg-light fw-bold">
		::: 고객 관리 :::
	</li>
	<li class="list-group-item bg-light">
		<a href="">고객 리스트</a>
	</li>
	
	<li class="list-group-item bg-light">
		<a href="">고객 추가</a>
	</li>
	
	<li class="list-group-item bg-light fw-bold">
		::: 배우 관리 :::
	</li>
	<li class="list-group-item bg-light">
		<a href="${pageContext.request.contextPath}/on/actorList">배우 리스트</a>
	</li>
	<li class="list-group-item bg-light">
		<a href="${pageContext.request.contextPath}/on/addActor">배우 추가</a>
	</li>
	
	
</ul>
