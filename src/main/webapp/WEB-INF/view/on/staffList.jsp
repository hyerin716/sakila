<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
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
			<h1>STAFF LIST</h1>
			<table class="table table-striped">
				<tr>
					<th>staffId</th>
					<th>firstName</th>
					<th>last_name</th>
					<th>addressId</th>
					<th>email</th>
					<th>storeId</th>
					<th>username</th>
					<th>lastUpdate</th>
					<th>active</th>
					<th>활성/비활성화</th>
				</tr>
				<c:forEach var="s" items="${staffList}">
					<tr>
						<td>${s.staffId}</td>
						<td>${s.firstName}</td>
						<td>${s.lastName}</td>
						<td>${s.addressId}</td>
						<td>${s.email}</td>
						<td>${s.storeId}</td>
						<td>${s.username}</td>
						<td>${s.lastUpdate}</td>
						<td>${s.active}</td>
						<td>
							<a href="${pageContext.request.contextPath}/on/modifyStaffActive?staffId=${s.staffId}&active=${s.active}" class="btn btn-primary">
								<c:if test="${s.active == 1}">사용금지(2)로 변경</c:if>
								<c:if test="${s.active == 2}">사용가능(1)으로 변경</c:if>
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			
			<a href="${pageContext.request.contextPath}/on/staffList?currentPage=1">처음</a>
			<c:if test="${currentPage > 1}">
				<a href="${pageContext.request.contextPath}/on/staffList?currentPage=${currentPage-1}">이전</a>		
			</c:if>		
			<c:if test="${currentPage < lastPage}">
				<a href="${pageContext.request.contextPath}/on/staffList?currentPage=${currentPage+1}">다음</a>
			</c:if>
			<a href="${pageContext.request.contextPath}/on/staffList?currentPage=${lastPage}">마지막</a>		
			
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			    <li class="page-item">
			    	<a class="page-link" href="${pageContext.request.contextPath}/on/staffList?currentPage=1" aria-label="Previous">
			   			 <span aria-hidden="true">&laquo;</span>
			   		</a>
			    </li>
			    <li class="page-item"><a class="page-link" href="#">1</a></li>
			    <li class="page-item"><a class="page-link" href="#">2</a></li>
			    <li class="page-item"><a class="page-link" href="#">3</a></li>
			    
			    
			    <li class="page-item">
			    	<a class="page-link" href="${pageContext.request.contextPath}/on/staffList?currentPage=${lastPage}" aria-label="Next">
			    		 <span aria-hidden="true">&raquo;</span>
			    	</a>
			    </li>
			  </ul>
			</nav>
			
		</div>
	</div>
	
</body>
</html>