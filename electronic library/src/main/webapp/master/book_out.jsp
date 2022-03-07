<%@page import="kr.co.ict.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 폼에서 전송한 데이터
	String bName = request.getParameter("bname");
	// 다오생성
	BookDAO dao = BookDAO.getInstance();
	// DELETE 로직 호출
	dao.deleteBookData(bName);
%>	
</body>
</html>