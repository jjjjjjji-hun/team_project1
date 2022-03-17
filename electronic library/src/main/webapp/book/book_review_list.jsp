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
	
	<!-- 임시 버튼(대여리스트에 구현할까 생각중) -> 구현 (책 반납을 완료한 사람만 리뷰 작성할 수 있게)
	<button><a href="/electronic_library/insertReviewForm.do">리뷰 쓰기</a></button>
	 -->
	 
	 <!-- 03.17 리뷰 검색창 추가 -->

	<form action="http://localhost:8181/electronic_library/reviewSearch.do" method="post">
		<input type="text" name="ftitle" placeholder="검색할 리뷰 제목을 입력하세요" size=40 />
		<input type="submit" value="검색">
	</form> <br/><br/>
	 
	 <!-- 리뷰쓰기는 마이페이지 대여목록에서만 가능하도록, 리뷰쓰기를 누르면 대여 목록으로 이동, 로그인 사용자만 리뷰쓰기 버튼 보임 -->
	 <c:if test="${sId ne null}">
	 	<button><a href="http://localhost:8181/electronic_library/rentinfo">리뷰 쓰기</a></button>
	 </c:if>
	 
	 <!-- 메인 페이지로 이동 -->
	 <button><a href="http://localhost:8181/electronic_library/">메인 페이지로 이동</a></button>
	 
	 


	


</body>
</html>