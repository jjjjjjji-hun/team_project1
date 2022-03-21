<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.sUtype eq false}">
	<c:redirect url="http://localhost:8181/electronic_library/userPage.do"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>관리자 페이지</h1>
	
	<a href="http://localhost:8181/electronic_library/userList.do"><button>회원 관리</button></a>
	<a href="http://localhost:8181/electronic_library/bookList.do"><button>도서 관리</button></a>
	<a href="http://localhost:8181/electronic_library/bookRentList.do"><button>대출 도서 관리</button></a> <br/><br/>

	<!-- 메인 페이지로 이동 -->
	<a href="http://localhost:8181/electronic_library/mainPage.do"><button>메인 페이지로 이동</button></a>

</body>
</html>