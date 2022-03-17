<!-- 모든 유저 확인 페이지 -->

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
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>유저 타입</th>
				<th>대여한 도서 수</th>
			</thead>
			<tbody> <!-- end값 조정해야 함. length 쓸 수 있게 -->
				<c:forEach var="userList" items="${allUserList}">
					<tr>
						<!-- <td>${userList.uId}</td>  -->
						<td><a href="http://localhost:8181/electronic_library/UseRentInfoCheckServlet?uId=${userList.uId}">${userList.uId}</a></td>
						<td>${userList.uPw}</td>
						<td>${userList.uName}</td>
						<td>${userList.uPnum}</td>
						<td>${userList.uEmail}</td>
						<td>${userList.uType}</td>
						<td>${userList.counting}</td>
					</tr>
				</c:forEach>
			</tbody>
		
			</table><br/>
			
		<!-- 관리 페이지 이동 버튼 (추후 프론트 컨트롤러로 변경할 것) -->
		<button><a href="http://localhost:8181/electronic_library/users/admin_page.jsp">관리 페이지로 이동</a></button>			
			
</body>
</html>