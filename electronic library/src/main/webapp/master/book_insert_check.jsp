<%@page import="kr.co.ict.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
    request.setCharacterEncoding("utf-8");
    // form에서 보낸 정보 변수로 저장.
    int bNum = Integer.parseInt(request.getParameter("bnum"));
    String bName = request.getParameter("bname");
    String bWriter = request.getParameter("bwriter");
    String bPub = request.getParameter("bpub");
    String bCategory = request.getParameter("bcatecory");
   
    // DAO 생성
    BookDAO dao = BookDAO.getInstance();
    // insertBookData 로직 호출
    dao.insertBookData(bNum, bName, bWriter, bPub, bCategory, true);
%>         
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>