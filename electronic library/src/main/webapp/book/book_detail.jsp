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
	<!-- 검색된 도서 최종 확인 페이지 -->
   	 		<table border="1">
		
			<thead>
				<th>도서 번호</th>
				<th>도서명</th>
				<th>저자</th>
				<th>출판사</th>
				<th>카테고리</th>
				<th>대여 상태</th>
				
			</thead>
			<tbody>
					<tr>
						<td>${allBookList[i].bnum}</td>
						<td>${allBookList[i].bname}</td>
						<td>${allBookList[i].bwriter}</td>
						<td>${allBookList[i].bpub}</td>
						<td>${allBookList[i].bcategory}</td>
						<td>${allBookList[i].check_out}</td>
						
					</tr>
			</tbody>
		
			</table>

</body>
</html>