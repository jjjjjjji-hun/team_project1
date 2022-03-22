<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${sessionScope.sUtype eq false}">
	<c:redirect url="http://localhost:8181/electronic_library/userPage.do"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/adminPage.css">

<title>Insert title here</title>
</head>
<body>
	
	<div class = "adminForm">
		<h1>관리자 페이지</h1>
		<hr/>
		
		
		<div class = "listContainer">
		
		
			
			<a href="http://localhost:8181/electronic_library/userList.do" class = "item">
				<div class="text">회원 관리</span> </div>
			</a>

			<a href="http://localhost:8181/electronic_library/bookList.do" class = "item">
				<div class="text">도서 관리</span> </div>
			</a>
			
			<a href="http://localhost:8181/electronic_library/bookRentList.do" class = "item">
				<div class="text">대출 도서 관리</span> </div>
			</a>
			
			<a href="http://localhost:8181/electronic_library/mainPage.do" class = "item">
				<div class="text">메인 페이지 이동</span> </div>
			</a>
			
			
		</div>
	</div>

</body>
</html>