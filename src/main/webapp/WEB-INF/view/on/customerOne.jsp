<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="container-flud">
	<div class="row">
		<div class="col-sm-2 bg-light">
			<!-- leftMenu.jsp include -->
			<c:import url="/WEB-INF/view/on/inc/leftMenu.jsp"></c:import>
		</div>
		
		<div class="col-sm-10">
			<!-- main content -->
			<h1>고객 상세정보</h1>
		
			<!-- 고객정보 출력 -->
			<h2>고객 정보</h2>
			<table class="table" style="width: 80%;">
				<tr>
					<td>customerId</td>
					<td>${customer.customerId}</td>
				</tr>
				<tr>
					<td>firstName</td>
					<td>${customer.firstName}</td>
				</tr>
				<tr>
					<td>lastName</td>
					<td>${customer.lastName}</td>
				</tr>
				<tr>
					<td>email</td>
					<td>${customer.email}</td>
				</tr>
				<tr>
					<td>address</td>
					<td>${customer.address}</td>
				</tr>
			</table>
			<!-- 대여정보 있을 경우 출력 -->
			<!-- 대여정보 출력 -->
			<h2>대여 정보</h2>
			<table class="table" style="width: 80%;">
				<tr>
					<th>대여 날짜</th>
					<th>대여 film</th>
					<th>대여점</th>
				</tr>
				<c:forEach var="r" items="${rentalList}">
					<c:if test="${r.customerId != null}">
						<tr>
							<td>${r.rentalDate}</td>
							<td>${r.title}</td>
							<td>${r.storeId}</td>						
						</tr>
					</c:if>
				</c:forEach>
				<c:if test="${empty rentalList}">
					<tr>
						<td colspan="3" style="text-align: center;">대여 정보가 없습니다.</td>
					</tr>
				</c:if>
			</table>

		</div>		
		
		
		
	</div>
	
</body>
</html>