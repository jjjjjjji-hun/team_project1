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
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>이메일</th>
					<th>유저 타입</th>
					<th>대여한 도서 수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="userList" items="${allUserList}">
					<tr>
						<!-- <td>${userList.uId}</td>  -->
						<c:if test="${userList.uType eq false}">
							<td><a href="http://localhost:8181/electronic_library/UseRentInfoCheckServlet?uId=${userList.uId}">${userList.uId}</a></td>
						</c:if>
						<c:if test="${userList.uType eq true}">
							<td>${userList.uId}</td>
						</c:if>						
						<td>${userList.uPw}</td>
						<td>${userList.uName}</td>
						<td>${userList.uPnum}</td>
						<td>${userList.uEmail}</td>
						<td>
							<c:if test="${userList.uType == true}">
							<c:out value="관리자"/>
							</c:if>
							<c:if test="${userList.uType == false}">
							<c:out value="사용자"/>
							</c:if>
						</td>
						<td>${userList.counting}</td>
					</tr>
				</c:forEach>
			</tbody>
		
			</table><br/>
			
		<!-- 관리 페이지 이동 버튼 -->
		<a href="http://localhost:8181/electronic_library/uTypeCheck1.do"><button>관리 페이지로 이동</button></a>	
			
</body>
</html>