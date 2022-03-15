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
	
   	 		<table border="1">
		<theader>
			<th>대여 번호</th>
			<th>대출일</th>
			<th>반납일</th>
			<th>반납 예정일</th>
			<th>책 번호</th>
			<th>아이디</th>
			<th>대출 여부</th>
			<th>반납하기</th>
			<!-- <th>연체 여부</th> 굳이 필요 없을것 같아서 주석처리했습니다. -->
		</theader>
		<tbody>
			<c:forEach var="list" items="${rentInfoList}">
				<tr>
					<td>${list.rentNum }</td>
					<td>${list.rentDate}</td>
					<td>${list.returnDate}</td>
					<td>${list.returnSchedule}</td>
					<td>${list.bNum}</td>
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
					<!-- <td>${list.overdue}</td> -->
					<td>
						<c:choose>
							<c:when test="${list.checkOut eq true}">
								<form action="http://localhost:8181/electronic_library/returnbook?rentNum=${list.rentNum }" method="post">
									<input type="hidden" value="${list.rentNum }" name="rentnum"/>
									<input type="hidden" value="${list.bNum }" name="bnum"/>
							    	<input type="submit" value="반납">
								</form>
							</c:when>
							<c:otherwise>
							
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
			<a href="http://localhost:8181/electronic_library/usermyinfo">마이페이지</a>
			<a href="http://localhost:8181/electronic_library/book/book_search.jsp">검색창으로</a>
</body>
</html>