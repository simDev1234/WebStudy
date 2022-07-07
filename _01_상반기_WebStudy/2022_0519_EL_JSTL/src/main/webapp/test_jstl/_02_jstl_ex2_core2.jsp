<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
                        <%-- library가 외부에 있는 것이 아님. 형식일 뿐 --%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h2>JSTL 이용</h2>
   
   <h3>(1) if문</h3>
   <c:forEach var = "i" begin = "1" end = "5" step = "1" varStatus = "loop">
       <c:if test="${ loop.count % 2 == 1 }">
           <p style = "color : red">안녕! 반복 ${ i }입니다!</p>
       </c:if>
       <c:if test="${ loop.count % 2 == 0 }">
           <p style = "color : blue">안녕! 반복 ${ i }입니다!</p>
       </c:if>
   </c:forEach>
   
   <h3>(2) choose 문 (if-else문 처럼 사용)</h3>
   <c:choose>
       <c:when test="조건1">조건1을 만족하는 경우</c:when>
       <c:when test="조건2">조건2를 만족하는 경우</c:when>
       <c:otherwise>아무 조건도 만족하지 않는 경우</c:otherwise>
   </c:choose>

</body>
</html>