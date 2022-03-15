<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="kr.co.ict.UserVO" %>
<%@ page import="kr.co.ict.UserDAO"%>
<% 
	request.setCharacterEncoding("utf-8");
    String fId = request.getParameter("fid");
    String fPw = request.getParameter("fpw");  
    
    UserDAO dao = UserDAO.getInstance();
	UserVO user = dao.getUserData(fId);
	
	if(user.getuId() != null){
		
		String uId = user.getuId();
		String uPw = user.getuPw();
		
		if(fId.equals(uId) && fPw.equals(uPw)){
			
			session.setAttribute("session_id", uId);
			session.setAttribute("session_pw", uPw);
			//session.setMaxInactiveInterval(3);
			//String userId = (String)session.getAttribute("session_id");
			//System.out.print(userId);
			response.sendRedirect("../main_Page.jsp");
			
		}else{
			out.println("<script>alert('비밀번호가 없습니다 . 다시 확인해 주세요.'); </script>");
		}
	}else{
		out.println("<script>alert('아이디가 없습니다. 입력 아이디를 확인해주세요.'); </script>");
	}
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