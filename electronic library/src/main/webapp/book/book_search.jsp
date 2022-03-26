<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/bookSearch.css">

<meta charset="UTF-8">
<title>도서 검색 페이지</title>
</head>
<body>

	<div class = "bookSearch">
	
		<div class = "header">
			<h1>도서 검색 페이지</h1>
		
			<c:if test="${searchKeyword ne null}">
				<h3>다시 검색해주세요</h3>
			</c:if>
			
			<hr/>
			<div class = "right">
				<div class = "listContainer">
					<a href="http://localhost:8181/electronic_library/mainPage.do" class = "item">
						<div class="text">메인화면으로</div>
					</a>
				</div>
			</div>
		</div>

		
		<!-- 해당 주소로 바로 들어온 경우는 아래만 출력 -->
		<form action="http://localhost:8181/electronic_library/ServletBookSearch" method="post">
			<fieldset class = "search">
				<legend>도서 검색</legend><br/>
				<label>검색 항목</label>
				<select name= "option">
					<option value="bname">도서명</option>
					<option value="bwriter">저자</option>
					<option value="bpub">출판사</option>
					
				</select>
				<label>검색어
					<input type="text" name="keyword" placeholder="검색하기" size=40 />
					<input type="submit" value="검색">
				</label>
			</fieldset>
		</form><br/>
		
		

			<!-- 
		<h1>책 검색하기</h1>
		<form action="http://localhost:8181/electronic_library/ServletBookSearch" method="post">
			<input type="text" name="fbname" placeholder="도서명" required/><br/>
			<input type="submit" value="검색"/>
		</form>
		 -->
	</div>

</body>
</html>