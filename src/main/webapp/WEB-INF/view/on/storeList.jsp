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
			<h1>store list</h1>
			
			<table class="table table-striped">
				<tr>
					<th>storeId</th>
					<th>인벤토리 리스트</th>
					<th>인벤토리 추가</th>
					<th>지점_address</th>
					<th>지점_district</th>
					<th>지점_cityId</th>
					<th>지점_poastalCode</th>
					<th>지점_phone</th>
					<th>managerStaffId</th>
					<th>매니저_firstName</th>
					<th>매니저_lastName</th>
					<th>매니저_email</th>
					<th>매니저_username</th>
				</tr>
				<c:forEach var="s" items="${storeList}">
					<tr>
						<td>${s.storeId}</td>
						<td>
							<a href="${pageContext.request.contextPath}/on/inventoryList?storeId=${s.storeId}">인벤토리 리스트</a>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/on/addInventory?storeId=${s.storeId}">인벤토리 추가</a>
						</td>
						<td>${s.address}</td>
						<td>${s.district}</td>
						<td>${s.cityId}</td>
						<td>${s.poastalCode}</td>
						<td>${s.phone}</td>
						<td>${s.managerStaffId}</td>
						<td>${s.firstName}</td>
						<td>${s.lastName}</td>
						<td>${s.email}</td>
						<td>${s.username}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
</body>
</html>