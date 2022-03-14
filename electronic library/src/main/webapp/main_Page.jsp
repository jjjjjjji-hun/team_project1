<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	
	String sId = (String)session.getAttribute("sId");
	Boolean sUtype = (Boolean)session.getAttribute("sUtype");
	System.out.println("발급된 세션 아이디 : " + sId);
	System.out.println("발급된 세션 유저 타입 : " + sUtype);

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="header">
		<h1>전자도서광</h1>
		<div class="log">
			<!-- 세션 아이디를 가져와서 로그인 상태면 '로그아웃' & '마이 페이지', 비로그인 상태면 '로그인' 버튼이 보이게 함 -->

			<c:if test="${sId == null }">
				<a href="http://localhost:8181/electronic_library/users/login_form.jsp">
					<input type="button" value="로그인">
				</a>
			</c:if>
				<!-- 로그아웃용 서블릿 만들어서 구현해야함. -->
				<c:if test="${sId != null }">
				<a href="http://localhost:8181/electronic_library/logout">
					<input type="button" value="로그아웃">
				</a>

				<a href="http://localhost:8181/electronic_library/utypecheck">
					<input type="button" value="마이페이지">
				</a>
				

				
			</c:if>
		</div>	
	</div>
	<div id="searchBar">
		<div class="search">
			<form action="http://localhost:8181/electronic_library/ServletBookSearch" method="post">
				<h2>도서 검색</h2>
				<input type="text" name="fbname" placeholder="도서검색">
				<input type="submit" value="검색">
			</form>
		</div>	
	</div>
	<div id="category">
		<!-- 대여수가 많은 수로 나열 -->
		<h2>바로 대여 가능</h2>
		<c:forEach var="bookList" items="${allBookList}">
			<c:if test="${bookList.checkOut eq true}">
				<a href="http://localhost:8181/electronic_library/book/book_detail.jsp">
				${bookList.bName}
				</a>	
			</c:if>
		</c:forEach>			
	</div>
	<div id="BookList">
		<h2>도서 목록</h2>
		<c:forEach var="bookList" items="${allBookList}">
			<td>${bookList.bName}</td>
		</c:forEach>
	</div>
</body>
</html>