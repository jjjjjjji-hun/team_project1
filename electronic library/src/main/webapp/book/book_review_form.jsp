<!-- 작업중 

	지금은 아이디를 직접 입력할 거지만 나중에 세션 처리 할것
	리뷰 작성 클릭시 아이디 넘기게 (책 번호, 책 이름도)

-->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/bookReviewForm.css">

<title>Insert title here</title>
</head>
<body>
	<div class = "menu">
		<h1>리뷰 작성 페이지 </h1>
		<hr/>
			<form action="http://localhost:8181/electronic_library/insertReview.do" method="post" class = "review">
			
				<div class = "auto">	
					<div class = "item">
						책 번호 <input type="number" name="fbnum" value="${bNum}" readonly>;
					</div>
					
					<div class = "item">
					책 이름 <input type="text" name="fbname" value="${bName}" readonly>;
					</div>
					
					<div class = "item">
					아이디 <input type="text" name="fid" value="${uId}" readonly>
					</div>
				</div>
				
				<div class = "main">
					<div class = "main_item">
						제목 <textarea rows="1" cols="50" name="ftitle"></textarea>
					</div> 
					<hr/>
					<div class = "main_item">
						<textarea rows="15" cols="100" name="fcontent"></textarea>
					</div>	 
				</div>
				<input type="reset" value="초기화" class = "btn"/>
				<input type="submit" value="작성 완료" class = "btn"/>
			</form>
	</div>
</body>
</html>