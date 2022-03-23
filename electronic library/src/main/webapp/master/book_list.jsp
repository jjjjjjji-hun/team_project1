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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   	 		<table border="1">
		
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
			

			<!-- 관리 페이지 이동 버튼-->
			<a href="http://localhost:8181/electronic_library/uTypeCheck1.do"><button>관리 페이지로 이동</button></a>

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

</body>
</html>