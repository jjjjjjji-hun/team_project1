<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/bookDetail.css">


<meta charset="UTF-8">
<title>도서 상세 페이지</title>
</head>
<body>
	<div class= "bookDetail">
	<!-- 검색된 도서 최종 확인 페이지 -->
	
		<div class = "header">
			<h1>'${bName.bName }' 책 검색 결과</h1>
		
			<div class = "right">
				<div class = "listContainer">
					<a href="http://localhost:8181/electronic_library/usermyinfo" class = "item">
						<div class="text">마이페이지</div>
					</a>
					<a href="http://localhost:8181/electronic_library/book/book_search.jsp" class = "item">
							<div class="text">검색창으로</div>
					</a>
				</div>
			</div>
		</div>
		<hr/>
   	 		<table class="table table-hover">
		
			<thead>
				<tr>
					<th>도서 번호</th>
					<th>도서명</th>
					<th>저자</th>
					<th>출판사</th>
					<th>카테고리</th>
					<th>대여 상태</th>
					<th>대여하기</th>
				</tr>
			</thead>
			<tbody>
					<tr>
						<td>${bName.bNum}</td>
						<td>${bName.bName}</td>
						<td>${bName.bWriter}</td>
						<td>${bName.bPub}</td>
						<td>${bName.bCategory}</td>
						<td>
							<c:choose>
								<c:when test="${bName.checkOut eq false}">
									대여 가능
								</c:when>
								<c:otherwise>
									대여 불가능
								</c:otherwise> 
							</c:choose>
						</td>
						<td>
							<c:if test="${bName.checkOut eq false}">
								<c:if test="${user.counting < 5 }">
	    							<form action="http://localhost:8181/electronic_library/rentCheck.do" method="post">
	    								<input type="hidden" value="${bName.bNum }" name="bnum"/>
	    								<input type="hidden" value="${bName.checkOut }" name="checkout"/>
	    								<input type="hidden" value="${bName.bName }" name="bname"/>
	    								<!-- <input type="hidden" value="${user.counting }" name="user"/> -->
	    								<input type="submit" value="대여">
	    							</form>
	    						</c:if>
	    						<c:if test="${user.counting >=5 }">
	    							대여 횟수 초과
	    						</c:if>
							</c:if>
						</td>
					</tr>
			</tbody>
			</table><br/>

		<a href="javascript:history.back();" class = "item">
		<div class="text">뒤로가기</span> </div>
		</a>
	</div>

</body>
</html>