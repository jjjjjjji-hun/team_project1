<%@page import="kr.co.ict.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여 가능 여부 확인</title>
</head>
<body>
<%
	/* 
	book_detail에서 받은 정보가 rent table에서 1(true)일 경우
	대여 불가능, 
	받은 정보가 rent table에서 0(false)일 경우
	대여 완료                                         
	*/
	// 
	if(session.getAttribute("sId") == null){
		out.println("<script>alert('로그인이 필요한 서비스 입니다.');</script>");
	} else {
		out.println("<script>alert('대여가 완료되었습니다. 마이페이지를 확인해주세요.');</script>");
		// 대여 완료후 자료형 true로 변경하는 코드
		
}
%>	 
	 
</body>
</html>