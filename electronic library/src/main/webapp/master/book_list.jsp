<!-- 모든 도서 확인 페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% Boolean uType = (Boolean)session.getAttribute("sUtype"); 
	if(uType != true){
		response.sendRedirect("http://localhost:8181/electronic_library/");
	}
%>

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
						<td>
							<c:if test="${bookList.checkOut == true}">
								<c:out value="대여중"/>
							</c:if>
							<c:if test="${bookList.checkOut == false}">
								<c:out value="대여 가능"/>
							</c:if>  
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
		
			</table><br/>
			
			<!-- 관리 페이지 이동 버튼 (추후 프론트 컨트롤러로 변경할 것) -->
			<button><a href="http://localhost:8181/electronic_library/users/admin_page.jsp">관리 페이지로 이동</a></button>

</body>
</html>