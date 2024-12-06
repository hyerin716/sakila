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
			<h1>Category List</h1>
			
			<table class="table" style="width : 80%">
				<tr>
					<th>ID</th>
					<th>카테고리명</th>
					<th>lastUpdate</th>
				</tr>
				<c:forEach var="c" items="${categoryList}">
					<tr>
						<td>${c.categoryId}</td>
						<td>${c.name}</td>
						<td>${c.lastUpdate}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
</body>
</html>