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
	

		<!-- 관리 페이지 이동 버튼-->
		<a href="http://localhost:8181/electronic_library/uTypeCheck1.do"><button>관리 페이지로 이동</button></a>

		<nav aria-label="...">
		 	 <ul class="pagination justify-content-center">
		    <li class="page-item ${dto.startPage eq 1 ? 'disabled' : '' }">
		      <a class="page-link" href="http://localhost:8181/electronic_library/bookRentList.do?pageNum=${dto.startPage-1}">Previous</a>
		    </li>
		    <c:forEach var="pageIndex" begin="${dto.startPage}" end="${dto.endPage}">
		    <li class="page-item ${dto.currentPage eq pageIndex ? 'active' : '' }" aria-current="page">
		      <a class="page-link" href="http://localhost:8181/electronic_library/bookRentList.do?pageNum=${pageIndex}">${pageIndex}</a>
		    </li>
		    </c:forEach>
		    <li class="page-item ${dto.endPage eq dto.totalPages ? 'disabled' : '' }">
		      <a class="page-link" href="http://localhost:8181/electronic_library/bookRentList.do?pageNum=${dto.endPage+1}">Next</a>
		    </li>
		  </ul>
		</nav>

</body>
</html>