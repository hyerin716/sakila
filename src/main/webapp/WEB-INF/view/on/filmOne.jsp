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
			<h1>FILM ONE (영화 정보)</h1>
			<div>
				<table class="table" style="width: 80%;">
					<tr>
						<td>filmId</td>
						<td>${film.filmId}</td>
					</tr>
					<tr>
						<td>title</td>
						<td>${film.title}</td>
					</tr>
					<tr>
						<td>description</td>
						<td>${film.description}</td>
					</tr>
					<tr>
						<td>releaseYear</td>
						<td>${film.releaseYear}</td>
					</tr>
					<tr>
						<td>rentalDuration</td>
						<td>${film.rentalDuration}</td>
					</tr>
					<tr>
						<td>rentalRate</td>
						<td>${film.rentalRate}</td>
					</tr>
					<tr>
						<td>length</td>
						<td>${film.length}</td>
					</tr>
					<tr>
						<td>replacementCost</td>
						<td>${film.replacementCost}</td>
					</tr>
					<tr>
						<td>rating</td>
						<td>${film.rating}</td>
					</tr>
					<tr>
						<td>specialFeatures</td>
						<td>${film.specialFeatures}</td>
					</tr>
					<tr>
						<td>lastUpdate</td>
						<td>${film.lastUpdate}</td>
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
			<div>
				<a href="">영화 수정</a>
			</div>
			
			<br>
			<div>
				<h2>작품에 출연한 배우들</h2>
				<div>
					<c:forEach var="a" items="${actorList}">
						<div>
							<a href="${pageContext.request.contextPath}/on/actorOne?actorId=${a.actorId}">
								${a.firstName} ${a.lastName}
							</a>
						</div>
					</c:forEach>
					
				</div>
			</div>
		</div>
	</div>
</body>
</html>