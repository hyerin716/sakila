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
		
		<!-- ●
			● 1) film 상세
			1-1) film 수정 - /on/modifyFilm
			● 1-2) film 삭제 - /on/removeFilm (inventory-rental 정보 확인 + film_category 삭제 + film_actor삭제 + film 삭제)
			
			2) film_category 리스트
			2-1) film_category 추가	/on/addFilmCategory -> 카테고리 전체 목록에서 선택
			2-2) film_category 수정	/on/removeFilmCategory
			
			필름쪽에서 액터 추가
			● 3) film_actor 리스트
			3-1) film_actor 추가	/on/addActorByFilm -> 액터 검색 후 선택
			3-2) film_actor 삭제	/on/removeFilmActor ->
			
			4) inventory 정보
		 -->
		
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
				<a href="${pageContext.request.contextPath}/on/modifyFilm?filmId=${film.filmId}">영화 수정</a>
				<a href="${pageContext.request.contextPath}/on/removeFilm?filmId=${film.filmId}">영화 삭제</a>
				<span class="text-danger">${removeFilmMsg}</span>
			</div>
			<br>
			<div>
				<h2>작품 장르(CATEGORY)</h2>
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