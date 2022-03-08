<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 검색한 도서 정보 -->
	<h1>검색된 도서명</h1>
	<table border="1">
		
			<thead>
				<th>도서 번호</th>
				<th>도서명</th>
				<th>카테고리</th>

				
			</thead>
			<tbody>
			<!-- 사용자가 검색한 단어를 포함하는 책 리스트 보여주기 코드 찾는중 -->
				<c:set var="book" value="${param.fBname }"/>
				<c:if test="${fn:contains(book, '${param.fBname}')}">
					<tr>
						<td>자바</td>
						<td><a href="./book/book_detail.jsp">나는 자바</a></td>
						<td>스크립트</td>
						
					</tr>
				</c:if>
			</tbody>
		
			</table>
</body>
</html>