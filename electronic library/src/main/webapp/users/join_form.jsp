<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/joinForm.css">

<title>Insert title here</title>
</head>
<body>

	<div class = "menu">
	
		<form action ="http://localhost:8181/electronic_library/ServletJoin" class = "joinForm" method="post">
			<h1>회원 가입 페이지</h1>
			<hr/>
			<div class="textForm">
				<input type="text" name="fid" class="box" placeholder="아이디"  required /><br/>
			</div>
			
			<div class="textForm">
			<input type="password" name="fpw" class="box" placeholder="비밀번호" required/><br/>
			</div>
			
			<div class="textForm">
			<input type="text" name="fname" class="box" placeholder="이름" required/><br/>
			</div>
			
			<div class="textForm">
			<input type="text" name="fpnum" class="box" placeholder="전화번호" required/><br/>
			</div>
			
			<div class="textForm">
			<input type="email" name="femail" class="box" placeholder="이메일" required/><br/>
			</div>
			
		
			
			<input type="submit" class= "btn" value="회원가입"/>
			<input type="reset" class= "btn"value="초기화"/>

		</form>
		
	</div>
</body>
</html>

