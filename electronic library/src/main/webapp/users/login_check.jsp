<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="kr.co.ict.UserVO" %>
<%@ page import="kr.co.ict.UserDAO"%>

    <c:if test = "${ == 1 }">
       <script>alert('로그인이 완료되었습니다.');</script>
    </c:if>
    <c:if test = "${ == 0 }">
       <script>alert('없는 아이디입니다.');</script>
    </c:if>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>