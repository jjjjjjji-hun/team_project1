<!-- 모든 유저 확인 페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<th>도서 대여 수</th>
			</thead>
			<tbody>
				<c:forEach begin="0" end="2" var="i">
					<tr>
						<td>${allUserList[i].uId}</td>
						<td>${allUserList[i].uPw}</td>
						<td>${allUserList[i].uName}</td>
						<td>${allUserList[i].uPnum}</td>
						<td>${allUserList[i].uEmail}</td>
						<td>${allUserList[i].uType}</td>
						<td>${allUserList[i].counting}</td>
					</tr>
				</c:forEach>
			</tbody>
		
			</table>
</body>
</html>