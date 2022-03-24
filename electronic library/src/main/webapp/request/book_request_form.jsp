<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/bookRequestForm.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 로그인 하지 않은 사용자가 폼에 접근시 리스트로 리다이렉트 -->
	<div class = "bookRequestForm">

		<div class = "header">
			<h1>희망 도서 신청</h1>
			<hr/>
			<div class = "right">
				<div class = "listContainer">
					<a href="http://localhost:8181/electronic_library/requestList.do" class = "item">
						<div class="text"> 뒤로가기</div>
					</a>
					<a href="http://localhost:8181/electronic_library/mainPage.do" class = "item">
						<div class="text">메인화면으로</div>
					</a>
				</div>
			</div>
		</div>
		


		<form action="http://localhost:8181/electronic_library/requestInsertFormToDB.do" method="post">
			<div class ="auto">
			
				<div class = "item2">
					<div class = "title"> 국가선택  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<select name= "fcountry">
							<option value="국내서">국내서</option>
							<option value="영미">영미</option>
							<option value="중국">중국</option>
							<option value="일본">일본</option>
							<option value="프랑스">프랑스</option>
							<option value="독일">독일</option>
						</select>
					</div>
				</div>


				<div class = "item2">
					<div class = "title"> 신청자 아이디  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text" name="reqid" value="${sId}" size=40 required/> 
					</div>
				</div>
				
				<div class = "item2">
					<div class = "title"> 신청 도서 이름  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
					<input type="text" name="fbname"  size=40 required/> 
					</div>
				</div>
				
				<div class = "item2">
					<div class = "title"> 저자  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
					<input type="text" name="fbwriter" size=40 required/> <br/>
					</div>
				</div>
				
				<div class = "item2">
					<div class = "title"> 출판사  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
					<input type="text" name="fbpub" size=40 required/> <br/>
					</div>
				</div>
				
				<div class = "item2">
					<div class = "title"> 카테고리  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
					<input type="text" name="fbcategory" size=40 required/> <br/><br/>
					</div>
				</div>
				

			</div>
			<br/>
			<br/>
	
			제 목  <textarea rows="1" cols="94" name="ftitle" required></textarea><br/><br/>
			
			<textarea rows="15" cols="100" name="fcontent" required></textarea> <br/><br/>

	
			<div class = "bottom">
				<div class ="item">
					<input type="reset" value="다시쓰기" class ="text"/>
				</div>
				<div class ="item">
					<input type="reset" value="수정 완료" class ="text"/>
				</div>
	
			</div>		
					
	
		</form><br/>
	</div>
</body>
</html>