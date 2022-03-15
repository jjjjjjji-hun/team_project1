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
					<td>${review.bNum}</td>
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

	


</body>
</html>