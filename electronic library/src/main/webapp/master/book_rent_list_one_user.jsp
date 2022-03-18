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

    <h1> ${uId}님의 대여 목록입니다.</h1>
    
    <table border="1">
        <theader>
            <th>대여 번호</th>
            <th>대출일</th>
            <th>반납일</th>
            <th>반납 예정일</th>
            <th>책 번호</th>
            <th>책 이름</th>
            <th>아이디</th>
            <th>대출 여부</th>
            <th>연체 여부</th>
        </theader>
        <tbody>
            <c:forEach var="user" items="${rentalList}">
                <tr>
                    <td>${user.rentNum }</td>
                    <td>${user.rentDate}</td>
                    <td>${user.returnDate}</td>
                    <td>${user.returnSchedule}</td>
                    <td>${user.bNum}</td>
                    <td>${user.bName}</td>
                    <td>${user.uId}</td>
                    <td>
                        <c:choose>
                            <c:when test="${user.checkOut eq true}">
                                    대여 중
                            </c:when>
                            <c:otherwise>
                                    반납 완료
                            </c:otherwise> 
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${user.overdue eq true}">
                                    연체
                            </c:when>
                            <c:otherwise>
                                    미연체
                            </c:otherwise> 
                        </c:choose></td>
                </tr>
            </c:forEach>
        </tbody>
    
    </table><br/>
    
    <button><a href="http://localhost:8181/electronic_library/userlist">뒤로 가기</a></button>

</body>
</html>