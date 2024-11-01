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
			<h1 class="bg-light mt-3">STAFF 정보</h1>
			<table class="mt-5 table">
				
				<tr>
					<th>STAFF ID</th>
					<td>${staff.staffId}</td>
				</tr>
				<tr>
					<th>First Name</th>
					<td>${staff.firstName}</td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td>${staff.lastName}</td>
				</tr>
				<tr>
					<th>Address ID</th>
					<td>${staff.addressId}</td>
				</tr>
				<tr>
					<th>email</th>
					<td>${staff.email}</td>
				</tr>
				<tr>
					<th>Store ID</th>
					<td>${staff.storeId}</td>
				</tr>
				<tr>
					<th>Store ID</th>
					<td>${staff.storeId}</td>
				</tr>
				<tr>
					<th>Username</th>
					<td>${staff.username}</td>
				</tr>
				<tr>
					<th>Last Update</th>
					<td>${staff.lastUpdate}</td>
				</tr>
			</table>
		</div>
		
		
	</div>
	
</body>
</html>