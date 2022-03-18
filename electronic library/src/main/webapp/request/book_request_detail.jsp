<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	잘 들어왔나 확인
	${requestDetail}
	
	<h1>도서 요청 디테일</h1>
	
		<fieldset>
			글 번호 <input type="text" value="${requestDetail.reqNum}" name="reqnum" readonly> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
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
	

</body>
</html>