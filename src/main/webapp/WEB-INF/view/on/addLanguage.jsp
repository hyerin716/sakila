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
			<h1>LANGUAGE 추가</h1>
			<form id="addLanguageForm" action="${pageContext.request.contextPath}/on/addLanguage" method="post">
				<table class="table" style="width : 80%">
					<tr>
						<td>언어</td>
						<td>
							<input type="text" name="name" id="name">
						</td>
					</tr>
				</table>
				<button id="btnAddLanguage" type="button">언어 추가</button>
			</form>
			
		</div>
	</div>
	
</body>
<script>
	$('#btnAddLanguage').click(function() {
		// 입력폼 유효성 검사
		if($('#name').val() == null || $('#name').val() == ''){ // 입력x 유효성검사
			alert('언어를 입력하세요');
		} else if(){ // 중복유효성 검사
			
		} else{
			$('#addLanguageForm').submit();
		}
	});

</script>
</html>