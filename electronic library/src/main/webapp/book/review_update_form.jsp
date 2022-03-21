<!-- 리뷰 수정하는 폼 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sId ne reviewDetail.uId}">
	<% response.sendRedirect("http://localhost:8181/electronic_library/reviewList.do"); %>
</c:if>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	
	<h1>리뷰 ${reviewDetail.revNum}번 수정 페이지</h1>

	<form action="http://localhost:8181/electronic_library/updateReview.do" method="post">
		리뷰 번호 <input type="number" name="revnum" value="${reviewDetail.revNum}" readonly>	&nbsp;&nbsp;
		책 번호 <input type="number" name="booknum" value="${reviewDetail.bNum}" readonly>&nbsp;&nbsp;
		작성일 <input type="text" value="${reviewDetail.revDate}" readonly>
		수정일 <input type="text" value="${reviewDetail.revMDate}" readonly><br/><br/><br/>
			
		제목 <textarea rows="1" cols="50" name="title">${reviewDetail.revTitle}</textarea> &nbsp;&nbsp;
		아이디 <input type="text" name="fid" value="${reviewDetail.uId}" readonly><br/><br/> <br/>
		<textarea rows="15" cols="100" name="content">${reviewDetail.revContent}</textarea> <br/><br/>
		<input type="reset" value="초기화"/>
		<input type="submit" value="수정 완료"/>
	</form>

</body>
</html>