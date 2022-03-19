<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 
	잘 들어왔나 확인 ${requestDetail} <hr/>

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
	
	
	<h1>도서 요청 디테일</h1>
		<fieldset>
			요청 상태 <input type="text" value="${reqStatus}"/><br/><br/>			
			
			글 번호 <input type="text" value="${requestDetail.reqNum}" name="reqnum" readonly> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			조회 수 ${requestDetail.hit} <br/><br/>
			신청일 <input type="text" value="${requestDetail.reqDate}" readonly>  &nbsp;
			수정일 <input type="text" value="${requestDetail.reqmDate}" readonly> &nbsp;
			신청자 <input type="text" name="reqid"  readonly size=20 value=${requestDetail.reqId}> <br/> <br/>
			제 목 &nbsp; <textarea rows="1" cols="94" readonly>${requestDetail.reqTitle}</textarea><br/><br/>
			국가 분류 <input type="text" value="${requestDetail.country}" size=40 readonly/> <br/>
			신청 도서 <input type="text" value="${requestDetail.bName}" size=40 readonly/> <br/>
			도서 저자 <input type="text" value="${requestDetail.bWriter}" size=40 readonly/> <br/>
			출 판 사&nbsp;&nbsp;&nbsp;<input type="text"value="${requestDetail.bPub}" size=40 readonly/> <br/>
			카테고리&nbsp;&nbsp;<input type="text"value="${requestDetail.bCategory}" size=40 readonly/> <br/><br/>
			
			<textarea rows="15" cols="100"readonly>${requestDetail.reqContent}</textarea> <br/><br/>

		</fieldset><br/>
		
	<a href="http://localhost:8181/electronic_library/requestUpdateForm.do?reqnum=${requestDetail.reqNum}"><button>수정하기</button></a>
	<a href="http://localhost:8181/electronic_library/deleteBookRequest.do?reqnum=${requestDetail.reqNum}"><button>삭제하기</button></a> <br/><br/>
	
	<a href="http://localhost:8181/electronic_library/"><button>메인 화면으로</button></a>
	
	<c:if test="${sUtype eq true}">
		<form action="http://localhost:8181/electronic_library/requestPermission.do" method="post">
			<input type="hidden" name="reqnum" value="${requestDetail.reqNum}"/>
			<input type="hidden" name="reqstatus" value="${reqStatus}"/>
			<input type="hidden" name="bname" value="${requestDetail.bName}"/>
			<input type="hidden" name="bwriter" value="${requestDetail.bWriter}"/>
			<input type="hidden" name="bpub" value="${requestDetail.bPub}"/>
			<input type="hidden" name="bcategory" value="${requestDetail.bCategory}"/>
			<input type="submit" value="구매 허가"/>
		</form>
	</c:if>
	

</body>
</html>