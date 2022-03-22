<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% Boolean uType = (Boolean)session.getAttribute("sUtype"); 
	if(uType != true){
		response.sendRedirect("http://localhost:8181/electronic_library/");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<th>대여 번호</th>
				<th>대출일</th>
				<th>반납일</th>
				<th>반납 예정일</th>
				<th>책 번호</th>
				<th>책 이름</th>
				<th>아이디</th>
				<th>대출 여부</th>
				<th>연체 여부</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${allRentalBookList}">
				<tr>
					<td>${list.rentNum }</td>
					<td>${list.rentDate}</td>
					<td>${list.returnDate}</td>
					<td>${list.returnSchedule}</td>
					<td>${list.bNum}</td>
					<td>${list.bName}</td>
					<td>${list.uId}</td>
					<td>
						<c:choose>
							<c:when test="${list.checkOut eq true}">
									대여 중
							</c:when>
							<c:otherwise>
									반납 완료
							</c:otherwise> 
						</c:choose>
					</td>
					<td><c:choose>
							<c:when test="${list.overdue eq true}">
									연체
							</c:when>
							<c:otherwise>
									미연체
							</c:otherwise> 
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table><br/>
	
<<<<<<< HEAD
		<!-- 관리 페이지 이동 버튼-->
		<a href="http://localhost:8181/electronic_library/uTypeCheck1.do"><button>관리 페이지로 이동</button></a>
=======
		<!-- 관리 페이지 이동 버튼 (추후 프론트 컨트롤러로 변경할 것) -->
		<button><a href="http://localhost:8181/electronic_library/users/admin_page.jsp">관리 페이지로 이동</a></button>
>>>>>>> 8a649c60fb48f263cea505ae9c9e43c82800b75d

</body>
</html>