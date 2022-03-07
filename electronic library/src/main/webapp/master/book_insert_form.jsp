<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>도서 추가</h1>
	<form action="book_insert_check.jsp" method="get">
		책번호 : <input type="text" name="bnum" required /><br/>
		책이름 : <input type="text" name="bname" required /><br/>
		지은이 : <input type="text" name="bwriter" required /><br/>
		출판사 : <input type="text" name="bpub" required /><br/>
		카테고리 : <input type="text" name="bcategory" required /><br/>
		<input type="submit" value="추가"/><input type="reset" value="초기화"/>
	</form>
</body>
</html>