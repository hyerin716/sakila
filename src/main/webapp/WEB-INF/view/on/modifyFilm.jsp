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
						<td>description</td>
						<td>
							<form id="formDescription" action="${pageContext.request.contextPath}/on/modifyFilm" method="post">
								<input type="hidden" name="filmId" value="${film.filmId}">
								<textarea name="description" id="description" rows="4" cols="50">${film.description}</textarea>				
								<button type="button" id="btnDescription">description 수정</button>
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
					<!-- 선택적,필수적 나눠서 하기 -->
					<tr>
						<td>specialFeatures</td>
						<td>${film.specialFeatures}</td>
					</tr>
					<tr>
						<td>originalLanguageId</td>
						<td>${film.originalLanguageId}</td>
					</tr>
					<tr>
						<td>language</td>
						<td>${film.language}</td>
					</tr>
				</table> 
			
			
			
		</div>
	</div>
	
</body>
</html>