<!-- 아직 작업중) 회원 대여 정보 구현 아직-->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String sId = (String)session.getAttribute("sId"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/mypage.css">


<title>Insert title here</title>
</head>
<body>
	
	<div class ="menu">
		<h1>Mypage</h1>
		<h3>${user.uId}님의 회원 정보</h3>
		<hr/>
	
		
		
		
		<div class ="listContainer">
			
			<div class = "item">
				<div class = "title"> 이름  </div>
				<div class = "title_icon">:</div>
				<div class = "main">
					${user.uName}
				</div>
			</div>
			
		
			<div class = "item">
				<div class = "title"> 아이디 </div>
				<div class = "title_icon">:</div>
				<div class = "main">
					${user.uId}
				</div>
			</div>
			
			<div class = "item">
				<div class = "title"> 비밀번호  </div>
				<div class = "title_icon">:</div>
				<div class = "main">
					${user.uPw}
				</div>
			</div>
			
			
			<div class = "item">
				<div class = "title"> 전화번호  </div>
				<div class = "title_icon">:</div>
				<div class = "main">
					${user.uPnum}
				</div>
			</div>
			
			
			<div class = "item">
				<div class = "title"> 이메일  </div>
				<div class = "title_icon">:</div>
				<div class = "main">
					${user.uEmail}
				</div>
			</div>
			
			
			<!-- 대여 중인 도서 수 : <input type="number" value="${user.counting}" readonly> <br/><br/> 대여 정보로 옮김-->
			
		</div>
		
		
		<br/>
		<hr/>
		
		<h4>회원 메뉴</h4>
		<div class="listContainer">
			<!-- 정보 수정하기 -->
			<form action="http://localhost:8181/electronic_library/userInfoUpdateForm.do" method="post" class ="item">
				<input type="hidden" name="fid" value="${user.uId}"/>
				<input type="submit" class="text" value="정보 수정"/></span>
			</form>
			
			<!-- 대여정보 구현  -->
			<form action="http://localhost:8181/electronic_library/rentInfo.do" method="post" class="item">
				<input type="submit" class = "text" value="대여 정보"/>
			</form>
			
			<!-- 탈퇴하기 -->
			<form action="http://localhost:8181/electronic_library/userOut.do" method="post" class = "item">
				<input type="submit" class = "text" value="탈퇴하기"/>
			</form>
			
			<form action="http://localhost:8181/electronic_library/mainPage.do" method="post" class = "item">
				<input type="submit" class = "text" value="메인화면으로"/>
			</form>
			
		</div>
		
	</div>


</body>
</html>