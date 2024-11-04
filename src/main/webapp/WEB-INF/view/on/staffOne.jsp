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
			<!-- STAFF 정보 -->
         <h1 class="bg-light mt-3">STAFF 정보</h1>
         <table class="mt-5 table">
            <tr>
               <th>STAFF ID</th>
               <td>${staff.staffId}</td>
            </tr>
            <tr>
               <th>First Name</th>
               <td>${staff.firstName}</td>
            </tr>
            <tr>
               <th>Last Name</th>
               <td>${staff.lastName}</td>
            </tr>
            <tr>
               <th>email</th>
               <td>${staff.staffEmail}</td>
            </tr>
            
         </table>
         <!-- STAFF 주소지 정보 -->
            <h1 class="bg-light mt-3">STAFF 주소지</h1>
            <table class="mt-5 table">
            <tr>
               <th>Address</th>
               <td>${staff.staffAddress}</td>
            </tr>
            <tr>
               <th>Address2</th>
               <td>${staff.staffAddress2}</td>
            </tr>
            <tr>
               <th>District</th>
               <td>${staff.staffDistrict}</td>
            </tr>
            <tr>
               <th>Postal Code</th>
               <td>${staff.staffPostalCode}</td>
            </tr>
            <tr>
               <th>Phone</th>
               <td>${staff.StaffPhone}</td>
            </tr>
            <tr>
               <th>City</th>
               <td>${staff.staffCity}</td>
            </tr>
            <tr>
               <th>Country</th>
               <td>${staff.staffCountry}</td>
            </tr>      
         </table>
         <!-- STORE 정보 -->
            <h1 class="bg-light mt-3">STORE 정보</h1>
            <table class="mt-5 table">
            <tr>
               <th>STORE ID</th>
               <td>${staff.storeId}</td>
            </tr>
            <tr>
               <th>Manager Name STAFF ID</th>
               <td>${staff.managerfStaffId}</td>
            </tr>
            <tr>
               <th>Manager Name</th>
               <td>${staff.managerName}</td>
            </tr>   
         </table>
         <!-- STORE 주소지 -->
            <h1 class="bg-light mt-3">STORE 주소지</h1>
            <table class="mt-5 table">
            <tr>
               <th>STORE ID</th>
               <td>${staff.storeAddress}</td>
            </tr>
            <tr>
               <th>Manager Name STAFF ID</th>
               <td>${staff.storeAddress2}</td>
            </tr>
            <tr>
               <th>District</th>
               <td>${staff.storeDistrict}</td>
            </tr>   
            <tr>
               <th>Post Code</th>
               <td>${staff.storePostCode}</td>
            </tr>   
            <tr>
               <th>Phone</th>
               <td>${staff.storePhone}</td>
            </tr>   
            <tr>
               <th>City</th>
               <td>${staff.storeCity}</td>
            </tr>   
            <tr>
               <th>Country</th>
               <td>${staff.storeCountry}</td>
            </tr>   

			</table>
		</div>
				
	</div>
	<div>
		<a href="">비밀번호 수정</a>
		<a href="">이메일 수정</a>
		<a href="">주소 수정</a>
		<a href="">STORE 수정</a>
	</div>
</body>
</html>