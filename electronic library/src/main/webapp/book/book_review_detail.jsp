<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>리뷰 ${reviewDetail.revNum}번 상세 페이지</h1>

	리뷰 번호 <input type="text" value="${reviewDetail.revNum}" readonly>	&nbsp;&nbsp;
	책 번호 <input type="text" value="${reviewDetail.bNum}" readonly>&nbsp;&nbsp;
	작성일 <input type="text" value="${reviewDetail.revDate}" readonly>
	수정일 <input type="text" value="${reviewDetail.revMDate}" readonly><br/><br/><br/>
	
	
	
	제목 <textarea rows="1" cols="50" readonly>${reviewDetail.revTitle}</textarea> &nbsp;&nbsp;
	아이디 <input type="text" value="${reviewDetail.uId}" readonly><br/><br/> <br/>
	<textarea rows="15" cols="100" readonly>${reviewDetail.revContent}</textarea> <br/><br/>
	
	<!-- 03.16 리뷰를 쓴 아이디와 세션 아이디가 같은 경우만 수정/삭제 가능하도록 -->
	<c:if test="${sId eq reviewDetail.uId}">
		<form action="http://localhost:8181/electronic_library/deleteReview.do" method="post">
			<input type="hidden" name="revnum" value="${reviewDetail.revNum}"/>
			<input type="hidden" name="fid" value="${reviewDetail.uId}"/>
			<input type="submit" value="리뷰 삭제"/>
		</form><br/>
		
		<form action="http://localhost:8181/electronic_library/updateReviewForm.do" method="post">
			<input type="hidden" name="revnum" value="${reviewDetail.revNum}"/>
			<input type="submit" value="리뷰 수정"/>
		</form><br/>
	</c:if>
	
	<a href="/electronic_library/reviewList.do"><button>리뷰 목록 보기</button></a>
	
	

</body>
</html>