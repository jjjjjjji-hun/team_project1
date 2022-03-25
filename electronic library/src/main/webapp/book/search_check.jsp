<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("utf-8");%>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/searchCheck.css">

<meta charset="UTF-8">
<title>검색한 도서 페이지</title>
</head>
<body>

	<div class ="searchCheck">
		<div class = "header">
	
			<h1>검색된 도서명</h1>
			<hr/>
	
			<div class = "right">
				<div class = "listContainer">
					<a href="javascript:history.back();" class = "item">
						<div class="text">뒤로가기</div>
					</a>			
				</div>
			</div>
		</div>
		<h2>예시</h2>

		<!-- 검색한 도서 정보 -->
		
		
		<table class="table table-hover">
			
				<thead>
					<th>도서 번호</th>
					<th>도서명</th>
					<th>카테고리</th>
	
					
				</thead>
				<tbody>
				<!-- 사용자가 검색한 단어를 포함하는 책 리스트 보여주기 코드 찾는중 -->
					<c:forEach var="SearchList" items="${BookList}">
						<tr>
							<td>${SearchList.bNum}</td>
							<td><a href="http://localhost:8181/electronic_library/bookDetail.do?bName=${SearchList.bName }">${SearchList.bName }</a></td>
							<td>${SearchList.bCategory}</td>
						</tr>
					</c:forEach>
				</tbody>
			
		</table><br/>
		

	</div>

</body>
</html>