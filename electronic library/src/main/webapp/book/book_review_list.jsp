<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<th>리뷰 번호</th>
				<th>책 이름</th>
				<th>제목</th>
				<th>아이디</th>
				<th>작성일</th>
				<th>수정일</th>
			</tr>
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

	
	<!-- 리뷰창 고도화 -->
	
	<form action="http://localhost:8181/electronic_library/reviewSearch.do" method="post">
		<fieldset>
			<legend>리뷰 검색</legend>
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
	</form> <br/><br/>
	
	
	 
	 <!-- 리뷰쓰기는 마이페이지 대여목록에서만 가능하도록, 리뷰쓰기를 누르면 대여 목록으로 이동, 로그인 사용자만 리뷰쓰기 버튼 보임 -->
	 <c:if test="${sId ne null}">
	 	<a href="http://localhost:8181/electronic_library/rentInfo.do"><button>리뷰 쓰기</button></a>
	 </c:if>
	 
	 <!-- 메인 페이지로 이동 -->
	 <a href="http://localhost:8181/electronic_library/mainPage.do"><button>메인 페이지로 이동</button></a>
	 
	 


	


</body>
</html>