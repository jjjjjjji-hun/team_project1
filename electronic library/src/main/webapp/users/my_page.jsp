<!-- 아직 작업중) 회원 대여 정보 구현 아직-->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String sId = (String)session.getAttribute("sId"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>유저 페이지</h1>
	
	<h3> ${user.uId}님의 회원 정보</h3> <br/>
	
	
	아이디 : <input type="text" value="${user.uId}" readonly><br/>
	비밀번호 : <input type="text" value="${user.uPw}" readonly><br/>
	이름 : <input type="text" value="${user.uName}" readonly><br/>
	전화번호 : <input type="text" value="${user.uPnum}" readonly> <br/>
	이메일 : <input type="text" value="${user.uEmail}" readonly> <br/>	<br/>
	대여 중인 도서 수 : <input type="number" value="${user.counting}" readonly> <br/><br/>
	
	<!-- 정보 수정하기 -->
	<form action="http://localhost:8181/electronic_library/userupdateform" method="post">
		<input type="hidden" name="fid" value="${user.uId}"/>
		<input type="submit" value="정보 수정"/>
	</form>
	
	<!-- 대여정보 구현 아직 -->
	<!-- <form action="http://localhost:8181/electronic_library/rentinfo" method="post">
		<input type="hidden" name="sid" value="${sessionScope.sId}"/>
		<input type="submit" value="대여 정보"/>
	</form>-->
	<button><a href="http://localhost:8181/electronic_library/rentinfo"> 대여 정보 </a></button>
	
	<!-- 탈퇴하기 -->
	<form action="http://localhost:8181/electronic_library/memberout" method="post">
		<input type="submit" value="탈퇴하기"/>
	</form>
	
	<button><a href="http://localhost:8181/electronic_library/main_Page.jsp"> 메인 화면으로 </a></button>

</body>
</html>