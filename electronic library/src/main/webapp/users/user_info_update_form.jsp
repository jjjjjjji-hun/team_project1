<!-- 여기 수정중 -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>유저 페이지</h1>
	
	<h3> ${user.uId}님의 회원 정보 수정 페이지</h3> <br/>
	
	<form action="http://localhost:8181/electronic_library/userInfoUpdateToDB.do" method="post">
		아이디 : <input type="text" name="fuid" value="${user.uId}" readonly><br/>
		비밀번호 : <input type="text" name="fupw" value="${user.uPw}"><br/>
		이름 : <input type="text" name="funame" value="${user.uName}"><br/>
		전화번호 : <input type="text" name="fupnum" value="${user.uPnum}" > <br/>
		이메일 : <input type="text" name="fuemail" value="${user.uEmail}" > <br/>	<br/>
		<input type="submit" value="수정 완료"/>
	</form>
</body>
</html>