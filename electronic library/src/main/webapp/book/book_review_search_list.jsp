<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/bookReviewSearchList.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class = "bookReviewSearchList">
		<div class = "header">	
	
			<h1> 리뷰 검색 결과</h1>
			<hr/>
			<div class = "right">
				<div class = "listContainer">
					<c:if test="${sId ne null}">
						<a href="http://localhost:8181/electronic_library/reviewList.do" class = "item">
							<div class="text">뒤로가기</div>
						</a>
					</c:if>
					<a href="http://localhost:8181/electronic_library/book/book_search.jsp" class = "item">
						<div class="text">책 검색하기</div>
					</a>
				</div>
			</div>
		</div>


		<!-- 없는 검색어를 입력한 경우 (리뷰 검색 실패 페이지로 이동)-->
		<c:if test="${empty reviewList}">
			<c:redirect url="http://localhost:8181/electronic_library/book/book_review_search_fail.jsp"/>
		</c:if>	
	
	
		
		<table class = "table table-hover">
			<thead>
				<th>리뷰 번호</th>
				<th>책 이름</th>
				<th>제목</th>
				<th>아이디</th>
				<th>작성일</th>
				<th>수정일</th>
			</thead>
			<tbody>
				<c:forEach var="review" items="${reviewList}">		
					<tr>
						<td>${review.revNum}</td>
						<td>${review.bName}</td>
						<td><a href="http://localhost:8181/electronic_library/reviewDetail.do?revnum=${review.revNum}">${review.revTitle}</a></td>
						<td>${review.uId}</td>
						<td>${review.revDate}</td>
						<td>${review.revMDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table><br/>
	
	</div>
</body>
</html>