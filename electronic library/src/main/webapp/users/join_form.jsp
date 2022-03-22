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

	
	<div class = "joinForm">
	
		<form action ="http://localhost:8181/electronic_library/userJoin.do"  method="post">
			<h1>회원 가입 페이지</h1>
			<hr/>
			<div class="textForm">
				<input type="text" name="fid" class="text" placeholder="아이디"  required /><br/>
			</div>
			
			<div class="textForm">
				<input type="password" name="fpw" class="text" placeholder="비밀번호" required/><br/>
			</div>
			
			<div class="textForm">
				<input type="text" name="fname" class="text" placeholder="이름" required/><br/>
			</div>
			
			<div class="textForm">
				<input type="text" name="fpnum" class="text" placeholder="전화번호" required/><br/>
			</div>
			
			<div class="textForm">
				<input type="email" name="femail" class="text" placeholder="이메일" required/><br/>
			</div>
			

			
			<input type="submit" class= "btn" value="회원가입"/>
			<input type="reset" class= "btn"value="초기화"/>
		</form>
		
	</div>
</body>
</html>