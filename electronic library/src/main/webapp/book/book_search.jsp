<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>책 검색하기</h1>
	<form action="http://localhost:8181/electronic_library/ServletBookSearch" method="post">
		<input type="text" name="fbname" placeholder="도서명" required/><br/>
		<input type="submit" value="검색"/>
	</form>
</body>
</html>