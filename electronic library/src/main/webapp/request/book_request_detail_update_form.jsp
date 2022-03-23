<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 다른 사람이 작성한 수정폼에 들어오면 해당 리뷰 디테일로 리다이렉트 
	 주소창에 /requestUpdateForm.do 만 쳐서 들어오는 경우도 커버됨. -->
<c:if test="${sId ne requestDetail.reqId}">
	<c:redirect url="http://localhost:8181/electronic_library/requestList.do"/>
</c:if>
<!DOCTYPE html>
<html>
<head>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel= "stylesheet" href="${pageContext.request.contextPath}/css/bookReturn.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>도서 요청 디테일 수정 폼</h1>
	
	<fieldset>
		<form action="http://localhost:8181/electronic_library/requestUpdateFormToDB.do" method="post">
			글 번호 <input type="text" name="reqnum" value="${requestDetail.reqNum}" readonly> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			조회 수 ${requestDetail.hit} <br/><br/>
			신청일 <input type="text" value="${requestDetail.reqDate}" readonly>  &nbsp;
			수정일 <input type="text" value="${requestDetail.reqmDate}" readonly> &nbsp;
			신청자 <input type="text" name="reqid" readonly size=20 value="${requestDetail.reqId}"> <br/> <br/>
			제 목 &nbsp; <textarea rows="1" cols="94" name="ftitle">${requestDetail.reqTitle}</textarea><br/><br/>
			국가 분류	<select name= "fcountry">
						<option value="국내서">국내서</option>
						<option value="영미">영미</option>
						<option value="중국">중국</option>
						<option value="일본">일본</option>
						<option value="프랑스">프랑스</option>
						<option value="독일">독일</option>
					</select><br/>
			신청 도서 <input type="text" name="fbname" value="${requestDetail.bName}" size=40 /> <br/>
			도서 저자 <input type="text" name="fbwriter" value="${requestDetail.bWriter}" size=40 /> <br/>
			출 판 사&nbsp;&nbsp;&nbsp;<input type="text" name="fbpub" value="${requestDetail.bPub}" size=40 /> <br/>
			카테고리&nbsp;&nbsp;<input type="text" name="fbcategory" value="${requestDetail.bCategory}" size=40 /> <br/><br/>
			
			<textarea rows="15" cols="100" name="fcontent">${requestDetail.reqContent}</textarea> <br/><br/>
			
			<input type="reset" value="다시 수정하기"/>
			<input type="submit" value="수정 완료"/>

		
		</form>
	</fieldset>

</body>
</html>