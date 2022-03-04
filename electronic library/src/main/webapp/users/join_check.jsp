<%@page import="kr.co.ict.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>확인</h1>
	아이디 : ${fId }
	비밀번호 : ${fPW }
	이름 : ${fName }
	핸드폰 : ${fPnum }
	이메일 : ${fEmail }

	

	<% 
	
	UserDAO dao = UserDAO.getInstance();
	// 이걸 어떤식으로 넣어야 할지?
	// <c:set>으로 변수 만들어서 넣기?
	
	// dao.insertUserData(${fId}, ${fPw}, ${fName}, ${fEmail});
	
	%>
	
	
	
	

</body>
</html>