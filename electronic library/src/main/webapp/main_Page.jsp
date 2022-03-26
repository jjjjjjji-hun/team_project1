<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	
	String sId = (String)session.getAttribute("sId");

	Boolean sUtype = (Boolean)session.getAttribute("sUtype");
	System.out.println("발급된 세션 아이디 : " + sId);
	System.out.println("발급된 세션 유저 타입 : " + sUtype);

%>

<!DOCTYPE html>
<html>
<head>
<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/mainPage.css">
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>

	<div class = "mainForm">
		<div id="header">
			<h1>전자도서관</h1>
			<hr/>
			<div class="log">
				<!-- 세션 아이디를 가져와서 로그인 상태면 '로그아웃' & '마이 페이지', 비로그인 상태면 '로그인' 버튼이 보이게 함 -->
				<div class = "listContainer">	
					<c:if test="${sId == null }">
						<a href="http://localhost:8181/electronic_library/users/login_form.jsp" class = "item">
							<div class="text">로그인</div>
						</a>
					</c:if>
						<!-- 로그아웃용 서블릿 만들어서 구현해야함. -->
						<c:if test="${sId != null }">
						<a href="http://localhost:8181/electronic_library/logout" class = "item">
							<div class="text">로그아웃</div>
						</a>
					</c:if>
					<c:if test="${sUtype eq true}">
					<a href="http://localhost:8181/electronic_library/uTypeCheck1.do" class = "item">
							<div class="text">관리페이지</div>
					</a>
					</c:if>
					<c:if test="${sUtype eq false}">
					<a href="http://localhost:8181/electronic_library/uTypeCheck0.do" class = "item">
							<div class="text">마이페이지 </div>
					</a>
					</c:if>
				</div>
				
				<div class = "listContainer2">	
					<a href="http://localhost:8181/electronic_library/requestList.do" class = "item">
							<div class="text">희망 도서 게시판</div>
					</a>
					<a href="http://localhost:8181/electronic_library/reviewList.do" class = "item">
							<div class="text">도서 리뷰 게시판</div>
					</a>
				</div>
			</div>	
		</div>
		
		<!-- 
		<div id="searchBar">
			<div class="search">
				<form action="http://localhost:8181/electronic_library/bookSearch.do" method="post">
					<h2>도서 검색</h2>
					<input type="text" name="fbname" placeholder="도서검색">
					<input type="submit" value="검색">
				</form>
			</div>	
		</div>
		 -->
		 
		 
		<!-- 03.17 안되면 삭제 -->
		
			<form action="http://localhost:8181/electronic_library/ServletBookSearch" method="post">
				<fieldset>
					<legend><h2>도서 검색</h2></legend>
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
			</form> 
		<br/>
	
		<hr/>		
		
		<h2>바로 대여 가능</h2>
		
		<div id="category">
			<!-- 대여 여부가 가능인 책 목록 표현 -->
			<c:forEach var="bookList" items="${allBookList2}">
				<c:if test="${bookList.checkOut eq false}">
					<a class = "item2" href="http://localhost:8181/electronic_library/bookDetail.do?bName=${bookList.bName}">
						<div class="text">${bookList.bName}</div>
					</a>	
				</c:if>
			</c:forEach>			
		</div>
		
		<br/>
		<hr/>

		<h2>도서 목록</h2>

		<div id="BookList">
			<c:forEach var="bookList" items="${allBookList1}">
					<a class = "item2" href="http://localhost:8181/electronic_library/bookDetail.do?bName=${bookList.bName}">
						<div class="text">${bookList.bName}</div>
					</a>	
			</c:forEach>			
		</div>
		
</body>
</html>