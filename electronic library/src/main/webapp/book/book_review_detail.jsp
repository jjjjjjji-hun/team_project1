<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
		
	<form action="http://localhost:8181/electronic_library/deleteReview.do" method="post">
		<input type="hidden" name="revnum" value="${reviewDetail.revNum}"/>
		<input type="submit" value="리뷰 삭제"/>
	</form><br/>
	
	<form action="http://localhost:8181/electronic_library/updateReviewForm.do" method="post">
		<input type="hidden" name="revnum" value="${reviewDetail.revNum}"/>
		<input type="submit" value="리뷰 수정"/>
	</form><br/>
	
	<button><a href="/electronic_library/reviewList.do">리뷰 목록 보기</a></button>
	
	

</body>
</html>