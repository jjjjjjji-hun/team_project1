<!-- 모든 유저 확인 페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% Boolean uType = (Boolean)session.getAttribute("sUtype"); 
	if(uType != true){
		response.sendRedirect("http://localhost:8181/electronic_library/mainPage.do");
	}
%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/userList.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<div class = "userList">
		<div class = "header">
			<h1>유저 목록</h1>
			<hr/>
			<div class = "right">
				<div class = "listContainer">
					<a href="http://localhost:8181/electronic_library/uTypeCheck1.do" class = "item">
						<div class="text">관리페이지 이동</div>
					</a>
			</div>
		</div>
	</div>



	<table class="table table-hover">		
			<thead>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>이메일</th>
					<th>유저 타입</th>
					<th>대여한 도서 수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="userList" items="${allUserList}">
					<tr>
						<!-- <td>${userList.uId}</td>  -->
						<c:if test="${userList.uType eq false}">
							<td><a href="http://localhost:8181/electronic_library/bookRentListOneUser.do?uId=${userList.uId}">${userList.uId}</a></td>
						</c:if>
						<c:if test="${userList.uType eq true}">
							<td>${userList.uId}</td>
						</c:if>						
						<td>${userList.uPw}</td>
						<td>${userList.uName}</td>
						<td>${userList.uPnum}</td>
						<td>${userList.uEmail}</td>
						<td>
							<c:if test="${userList.uType == true}">
							<c:out value="관리자"/>
							</c:if>
							<c:if test="${userList.uType == false}">
							<c:out value="사용자"/>
							</c:if>
						</td>
						<td>${userList.counting}</td>
					</tr>
				</c:forEach>
			</tbody>
		
			</table><br/>
			

		<!-- 관리 페이지 이동 버튼 -->
			
		<nav aria-label="...">
		 	 <ul class="pagination justify-content-center">
		    <li class="page-item ${dto.startPage eq 1 ? 'disabled' : '' }">
		      <a class="page-link" href="http://localhost:8181/electronic_library/userList.do?pageNum=${dto.startPage-1}">Previous</a>
		    </li>
		    <c:forEach var="pageIndex" begin="${dto.startPage}" end="${dto.endPage}">
		    <li class="page-item ${dto.currentPage eq pageIndex ? 'active' : '' }" aria-current="page">
		      <a class="page-link" href="http://localhost:8181/electronic_library/userList.do?pageNum=${pageIndex}">${pageIndex}</a>
		    </li>
		    </c:forEach>
		    <li class="page-item ${dto.endPage eq dto.totalPages ? 'disabled' : '' }">
		      <a class="page-link" href="http://localhost:8181/electronic_library/userList.do?pageNum=${dto.endPage+1}">Next</a>
		    </li>
		  </ul>
		</nav>
			
</body>
</html>