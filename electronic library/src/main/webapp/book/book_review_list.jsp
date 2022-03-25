<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/bookReviewList.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class = "bookReviewList">
		<div class = "header">
	
			<h1> 리뷰 페이지</h1>
			<hr/>
	
 <!-- 리뷰쓰기는 마이페이지 대여목록에서만 가능하도록, 리뷰쓰기를 누르면 대여 목록으로 이동, 로그인 사용자만 리뷰쓰기 버튼 보임 -->
			<div class = "right">
				<div class = "listContainer">
					<c:if test="${sessionScope.sUtype eq false}">
						<a href="http://localhost:8181/electronic_library/rentInfo.do" class = "item">
							<div class="text">리뷰 쓰기</div>
						</a>
					</c:if>
					<a href="http://localhost:8181/electronic_library/mainPage.do" class = "item">
						<div class="text">메인 화면으로</div>
					</a>
					<a href="javascript:history.back();" class = "item">
						<div class="text">뒤로가기 </div>
					</a>
				</div>
			</div>
		</div>
	
	
		<form action="http://localhost:8181/electronic_library/reviewSearch.do" method="post">
			<fieldset>
				<label>검색 항목</label>
				<select name= "option">
					<option value="bname">도서명</option>
					<option value="revtitle">리뷰 제목</option>
				</select>
				<label>검색어
					<input type="text" name="keyword" placeholder="리뷰 검색하기" size=40 />
					<input type="submit" value="검색">
				</label>
			</fieldset>
		</form> 
		
		<hr/>
	
		<table  class = "table table-hover">
			<thead> <!-- 책번호 나중에 책 이름으로 바꿔야-->
				<th>리뷰 번호</th>
				<th>책 이름</th>
				<th>제목</th>
				<th>아이디</th>
				<th>작성일</th>
				<th>수정일</th>
			</thead>
			<tbody>
				<c:forEach var="review" items="${allReviewList}">			
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
		
		<nav aria-label="...">
		 	 <ul class="pagination justify-content-center">
		    <li class="page-item ${dto.startPage eq 1 ? 'disabled' : '' }">
		      <a class="page-link" href="http://localhost:8181/electronic_library/reviewList.do?pageNum=${dto.startPage-1}">Previous</a>
		    </li>
		    <c:forEach var="pageIndex" begin="${dto.startPage}" end="${dto.endPage}">
		    <li class="page-item ${dto.currentPage eq pageIndex ? 'active' : '' }" aria-current="page">
		      <a class="page-link" href="http://localhost:8181/electronic_library/reviewList.do?pageNum=${pageIndex}">${pageIndex}</a>
		    </li>
		    </c:forEach>
		    <li class="page-item ${dto.endPage eq dto.totalPages ? 'disabled' : '' }">
		      <a class="page-link" href="http://localhost:8181/electronic_library/reviewList.do?pageNum=${dto.endPage+1}">Next</a>
		    </li>
		  </ul>
		</nav>
	
	</div>	

</body>
</html>