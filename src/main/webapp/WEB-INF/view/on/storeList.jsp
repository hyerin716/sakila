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
					<th>staffId</th>
					<th>firstName</th>
					<th>lastName</th>
					<th>email</th>
					<th>addressId</th>
					<th>address</th>
					<th>address2</th>
					<th>district</th>
					<th>phone</th>
				</tr>
				<c:forEach var="s" items="${storeList}">
					<tr>
						<td>${s.storeId}</td>
						<td>${s.staffId}</td>
						<td>${s.firstName}</td>
						<td>${s.lastName}</td>
						<td>${s.email}</td>
						<td>${s.addressId}</td>
						<td>${s.address}</td>
						<td>${s.address2}</td>
						<td>${s.district}</td>
						<td>${s.phone}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
</body>
</html>