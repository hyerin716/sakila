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
			<h1>film 수정</h1>
			<table class="table" style="width: 80%;">
					<tr>
						<td>filmId</td>
						<td>${film.filmId}</td>						
					</tr>
					<tr>
						<td colspan="2" class="fw-bold">필수 항목</td>
					</tr>
					<tr>
						<td>title</td>
						<td>
							<form id="formTitle" action="${pageContext.request.contextPath}/on/modifyFilm" method="post">
								<input type="hidden" name="filmId" value="${film.filmId}">
								<input type="text" name="title" id="title" value="${film.title}">
								<button type="button" id="btnTitle">title 수정</button>
							</form>
						</td>
					</tr>
					<tr>
						<td>language</td>
						<td>
							<form id="formLanguage" action="${pageContext.request.contextPath}/on/modifyFilm" method="post">
								<input type="hidden" name="filmId" value="${film.filmId}">
								<select id="languageId" name="languageId">
									<c:forEach var="la" items="${languageList}">
									 	<option value="${la.languageId}" 
					                        <c:if test="${la.languageId == film.languageId}">selected</c:if>>
					                 		${la.name}
					               	 	</option>
									</c:forEach>
								</select>
								<button type="button" id="btnLanguage">Language 수정</button>
							</form>
						</td>
					</tr>
					<tr>
						<td>rentalDuration</td>
						<td>
							<form id="formRentalDuration" action="${pageContext.request.contextPath}/on/modifyFilm" method="post">
								<input type="hidden" name="filmId" value="${film.filmId}">
								<input type="text" name="rentalDuration" id="rentalDuration" value="${film.rentalDuration}">				
								<button type="button" id="btnRentalDuration">rentalDuration 수정</button>
							</form>
						</td>
					</tr>
					<tr>
						<td>rentalRate</td>
						<td>
							<form id="formRentalRate" action="${pageContext.request.contextPath}/on/modifyFilm" method="post">
								<input type="hidden" name="filmId" value="${film.filmId}">
								<input type="text" name="rentalRate" id="rentalRate" value="${film.rentalRate}">				
								<button type="button" id="btnRentalRate">rentalRate 수정</button>
							</form>
						</td>
					</tr>
					<tr>
						<td>replacementCost</td>
						<td>
							<form id="formReplacementCost" action="${pageContext.request.contextPath}/on/modifyFilm" method="post">
								<input type="hidden" name="filmId" value="${film.filmId}">
								<input type="text" name="replacementCost" id="replacementCost" value="${film.replacementCost}">				
								<button type="button" id="btnReplacementCost">replacementCost 수정</button>
							</form>
						</td>
					</tr>
					<tr>
						<td>rating</td>
						<td>
							<form id="formRating" action="${pageContext.request.contextPath}/on/modifyFilm" method="post">
								<input type="hidden" name="filmId" value="${film.filmId}">
								<input type="radio" name="rating" class="rating" value="G"
									${film.rating == 'G' ? 'checked' : ''}>G
								<input type="radio" name="rating" class="rating" value="PG"
									${film.rating == 'PG' ? 'checked' : ''}>PG
								<input type="radio" name="rating" class="rating" value="PG-13"
									${film.rating == 'PG-13' ? 'checked' : ''}>PG-13
								<input type="radio" name="rating" class="rating" value="R"
									${film.rating == 'R' ? 'checked' : ''}>R
								<input type="radio" name="rating" class="rating" value="NC-17"
									${film.rating == 'NC-17' ? 'checked' : ''}>NC-17			
								<button type="button" id="btnRating">rating 수정</button>
							</form>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="fw-bold">선택적 항목</td>
					</tr>
					<tr>
						<td>length</td>
						<td>
							<form id="formLength" action="${pageContext.request.contextPath}/on/modifyFilm" method="post">
								<input type="hidden" name="filmId" value="${film.filmId}">
								<input type="text" name="length" id="length" value="${film.length}">				
								<button type="button" id="btnLength">length 수정</button>
							</form>
						</td>
					</tr>
					<tr>
						<td>originalLanguageId</td>
						<td>
							<form id="formOriginalLanguage" action="${pageContext.request.contextPath}/on/modifyFilm" method="post">
								<input type="hidden" name="filmId" value="${film.filmId}">
								<select id="originalLanguageId" name="originalLanguageId">
									<option value="">오리지널언어선택</option>
									<c:forEach var="la" items="${languageList}">
										<option value="${la.languageId}"
											<c:if test="${la.languageId == film.originalLanguageId}">selected</c:if>>
											${la.name}
										</option>
									</c:forEach>
								</select>							
								<button type="button" id="btnOriginalLanguage">originalLanguage 수정</button>
							</form>	
						</td>						
					</tr>
					<tr>
						<td>releaseYear</td>
						<td>
							<form id="formReleaseYear" action="${pageContext.request.contextPath}/on/modifyFilm" method="post">
								<input type="hidden" name="filmId" value="${film.filmId}">
								<input type="text" name="releaseYear" id="releaseYear" value="${film.releaseYear}">				
								<button type="button" id="btnReleaseYear">releaseYear 수정</button>
							</form>
						</td>
					</tr>
					<tr> 
						<td>specialFeatures</td>
						<td>
							<form id="formSpecialFeatures" action="${pageContext.request.contextPath}/on/modifyFilm" method="post">
								<input type="hidden" name="filmId" value="${film.filmId}">
								<!-- checkbox, set('Trailers','Commentaries','Deleted Scenes','Behind the Scenes') 
								DB기본값 : NULL
								-->
								<input type="checkbox" id="specialFeatures" name="specialFeatures" 
									value="Trailers" ${film.specialFeatures != null && film.specialFeatures.contains('Trailers') ? 'checked' : ''}>Trailers
								<input type="checkbox" id="specialFeatures" name="specialFeatures" 
									value="Commentaries" ${film.specialFeatures != null && film.specialFeatures.contains('Commentaries') ? 'checked' : ''}>Commentaries
								<input type="checkbox" id="specialFeatures" name="specialFeatures" 
									value="Deleted Scenes" ${film.specialFeatures != null && film.specialFeatures.contains('Deleted Scenes') ? 'checked' : ''}>Deleted Scenes
								<input type="checkbox" id="specialFeatures" name="specialFeatures" 
									value="Behind the Scenes" ${film.specialFeatures != null && film.specialFeatures.contains('Behind the Scenes') ? 'checked' : ''}>Behind the Scenes
								<button type="button" id="btnSpecialFeatures">specialFeatures 수정</button>
							</form>
						</td>
					</tr>
					
					<tr>
						<td>description</td>
						<td>
							<form id="formDescription" action="${pageContext.request.contextPath}/on/modifyFilm" method="post">
								<input type="hidden" name="filmId" value="${film.filmId}">
								<textarea name="description" id="description" rows="4" cols="50">${film.description}</textarea>				
								<button type="button" id="btnDescription">description 수정</button>
							</form>
						</td>
					</tr>
				</table> 
		</div>
	</div>
</body>
<script>
   // 폼 유효성 검사(제외 description, releaseYear, originalLanguageId, length, specialFeatures)
   // title
   $('#btnTitle').click(function(){
      if($('#title').val() == '') {
         alert('title을 입력하세요');
      } else {
         $('#formTitle').submit();
      }
   });
   // language
   $('#btnLanguage').click(function(){
	      if($('#languageId').val() == '') {
	         alert('language를 선택하세요');
	      } else {
	         $('#formLanguage').submit();
	      }
   });
	// rentalDuration
   $('#btnRentalDuration').click(function(){
	      if($.isNumeric($('#rentalDuration').val()) == false) {
	         alert('rentalDuration 숫자를 입력하세요');
	      } else {
	         $('#formRentalDuration').submit();
	      }
   });
   // rentalRate
   $('#btnRentalRate').click(function(){
	      if($.isNumeric($('#rentalRate').val()) == false) {
	         alert('rentalRate 숫자를 입력하세요');
	      } else {
	         $('#formRentalRate').submit();
	      }
   });
   // replacementCost
   $('#btnReplacementCost').click(function(){
	      if($.isNumeric($('#replacementCost').val()) == false) {
	         alert('replacementCost 숫자를 입력하세요');
	      } else {
	         $('#formReplacementCost').submit();
	      }
   });
   // rating
   $('#btnRating').click(function(){
	      if($('.rating:checked').length == 0) {
	         alert('rating을 선택하세요');
	      } else {
	         $('#formRating').submit();
	      }
   });
    
   // length
   $('#btnLength').click(function(){
	   let lengthValue = $('#length').val().trim();  // 공백을 제거한 값

	    // 값이 공백이거나 숫자만 있는지 확인
	    if (lengthValue !== "" && $.isNumeric(lengthValue) == false) {
	        alert('length는 숫자만 입력가능합니다');
	    } else {
	        $('#formLength').submit();
	    }
   });
   // originalLanguageId
   $('#btnOriginalLanguage').click(function(){
	   $('#formOriginalLanguage').submit();
   });
   // releaseYear
   $('#btnReleaseYear').click(function(){
	   let lengthValue = $('#releaseYear').val().trim();  // 공백을 제거한 값

	    // 값이 공백이거나 숫자만 있는지 확인
	    if (lengthValue !== "" && $.isNumeric(lengthValue) == false) {
	    	alert('releaseYear은 숫자만 입력가능합니다');
	    } else {
	        $('#formReleaseYear').submit();
	    }
	   
   });
   // specialFeatures
   $('#btnSpecialFeatures').click(function(){
	   $('#formSpecialFeatures').submit();
   });
   // description
   $('#btnDescription').click(function(){
	   $('#formDescription').submit();
   });

</script>

</html>