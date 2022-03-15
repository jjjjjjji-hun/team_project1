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
		<theader>
			<th>대여 번호</th>
			<th>대출일</th>
			<th>반납일</th>
			<th>반납 예정일</th>
			<th>책 번호</th>
			<th>아이디</th>
			<th>대출 여부</th>
			<th>연체 여부</th>
		</theader>
		<tbody>
			<c:forEach var="list" items="${allRentalBookList}">
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
					<td>${list.overdue}</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>

</body>
</html>