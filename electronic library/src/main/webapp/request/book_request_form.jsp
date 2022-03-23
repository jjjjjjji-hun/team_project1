<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 로그인 하지 않은 사용자가 폼에 접근시 리스트로 리다이렉트 -->
	<c:if test="${sId eq null}">
		<c:redirect url="http://localhost:8181/electronic_library/requestList.do"/>
	</c:if>

	<form action="http://localhost:8181/electronic_library/requestInsertFormToDB.do" method="post">
		<fieldset>
			<legend>희망 도서 신청하기</legend><br/>
				<label>국가선택</label>
				<select name= "fcountry">
					<option value="국내서">국내서</option>
					<option value="영미">영미</option>
					<option value="중국">중국</option>
					<option value="일본">일본</option>
					<option value="프랑스">프랑스</option>
					<option value="독일">독일</option>
				</select>
				
				<!-- 이거 밑에 일부러 쓴 것 맞습니다 ㅠ (위치를 이렇게 하고 싶다는 말) -->
				&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;			
					
				신청자 아이디 <input type="text" name="reqid" value=${sId} size=20 required/> <br/> <br/>
				<input type="text" name="fbname" placeholder="신청 도서 이름" size=40 required/> <br/>
				<input type="text" name="fbwriter" placeholder="저자" size=40 required/> <br/>
				<input type="text" name="fbpub" placeholder="출판사" size=40 required/> <br/>
				<input type="text" name="fbcategory" placeholder="카테고리" size=40 required/> <br/><br/>
				<textarea rows="1" cols="100" name="ftitle" placeholder="요청 제목을 입력하세요" required></textarea><br/><br/>
				<textarea rows="15" cols="100" name="fcontent" placeholder="요청 사유를 입력하세요" required></textarea> <br/><br/>
				<input type="reset" value="다시쓰기"/>
				<input type="submit" value="신청하기"/>

		</fieldset>
	</form><br/>

</body>
</html>