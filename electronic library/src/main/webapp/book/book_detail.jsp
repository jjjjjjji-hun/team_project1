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
			<!-- 서블릿에서는 search_check.jsp로는 데이터를 주었지만 search_check.jsp에서 detail로는
			데이터를 어떻게 받아올지.. -->
					<tr>
						<td>${allBookList.bNum}</td>
						<td>${allBookList.bName}</td>
						<td>${allBookList.bWriter}</td>
						<td>${allBookList.bPub}</td>
						<td>${allBookList.bCategory}</td>
						<td>${allBookList.check_out}</td>
						
					</tr>
			</tbody>
		
			</table>

</body>
</html>