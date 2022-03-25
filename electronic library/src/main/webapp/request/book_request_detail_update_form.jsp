<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 다른 사람이 작성한 수정폼에 들어오면 해당 리뷰 디테일로 리다이렉트 
	 주소창에 /requestUpdateForm.do 만 쳐서 들어오는 경우도 커버됨. -->

<!DOCTYPE html>
<html>
<head>

	<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/bookRequestDetailUpdateForm.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${sId ne requestDetail.reqId}">
		<c:redirect url="http://localhost:8181/electronic_library/requestList.do"/>
	</c:if>
	
	<div class = "bookRequestDetailUpdateForm">
	
			
		<div class = "header">
			<h1>도서 요청 디테일 수정 폼</h1>
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

		
			
	
			<form action="http://localhost:8181/electronic_library/requestUpdateFormToDB.do" method="post">
			<div class = "auto">
			
				<div class = "item2">
					<div class = "title"> 글번호  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text" name="reqnum" value="${requestDetail.reqNum}" readonly> 
					</div>
				</div>
				
				<div class = "item2">
					<div class = "title"> 조회수  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text" name="reqnum" value="${requestDetail.hit}" readonly> 
					</div>
				</div>

				<div class = "item2">
					<div class = "title"> 신청일  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text" value="${requestDetail.reqDate}" readonly> 
					</div>
				</div>


				<div class = "item2">
					<div class = "title"> 수정일  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text" value="${requestDetail.reqmDate}" readonly> &nbsp;
					</div>
				</div>


				<div class = "item2">
					<div class = "title"> 신청자  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text" name="reqid" readonly size=20 value="${requestDetail.reqId}"> 
					</div>
				</div>

				<div class = "item2">
					<div class = "title"> 국가분류  </div>
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
					<div class = "title"> 신청 도서  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text" name="fbname" value="${requestDetail.bName}"  /> 	
					</div>
				</div>


				<div class = "item2">
					<div class = "title"> 도서 저자  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text" name="fbwriter" value="${requestDetail.bWriter}" />
					</div>
				</div>

				<div class = "item2">
					<div class = "title"> 출 판 사  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text"value="${requestDetail.bPub}" readonly/>					
					</div>
				</div> 
				
				<div class = "item2">
					<div class = "title"> 카테고리  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text"value="${requestDetail.bCategory}"  readonly/>					
					</div>
				</div> 
		
			</div>
				</br>
				제 목  <textarea rows="1" cols="94" name="ftitle">${requestDetail.reqTitle}</textarea><br/><br/>
				
				<textarea rows="15" cols="100" name="fcontent">${requestDetail.reqContent}</textarea> <br/><br/>
				
				
			<div class = "bottom">
				<div class ="item">
					<input type="reset" value="다시 수정하기" class ="text"/>
				</div>
				<div class ="item">
					<input type="reset" value="수정 완료" class ="text"/>
				</div>
	
			</div>
			</form>
		
	</div>
	
</body>
</html>