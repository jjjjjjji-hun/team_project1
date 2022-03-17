<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- ServletBookSearch2에서 포워딩된 searchKeyword의 값(검색어 입력)이 있는 경우 -->
		<c:if test="${searchKeyword ne null}">
			<h1>검색하신 키워드와 관련된 정보가 없습니다</h1>
			<h2>다시 검색해주세요</h2><br/>
		</c:if>
	
	<!-- 해당 주소로 바로 들어온 경우는 아래만 출력 -->
	<form action="http://localhost:8181/electronic_library/ServletBookSearch2" method="post">
		<fieldset>
			<legend>도서 검색</legend>
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
	
	<button><a href="http://localhost:8181/electronic_library/"> 메인 화면으로 </a></button>
	
	
		<!-- 
	<h1>책 검색하기</h1>
	<form action="http://localhost:8181/electronic_library/ServletBookSearch" method="post">
		<input type="text" name="fbname" placeholder="도서명" required/><br/>
		<input type="submit" value="검색"/>
	</form>
	 -->
	
</body>
</html>