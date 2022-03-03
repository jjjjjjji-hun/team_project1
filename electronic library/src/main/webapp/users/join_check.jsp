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
	
	아이디 : ${fId }
	비밀번호 : ${fPW }
	이름 : ${fName }
	이메일 : ${fEmail }


	<% 
	
	UserDAO dao = UserDAO.getInstance();
	// 이걸 어떤식으로 넣어야 할지?
	// 변수를 또 만들어서 넣어주면 서블릿 거쳐오는 의미가 있을지
	// dao.insertUserData(${fId}, ${fPw}, ${fName}, ${fEmail});
	
	%>
	
	
	
	

</body>
</html>