<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/bookSearch.css">


<title>Insert title here</title>
</head>
<body>

	<div class = "menu">
		<h1>책 검색하기</h1>
		<hr/>
		<form action="http://localhost:8181/electronic_library/ServletBookSearch" method="post">
			<div class="item">
				<div class = "title"> 책이름  </div>
				<div class = "title_icon">:</div>
				<input type="text" name="fbname" placeholder="도서명"  class="textForm" required/><br/>
			</div>
			<input type="submit" value="검색" class = "btn" />
			
		</form>
	</div>
</body>
</html>