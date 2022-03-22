<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<!-- (서비스)UserLoginService : 아이디/비밀번호가 DB와 다른 경우에 main으로 fId를 포워딩함
		 로그인에 실패했으므로 sId는 발급되지 않은 상태 -->
	<c:if test="${fId ne sId}">
		<script>alert('잘못 입력하셨습니다'); location.href='http://localhost:8181/electronic_library/users/login_form.jsp';</script>
	</c:if>
	
	<!-- (서비스)UserLoginService : 폼에서 날린 아이디가 DB에 없는 경우-->
	<c:if test="${user eq null}">
		<script>alert('존재하지 않는 아이디입니다.'); location.href='http://localhost:8181/electronic_library/users/login_form.jsp';</script>
	</c:if>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>