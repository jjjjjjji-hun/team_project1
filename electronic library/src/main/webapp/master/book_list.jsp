<!-- 모든 도서 확인 페이지 -->

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
<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/bookList.css">

<meta charset="UTF-8">
<title>도서 관리 페이지</title>
</head>
<body>
		<div class = "bookList">
			<div class = "header">
				<h1>도서목록</h1>
				<hr/>
				<div class = "right">
					<div class = "listContainer">
						<a href="http://localhost:8181/electronic_library/uTypeCheck1.do" class = "item">
							<div class="text">관리 페이지로 이동</div>
						</a>
				</div>
			</div>
		</div>
		
		
   	 		

   	 		
   	 		<table class="table table-hover">

			<thead>
				<tr>
					<th>도서 번호</th>
					<th>도서명</th>
					<th>저자</th>
					<th>출판사</th>
					<th>카테고리</th>
					<th>대여 상태</th>
				</tr>
			</thead>
			<tbody> <!-- end값 조정해야 함. length 쓸 수 있게 -->
				<c:forEach var="bookList" items="${allBookList}">
					<tr>
						<td>${bookList.bNum}</td>
						<td><a href="http://localhost:8181/electronic_library/bookDetail.do?bName=${bookList.bName}">${bookList.bName}</a></td>
						<td>${bookList.bWriter}</td>
						<td>${bookList.bPub}</td>
						<td>${bookList.bCategory}</td>
						<td>
							<c:if test="${bookList.checkOut == true}">
								<c:out value="대여중"/>
							</c:if>
							<c:if test="${bookList.checkOut == false}">
								<c:out value="대여 가능"/>
							</c:if>  
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
		
			</table><br/>
			


		<nav aria-label="...">
		 	 <ul class="pagination justify-content-center">
		    <li class="page-item ${dto.startPage eq 1 ? 'disabled' : '' }">
		      <a class="page-link" href="http://localhost:8181/electronic_library/bookList.do?pageNum=${dto.startPage-1}">Previous</a>
		    </li>
		    <c:forEach var="pageIndex" begin="${dto.startPage}" end="${dto.endPage}">
		    <li class="page-item ${dto.currentPage eq pageIndex ? 'active' : '' }" aria-current="page">
		      <a class="page-link" href="http://localhost:8181/electronic_library/bookList.do?pageNum=${pageIndex}">${pageIndex}</a>
		    </li>
		    </c:forEach>
		    <li class="page-item ${dto.endPage eq dto.totalPages ? 'disabled' : '' }">
		      <a class="page-link" href="http://localhost:8181/electronic_library/bookList.do?pageNum=${dto.endPage+1}">Next</a>
		    </li>
		  </ul>
		</nav>
	</div>

</body>
</html>