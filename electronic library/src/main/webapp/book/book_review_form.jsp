<!-- 작업중 

	지금은 아이디를 직접 입력할 거지만 나중에 세션 처리 할것
	리뷰 작성 클릭시 아이디 넘기게 (책 번호, 책 이름도)

-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 잘못된 접근시 (주소창에 파라미터 값을 입력해서 들어온 경우) 리다이렉트 -->
<c:if test="${rentalCheck eq null}">
	<% response.sendRedirect("http://localhost:8181/electronic_library/reviewList.do"); %>
</c:if>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>리뷰 작성 페이지 </h1>
	
		<form action="http://localhost:8181/electronic_library/insertReview.do" method="post">
			책 번호 <input type="number" name="fbnum" value="${bNum}" readonly>&nbsp;&nbsp;
			책 이름 <input type="text" name="fbname" value="${bName}" readonly>&nbsp;&nbsp;
			아이디 <input type="text" name="fid" value="${uId}" readonly><br/><br/> <br/>
			제목 <textarea rows="1" cols="50" name="ftitle"></textarea> <br/> <br/>
			<textarea rows="15" cols="100" name="fcontent"></textarea> <br/><br/>
			<input type="reset" value="초기화"/>
			<input type="submit" value="작성 완료"/>
		</form>
</body>
</html>