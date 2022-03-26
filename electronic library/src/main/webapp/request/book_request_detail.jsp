<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/bookRequestDetail.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 주소창에 그냥 requestDetail.do 쳤을때 커버하는 코드 -->
	<c:if test="${requestDetail eq null}">
		<c:redirect url="http://localhost:8181/electronic_library/requestList.do"/>
	</c:if>
	

	<div class = "bookRequestDetail">
		


		<!-- 요청상태를 위한 작업 -->
		<c:set var="reqStatus"/>
		<c:choose>
			<c:when test="${requestDetail.reqStatus eq false}">
					<c:set var="reqStatus" value="대기중" />
			</c:when>
			<c:otherwise>
					<c:set var="reqStatus">구매완료</c:set>	
			</c:otherwise> 
		</c:choose>
		
		
		<div class = "header">
			<h1>도서 요청 디테일</h1>
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
		
		
		
		
		
			<div class = "auto">
				<div class = "item2">
					<div class = "title"> 요청상태  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text" value="${reqStatus}" readonly/>				
					</div>
				</div>
				
				<div class = "item2">
					<div class = "title"> 글 번호  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text" value="${requestDetail.reqNum}" name="reqnum" readonly>			
					</div>
				</div>


				<div class = "item2">
					<div class = "title"> 조회수  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text" value="${requestDetail.hit}" readonly/>				
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
						<input type="text" value="${requestDetail.reqmDate}" readonly>				
					</div>
				</div>	
				
				<div class = "item2">
					<div class = "title"> 신청자  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text" value="${requestDetail.reqId}" readonly>				
					</div>
				</div>	

				<div class = "item2">
					<div class = "title"> 국가 분류  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text" value="${requestDetail.country}"  readonly/>			
					</div>
				</div>	

				<div class = "item2">
					<div class = "title"> 신청 도서  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text" value="${requestDetail.bName}" readonly/>					
					</div>
				</div>	
				
				<div class = "item2">
					<div class = "title"> 도서 저자  </div>
					<div class = "title_icon">:</div>
					<div class = "main">
						<input type="text" value="${requestDetail.bWriter}"  readonly/>					
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
				
				<br/>
				
				제 목  <textarea rows="1" cols="94" readonly>${requestDetail.reqTitle}</textarea><br/><br/>
			
				<textarea rows="15" cols="100"readonly>${requestDetail.reqContent}</textarea> 
				
				
				
			<div class = "bottom">
				<c:if test="${sessionScope.sId eq requestDetail.reqId}">
					<div class ="item">
						<form action="http://localhost:8181/electronic_library/requestUpdateForm.do" method="post" >
							<input type="hidden" name="reqnum" value="${requestDetail.reqNum}"/>
							<input type="submit" value="수정하기" class = "text" />
						</form>
					</div>
					<div class = "item">
						<form action="http://localhost:8181/electronic_library/deleteBookRequest.do" method="post" >
							<input type="hidden" name="reqnum" value="${requestDetail.reqNum}"/>
							<input type="hidden" name="fid" value="${requestDetail.reqId}"/>
							<input type="submit" value="삭제하기" class = "text "/>
						</form>
					</div>
				</c:if>
				<c:if test="${requestDetail.reqStatus eq false}">
					<c:if test="${sUtype eq true}">
						<div class = "item">
							<form action="http://localhost:8181/electronic_library/requestPermission.do" method="post">
								<input type="hidden" name="reqnum" value="${requestDetail.reqNum}"/>
								<input type="hidden" name="reqstatus" value="${reqStatus}"/>
								<input type="hidden" name="bname" value="${requestDetail.bName}"/>
								<input type="hidden" name="bwriter" value="${requestDetail.bWriter}"/>
								<input type="hidden" name="bpub" value="${requestDetail.bPub}"/>
								<input type="hidden" name="bcategory" value="${requestDetail.bCategory}"/>
								<input type="submit" value="구매 허가" class = "text"/>
							</form>
						</div>
					</c:if>
				</c:if>
				
		
			</div>

	</div>
	
	
	
</body>
</html>