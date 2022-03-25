<!-- 리뷰 수정하는 폼 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${sId ne reviewDetail.uId}">
	<% response.sendRedirect("http://localhost:8181/electronic_library/reviewList.do"); %>
</c:if>
	
<!DOCTYPE html>
<html>
<head>
<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/reviewUpdateForm.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div class = "bookReviewDetail">
		<h1>리뷰 ${reviewDetail.revNum}번 수정 페이지</h1>
		<hr/>
		<form action="http://localhost:8181/electronic_library/updateReview.do" method="post">
		
			<div class = "auto">
				<div class = "item">
					<div class = "title"> 리뷰 번호  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="number" name="revnum" value="${reviewDetail.revNum}" readonly>	
								
					</div>
				</div>
				
				<div class = "item">
					<div class = "title"> 책 번호  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="number" name="booknum" value="${reviewDetail.bNum}" readonly>			
					</div>
				</div>
				
				<div class = "item">
					<div class = "title"> 작성일  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text" value="${reviewDetail.revDate}" readonly>			
					</div>
				</div>
				
				<div class = "item">
					<div class = "title"> 수정일  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text" value="${reviewDetail.revMDate}" readonly>	
					</div>
				</div>
			
				
			</div>
			<br/><br/>
			
			<div class = "auto2">
				<div class = "item">
					<div class = "title"> 제목  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<textarea rows="3" cols="30" name="title">${reviewDetail.revTitle}</textarea>
					</div>
				</div>
				
				<div class = "item">
					<div class = "title"> 아이디  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text" name="fid" value="${reviewDetail.uId}" readonly>
					</div>
				</div>
				<hr/>
				<textarea rows="15" cols="100" name="content">${reviewDetail.revContent}</textarea>
			</div>
			<input type="reset" value="초기화" class = "btn"/>
			<input type="submit" value="수정 완료" class = "btn"/>
		
		</form>
	</div>
	
	



</body>
</html>