<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/bookReviewDetail.css">

<meta charset="UTF-8">
<title>도서 리뷰 상세페이지</title>
</head>
<body>
	<div class = "bookReviewDetail">
			<div class = "header">
			<h1>리뷰 ${reviewDetail.revNum}번 상세 페이지</h1>
			<hr/>
			<div class = "right">
				<div class = "listContainer">
					<a href="javascript:history.back();" class = "item">
						<div class="text"> 뒤로가기</div>
					</a>
				</div>
			</div>
		</div>
		
		<div class = "auto">
			<div class = "item">
				<div class = "title"> 리뷰 번호  </div>
				<div class = "title_icon">:</div>
				<div class = "main">
					<input type="text" value="${reviewDetail.revNum}" readonly>				
				</div>
			</div>
			
			<div class = "item">
				<div class = "title"> 책 이름  </div>
				<div class = "title_icon">:</div>
				<div class = "main">
					<input type="text" value="${reviewDetail.bName}" readonly> 			
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
					<textarea rows="3" cols="30" readonly>${reviewDetail.revTitle}</textarea>
				</div>
			</div>
			
			<div class = "item">
				<div class = "title"> 아이디  </div>
				<div class = "title_icon">:</div>
				<div class = "main">
					<input type="text" value="${reviewDetail.uId}" readonly>
				</div>
			</div>
			<hr/>
			<textarea rows="15" cols="100" readonly>${reviewDetail.revContent}</textarea>
		</div>
		

		
		<!-- 03.16 리뷰를 쓴 아이디와 세션 아이디가 같은 경우만 수정/삭제 가능하도록 -->
		<div class = "bottom">
			<c:if test="${sId eq reviewDetail.uId}">
				<div class ="item">
					<form action="http://localhost:8181/electronic_library/deleteReview.do" method="post" >
						<input type="hidden" name="revnum" value="${reviewDetail.revNum}"/>
						<input type="hidden" name="fid" value="${reviewDetail.uId}"/>
						<input type="submit" value="리뷰 삭제" class = "text" />
					</form><br/>
				</div>
				<div class = "item">
					<form action="http://localhost:8181/electronic_library/updateReviewForm.do" method="post" >
						<input type="hidden" name="revnum" value="${reviewDetail.revNum}"/>
						<input type="submit" value="리뷰 수정" class = "text "/>
					</form><br/>
				</div>
			</c:if>
				<div class = "item">
					<a href="/electronic_library/reviewList.do"> 
				        <div class="text">리뷰 목록 보기</span> </div>
					</a>
				</div>
			
	
		</div>
	</div>	

</body>
</html>