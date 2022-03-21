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
	<h1>'${userInfo.uId }' 님의 도서 대여 정보 입니다.</h1>
	<hr/>
	<c:if test="${userInfo.counting > 0}">
	<h2>'${userInfo.uId }' 님의 대여 중인 도서 수는 '${userInfo.counting }' 권 입니다.</h2>
	</c:if>
	<c:if test="${userInfo.counting <= 0}">
	<h2>빌린 도서가 없습니다.</h2>
	</c:if>
   	 	<table border="1">
		<thead>
			<tr>
				<th>대여 번호</th>
				<th>대출일</th>
				<th>반납일</th>
				<th>반납 예정일</th>
				<th>책 번호</th>
				<th>책 이름</th>
				<th>대출 여부</th>
				<th>반납하기</th>
				<th>리뷰 작성</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${rentInfoList}">

				<tr>
					<td>${list.rentNum }</td>
					<td>${list.rentDate}</td>
					<td>${list.returnDate}</td>
					<td>${list.returnSchedule}</td>
					<td>${list.bNum}</td>
					<td>${list.bName}</td>
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
					<td>
						<c:choose>
							<c:when test="${list.checkOut eq true}">
								<form action="http://localhost:8181/electronic_library/returnBook.do?rentNum=${list.rentNum }" method="post">
									<input type="hidden" value="${list.rentNum }" name="rentnum"/>
									<input type="hidden" value="${list.bNum }" name="bnum"/>
									<input type="hidden" value="${list.returnDate}" name="returndate"/>
									<input type="hidden" value="${list.returnSchedule }" name="returnschedule"/>
									<input type="hidden" value="${list.overdue }" name="overdue"/>
							    	<input type="submit" value="반납">
								</form>
							</c:when>
							<c:otherwise>
							
							</c:otherwise>
						</c:choose>
					</td>
					<td><!-- 03.15 추가 리뷰작성 -->
						<c:choose>
							<c:when test="${list.checkOut eq false}">
								<form action="/electronic_library/insertReviewForm.do" method="post">
									<input type="hidden" value="${list.bNum}" name="fbnum"/>
									<input type="hidden" value="${list.bName}" name="fbname"/> 
									<!-- <input type="hidden" value="${list.uId}" name="fid"/> 03.16 세션 아이디로 변경 -->
									
							    	<input type="submit" value="리뷰 쓰기">
								</form>
							</c:when>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table><br/>
			<a href="http://localhost:8181/electronic_library/uTypeCheck0.do"><button>마이페이지</button></a>
			<a href="http://localhost:8181/electronic_library/book/book_search.jsp"><button>도서 검색</button></a>
			<a href="http://localhost:8181/electronic_library/mainPage.do"><button>메인 페이지로 이동</button></a>
</body>
</html>