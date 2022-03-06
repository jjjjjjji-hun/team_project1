<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String sid = (String)session.getAttribute("session_id");

    if(sid != null){
    	response.sendRedirect("");
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>LOGIN</h1>
    <form action="http://localhost:8181/electronic_library/users/login_check.jsp" method="post">
        <input type="text" name="fId" placeholder="ID" required><br/>
        <input type="password" name="fPw" placeholder="PASSWORD" required><br/>
        <input type="submit" value="로그인">&nbsp;&nbsp;
        <a href="http://localhost:8181/electronic_library/users/join_form.jsp">회원가입</a>
       
    </form>
</body>
</html>