<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/bookRequestList.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


		<div class = "bookList">
			<div class = "header">
				<h1>도서 요청 리스트</h1>
				<hr/>
				<div class = "right">
					<div class = "listContainer">
						<c:if test="${sessionScope.sUtype eq false}">
							<a href="http://localhost:8181/electronic_library/insertRequestForm.do" class = "item">
								<div class="text">희망도서 요청</div>
							</a>
						</c:if>
						<a href="http://localhost:8181/electronic_library/mainPage.do" class = "item">
								<div class="text">메인 화면으로</div>
						</a>
				</div>
			</div>
		</div>


   	 		
	<table class="table table-hover">

	
		<thead>
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>요청 도서명</th>
				<th>작성자</th>
				<th>신청 상태</th>
				<th>작성일</th>
				<th>수정일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="request" items="${allRequestList}">
				<tr>
					<td>${request.reqNum}</td>
					<td><a href="http://localhost:8181/electronic_library/requestDetail.do?reqnum=${request.reqNum}">${request.reqTitle}</a></td>
					<td>${request.bName}</td>
					<td>${request.reqId}</td>
					<td> <!-- 신청상태가 0 : 대기중 / 신청상태 1 : 구매완료 -->
						<c:if test="${request.reqStatus == false}">
							<c:out value="대기중"></c:out>
						</c:if>
						<c:if test="${request.reqStatus == true}">
							<c:out value="구매 완료"></c:out>
						</c:if>					
					</td>
					<td>${request.reqDate}</td>
					<td>${request.reqmDate}</td>
					<td>${request.hit}</td>

				</tr>
			</c:forEach>
		</tbody>
	
	</table><br/>
	

		<nav aria-label="...">
		 	 <ul class="pagination justify-content-center">
		    <li class="page-item ${dto.startPage eq 1 ? 'disabled' : '' }">
		      <a class="page-link" href="http://localhost:8181/electronic_library/requestList.do?pageNum=${dto.startPage-1}">Previous</a>
		    </li>
		    <c:forEach var="pageIndex" begin="${dto.startPage}" end="${dto.endPage}">
		    <li class="page-item ${dto.currentPage eq pageIndex ? 'active' : '' }" aria-current="page">
		      <a class="page-link" href="http://localhost:8181/electronic_library/requestList.do?pageNum=${pageIndex}">${pageIndex}</a>
		    </li>
		    </c:forEach>
		    <li class="page-item ${dto.endPage eq dto.totalPages ? 'disabled' : '' }">
		      <a class="page-link" href="http://localhost:8181/electronic_library/requestList.do?pageNum=${dto.endPage+1}">Next</a>
		    </li>
		  </ul>
		</nav>

</body>
</html>