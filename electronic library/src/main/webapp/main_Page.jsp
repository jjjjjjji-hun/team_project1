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
			</c:if>
			<br/>

		</div>	
	</div><br/>

	<!-- 관리자 페이지/ 마이 페이지 버튼 따로 만듦 -->
	<c:if test="${sUtype eq true}">
		<a href="http://localhost:8181/electronic_library/uTypeCheck1.do"><button>관리자 페이지</button></a>
	</c:if>	
	<c:if test="${sUtype eq false}">
		<a href="http://localhost:8181/electronic_library/uTypeCheck0.do"><button>마이 페이지</button></a>
	</c:if>	
	
	<a href="http://localhost:8181/electronic_library/requestList.do"><button>희망 도서 리스트</button></a>
	<a href="http://localhost:8181/electronic_library/reviewList.do"><button>회원 리뷰 리스트</button></a><br/><br/>
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
	
	
	<div id="category">
		<!-- 대여 여부가 가능인 책 목록 표현 -->
		<h2>바로 대여 가능</h2>
		<c:forEach var="bookList" items="${allBookList}">
			<c:if test="${bookList.checkOut eq false}">
				<a href="http://localhost:8181/electronic_library/book/bookDetail.do">
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