<!-- 모든 도서 확인 페이지 -->

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
				<th>도서 번호</th>
				<th>도서명</th>
				<th>저자</th>
				<th>출판사</th>
				<th>카테고리</th>
				<th>대여 상태</th>
				
			</thead>
			<tbody> <!-- end값 조정해야 함. length 쓸 수 있게 -->
				<c:forEach var="bookList" items="${allBookList}">
					<tr>
						<td>${bookList.bNum}</td>
						<td>${bookList.bName}</td>
						<td>${bookList.bWriter}</td>
						<td>${bookList.bPub}</td>
						<td>${bookList.bCategory}</td>
						<td>${bookList.checkOut}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		
			</table>

</body>
</html>