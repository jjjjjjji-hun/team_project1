<!-- 여기 수정중 -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/userInfoUpdate.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<div class = "userinfoUpdateForm">
	
		<form action ="http://localhost:8181/electronic_library/userinfoupdate"  method="post">
			<h1> ${user.uId}님 회원 정보 수정</h1> <br/>

			<hr/>
			<div class="item">
				<div class = "title"> 아이디  </div>
				<div class = "title_icon">:</div>
				<input type="text" name="fuid" class="textForm"  value="${user.uId}"  readonly /><br/>
			</div>
			
			<div class="item">
				<div class = "title"> 비밀번호  </div>
				<div class = "title_icon">:</div>
				
				<input type="password" name="fupw" class="textForm"  value="${user.uPw}" /><br/>
			</div>
			
			<div class="item">
				<div class = "title"> 이름  </div>
				<div class = "title_icon">:</div>
				<input type="text" name="funame" class="textForm"  value="${user.uName}" /><br/>
			</div>
			
			<div class="item">
				<div class = "title"> 전화번호  </div>
				<div class = "title_icon">:</div>
				<input type="text" name="fupnum" class="textForm"  value="${user.uPnum}" /><br/>
			</div>
			
			<div class="item">
				<div class = "title"> 이메일  </div>
				<div class = "title_icon">:</div>
				<input type="email" name="fuemail" class="textForm"  value="${user.uEmail}" /><br/>
			</div>
			
			<br/>
			<br/>
			
			<input type="submit" class= "btn" value="수정완료"/>
			<input type="reset" class= "btn"value="초기화"/>
		</form>
		
	</div>
</body>
</html>



