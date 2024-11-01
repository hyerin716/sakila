<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<!-- body전에 스크립트를 입력하지만 body후에 실행되도록 하는법 -->
<!-- 
<script>
	$(document).ready(function(){
		// body까지 메모리에 로드 후 진행
	});
</script>
 -->
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="container">

	<div class="row mt-5 pt-5">
	  <div class="col-sm-4"></div>
	  	
	  <div class="card col-sm-4">
	  	<h1 class="text-center card-header">Staff Login</h1>
	  	<form id="form" action="${pageContext.request.contextPath}/off/login" method="post">
	  		<div class="card-body">
				<div class="mb-3">
					<div class="mb-3 text-danger">${msg}</div>
					<label for="staffId" class="form-label">STAFF ID</label> 
					<input id="staffId" name="staffId" type="text" class="form-control">
				</div>
				<div class="mb-3">
					<label for="password" class="form-label">STAFF PW</label> 
					<input id="password" name="password" type="password" class="form-control">
				</div>
	  		</div>
			<div class="d-grid">
				<button id="btn" type="button" class="btn btn-outline-primary mt-2 mb-2">로그인</button>
			</div>
		</form>
	  </div>
	  
	  <div class="col-sm-4"></div>
	</div>
	
	

	
	
</body>

<script>
	// btn 버튼 클릭시 폼값 유효성 검사
	$('#btn').click(function() {
		console.log('clik');
		// 숫자가 아니면 isNaN() of $.isNumeric()
		if($.isNumeric($('#staffId').val()) == false){
			alert('staffId는 숫자만 입력 가능');
		} else if($('#password').val().length < 4){
			alert('password는 4자이상 가능');
		} else {
			$('#form').submit();
		}
	
	});
</script>

</html>