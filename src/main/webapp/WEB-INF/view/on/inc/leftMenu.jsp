<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<ul class="list-group text-center bg-light">
	<li class="list-group-item bg-light">
		<a href="${pageContext.request.contextPath}/on/main" class="btn bs-warning">&#127968; 홈으로</a>
	</li>
	<li class="list-group-item bg-light">
		<a href="${pageContext.request.contextPath}/on/staffOne" class="btn bs-warning">
			${loginStaff.username}님 마이페이지
		</a>
	</li>
</ul>
<!-- 메뉴 항목들 -->
<div class="accordion" id="accordionPanelsStayOpenExample">
  	  <!-- ::: 지점 관리 ::: -->
      <div class="accordion-item">
        <h2 class="accordion-header">
          <button
            class="accordion-button fw-bold"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#panelsStayOpen-collapseOne"
            aria-expanded="false"
            aria-controls="panelsStayOpen-collapseOne"
          >
           ::: 지점 관리 :::
          </button>
        </h2>
        <div
          id="panelsStayOpen-collapseOne"
          class="accordion-collapse collapse"
          style=""
        >
          <div class="accordion-body">
            <a href="${pageContext.request.contextPath}/on/storeList">지점 리스트</a>
            <!-- 
            	StoreMapper.selectStoreList() : List<Map> - store x staff x address
            	StoreService.getStoreList() : List<Map> 
            	GET - /on/stroeList - StoreController.storeList() - storeList.jsp 
             -->
          </div>
          <div class="accordion-body">
            <a href="${pageContext.request.contextPath}/on/addStore">지점 추가</a>
            <!-- 
            	GET - /on/addStore 
            		- StoreController.addStore() : staffList 모델에 추가, search주소검색결과 모델추가 -addStore.jsp
            		
            	StoreMapper.insertStore() : Integer
            	StoreService.addStore() : Integer
            	POST - /on/addStore - StoreController.addStore(Store) 
            		 
             -->
          </div>
        </div>
      </div>
      <!-- ::: STAFF 관리 ::: -->
   	  <div class="accordion-item">
        <h2 class="accordion-header">
          <button
            class="accordion-button fw-bold"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#panelsStayOpen-collapseTwo"
            aria-expanded="false"
            aria-controls="panelsStayOpen-collapseTwo"
          >
          ::: STAFF 관리 :::
          </button>
        </h2>
        <div
          id="panelsStayOpen-collapseTwo"
          class="accordion-collapse collapse"
        >
          <div class="accordion-body">
            <a href="${pageContext.request.contextPath}/on/staffList">STAFF 리스트</a>
          </div>
          <div class="accordion-body">
            <a href="${pageContext.request.contextPath}/on/addStaff">STAFF 추가</a>
          </div>
        </div>
      </div>
      <!-- ::: 영화 관리 ::: -->
   	  <div class="accordion-item">
        <h2 class="accordion-header">
          <button
            class="accordion-button fw-bold"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#panelsStayOpen-collapseThree"
            aria-expanded="false"
            aria-controls="panelsStayOpen-collapseThree"
          >
          ::: 영화 관리 :::
          </button>
        </h2>
        <div
          id="panelsStayOpen-collapseThree"
          class="accordion-collapse collapse"
        >
          <div class="accordion-body">
            <a href="${pageContext.request.contextPath}/on/categoryList">카테고리 리스트</a>
          </div>
          <div class="accordion-body">
            <a href="${pageContext.request.contextPath}/on/addCategory">카테고리 추가</a>
          </div>
          <div class="accordion-body">
            <a href="${pageContext.request.contextPath}/on/languageList">언어 리스트</a>
          </div>
          <div class="accordion-body">
            <a href="${pageContext.request.contextPath}/on/addLanguage">언어 추가</a>
          </div>
          <div class="accordion-body">
            <a href="${pageContext.request.contextPath}/on/filmList">필름 리스트</a>
          </div>
          <div class="accordion-body">
            <a href="${pageContext.request.contextPath}/on/addFilm">필름 추가</a>
          </div>
        </div>
      </div>
      
      <!-- ::: 고객 관리 ::: -->
   	  <div class="accordion-item">
        <h2 class="accordion-header">
          <button
            class="accordion-button fw-bold"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#panelsStayOpen-collapseFour"
            aria-expanded="false"
            aria-controls="panelsStayOpen-collapseFour"
            
          >
          ::: 고객 관리 :::
          </button>
        </h2>
        <div
          id="panelsStayOpen-collapseFour"
          class="accordion-collapse collapse"
        >
          <div class="accordion-body">
            <a href="">고객 리스트</a>
          </div>
          <div class="accordion-body">
            <a href="">고객 추가</a>
          </div>
        </div>
      </div>
      <!-- ::: 배우 관리 ::: -->
   	  <div class="accordion-item">
        <h2 class="accordion-header">
          <button
            class="accordion-button fw-bold"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#panelsStayOpen-collapseFive"
            aria-expanded="false"
            aria-controls="panelsStayOpen-collapseFive"
          >
          ::: 배우 관리 :::
          </button>
        </h2>
        <div
          id="panelsStayOpen-collapseFive"
          class="accordion-collapse collapse"
          style=""
        >
          <div class="accordion-body">
            <a href="${pageContext.request.contextPath}/on/actorList">배우 리스트</a>
          </div>
          <div class="accordion-body">
            <a href="${pageContext.request.contextPath}/on/addActor">배우 추가</a>
          </div>
        </div>
      </div>
</div>
<!-- 통계랑 로그아웃 -->
<ul class="list-group text-center bg-light">
	<li class="list-group-item bg-light fw-bold">
		::: 통계 :::
	</li>
	
	<li class="list-group-item bg-light btn-danger">
		<a href="${pageContext.request.contextPath}/on/logout" class="btn btn-danger">로그아웃</a>
	</li>
</ul>
