<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/bookInsertForm.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class = "bookInsertForm">
		<h1>도서 추가</h1>
		<hr/>
		<form action="http://localhost:8181/electronic_library/bookInsert" method="get">
			<div class="item">
				<div class = "title"> 책번호  </div>
				<div class = "title_icon">:</div>
				<input type="text" name="bnum" class="textForm" required /><br/>
			</div>
			<div class="item">
				<div class = "title"> 책이름  </div>
				<div class = "title_icon">:</div>
				<input type="text" name="bname" class="textForm" required /><br/>
			</div>
			<div class="item">
				<div class = "title"> 지은이  </div>
				<div class = "title_icon">:</div>
				<input type="text" name="bwriter" class="textForm" required /><br/>
			</div>
			<div class="item">
				<div class = "title"> 출판사  </div>
				<div class = "title_icon">:</div>
				<input type="text" name="bpub" class="textForm" required /><br/>
			</div>
			<div class="item">
				<div class = "title"> 카테고리  </div>
				<div class = "title_icon">:</div>
				<input type="text" name="bcategory" class="textForm" required /><br/>
			</div>
			<br/><br/>
			<input type="submit" class= "btn" value="추가"/>
			<input type="reset" class= "btn"value="초기화"/>
			
		</form>
	</div>"
</body>
</html>