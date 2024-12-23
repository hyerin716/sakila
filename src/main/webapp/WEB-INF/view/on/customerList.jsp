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
			<h1>customerList</h1>
			<div>
				<form id="formSearch" action="${pageContext.request.contextPath}/on/customerList" method="get">
					<input type="text" name="searchName" id="searchName">
					<button type="button" id="btnSearch">이름검색</button>
				</form>
			</div>
			<table class="table" style="width : 80%">
				<tr>
					<td>customerId</td>
					<td>storeId</td>
					<td>firstName</td>
					<td>lastName</td>
					<td>email</td>
					<td>addressId</td>
					<td>active</td>
					<td>createDate</td>
					<td>lastUpdate</td>
				</tr>
				<c:forEach var="c" items="${customerList}">
					<tr>
						<td>
							<!-- 고객 상세 정보(주소 x 렌탈 x 지불..조인 발생.. -->
							<a href="${pageContext.request.contextPath}/on/customerOne?customerId=${c.customerId}">
								${c.customerId}
							</a>
						</td>
						<td>${c.storeId}</td>
						<td>${c.firstName}</td>
						<td>${c.lastName}</td>
						<td>${c.email}</td>
						<td>${c.addressId}</td>
						<td>${c.active}</td>
						<td>${c.createDate}</td>
						<td>${c.lastUpdate}</td>
					</tr>
				</c:forEach>
			</table>
			
			<div>
				<!-- 페이징 -->
				<!-- 이전 11 12 13 14 15 16 17 18 19 20 다음 -->
				<!-- 검색어 없는 경우 -->
				<c:if test="${searchName == null}">
					<c:if test="${startPagingNum > 1}">
						<a href ="${pageContext.request.contextPath}/on/customerList?currentPage=${startPagingNum-10}">
							[이전]
						</a>
					</c:if>
					
					<c:forEach var="num" begin="${startPagingNum}" end="${endPagingNum}">
						<c:if test="${num == currentPage}">
							${num}&nbsp;
						</c:if>
						<c:if test="${num != currentPage}">
							<a href="${pageContext.request.contextPath}/on/customerList?currentPage=${num}">						
								${num}
							</a>
							&nbsp;
						</c:if>
					</c:forEach>
					<c:if test="${endPagingNum != lastPage}">
						<a href ="${pageContext.request.contextPath}/on/customerList?currentPage=${startPagingNum+10}">
							[다음]
						</a>
					</c:if>
				</c:if>				
				<!-- 검색어 있는 경우 -->
				<c:if test="${searchName != null}">
					<c:if test="${startPagingNum > 1}">
						<a href ="${pageContext.request.contextPath}/on/customerList?currentPage=${startPagingNum-10}&searchName=${searchName}">
							[이전]
						</a>
					</c:if>
					
					<c:forEach var="num" begin="${startPagingNum}" end="${endPagingNum}">
						<c:if test="${num == currentPage}">
							${num}&nbsp;
						</c:if>
						<c:if test="${num != currentPage}">
							<a href="${pageContext.request.contextPath}/on/customerList?currentPage=${num}&searchName=${searchName}">						
								${num}
							</a>
							&nbsp;
						</c:if>
					</c:forEach>
					<c:if test="${endPagingNum != lastPage}">
						<a href ="${pageContext.request.contextPath}/on/customerList?currentPage=${startPagingNum+10}&searchName=${searchName}">
							[다음]
						</a>
					</c:if>
				</c:if>
			</div>
			
		</div>
	</div>
	
</body>
<script>
	$('#btnSearch').click(function(){
		if($('#searchName').val() == ''){
			alert('검색어를 입력하세요.');
			return;
		}
		$('#formSearch').submit();
	});
</script>

</html>