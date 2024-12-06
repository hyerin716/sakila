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
			<h1>지점 추가</h1>
			<!-- Manager Staff 선택 -->
			<h2 class="mt-3">manager_staff를 선택하세요</h2>
			<select id="resultManagerStaffId" size="10">
				<c:forEach var="s" items="${staffList}">
					<option value="${s.staffId}">
						(ManagerStaff ID : ${s.staffId}) ${s.firstName} ${s.lastName}
					</option>
				</c:forEach>
			</select>
			<br>
			<button type="button" id="btnManagerStaffId">매니저스태프 선택</button>
			
			<!-- Address 선택 -->
			<h2 class="mt-3">주소를 선택하세요</h2>
			<select id="resultAddress" size="10">
				<c:forEach var="a" items="${addressList}">
					<option value="${a.addressId}">
						(Address ID : ${a.addressId}) ${a.address}
					</option>
				</c:forEach>
			</select>
			<br>
			<button type="button" id="btnAddrSel">주소선택</button>
			
			<form action="${pageContext.request.contextPath}/on/addStore" method="post">
				<table class="table" style="width=80%">
					<tr>
						<td>managerStaffId</td>
						<td>
							<input type="text" name="managerStaffId" id="managerStaffId" readonly>
						</td>
					</tr>
					<tr>
						<td>addressId</td>
						<td>
							<input type="text" name="addressId" id="addressId" readonly>
						</td>
					</tr>
				</table>
				<button id="btnAddStore" type="submit">지점 추가</button>
			</form>
		</div>
	</div>
</body>
<script>
	// 매니저스태프 선택 버튼
	$('#btnManagerStaffId').click(function () {
		console.log($('#resultManagerStaffId').val()); // 디버깅
		if($('#resultManagerStaffId').val() == null || $('#resultManagerStaffId').val() == ''){
			alert('매니저 스태프 아이디를 먼저 선택하세요');	
		} else {
			$('#managerStaffId').val($('#resultManagerStaffId').val());
		}
	});
	
	// 주소 선택 버튼
	$('#btnAddrSel').click(function () {
		console.log($('#resultAddress').val()); // 디버깅
		if($('#resultAddress').val() == null || $('#resultAddress').val() == ''){
			alert('주소 선택을 먼저 하세요');	
		} else {
			$('#addressId').val($('#resultAddress').val());
		}
		
	});
</script>
</html>