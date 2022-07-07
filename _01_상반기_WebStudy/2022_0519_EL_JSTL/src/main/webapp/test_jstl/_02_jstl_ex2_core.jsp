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
   <h2>JSP Scriptlet 이용</h2>
   <%
       for (int i = 1; i <= 5; i++){
   %>
   <p> 안녕! </p>
   <% 
       }//end-for
   %>
   
   <h2>JSTL 이용</h2>
   <h3>(1) 일반 for문 </h3>
   
   <h4>일반 for문 형태의 forEach 태그</h4>
   <c:forEach var = "i" begin = "1" end = "5" step = "1" varStatus = "loop">
       <c:if test="${ loop.count % 2 == 1 }">
           <p style = "color : red">안녕! 반복 ${ i }입니다!</p>
       </c:if>
       <c:if test="${ loop.count % 2 == 0 }">
           <p style = "color : blue">안녕! 반복 ${ i }입니다!</p>
       </c:if>
   </c:forEach>
   
   <h4>varStatus 속성 살펴보기</h4>
   <p>JSTL의 모든 값의 표현은 EL로 한다.</p>
   <c:forEach var = "i" begin = "1" end = "3" step = "1" varStatus = "loop">
       <p>count : ${ loop.count }</p>            <!-- count : 반복 횟수 -->
       <p>index : ${ pageScope.loop.index }</p>  <!-- index : 변화된 값 -->
       <p>current : ${ loop.current }</p> 
       <p>first : ${ loop.first }</p>
       <p>last : ${ loop.last }</p>
       <p>---------------------</p>
   </c:forEach>
   
   <h3>(2) 향상된 for문 </h3>
   
   <h4>향상된 for문 형태의 forEach 태그</h4>
   <%
      String[] rainbow = {"Red", "Orange", "Yellow", "Green", "Blue"};
   %>
   <c:forEach var = "c" items = "<%= rainbow %>">
      <span style = "color:${ c };">${ c }</span>
   </c:forEach>
   
   <h4>varStatus 속성 살펴보기</h4>
   <c:forEach var = "c" items = "<%= rainbow %>" varStatus = "loop">
       <p>count : ${ loop.count }</p>            <!-- count : 반복 횟수 -->
       <p>index : ${ pageScope.loop.index }</p>  <!-- index : 변화된 값 -->
       <p>current : ${ loop.current }</p> 
       <p>first : ${ loop.first }</p>
       <p>last : ${ loop.last }</p>
       <p>---------------------</p>
   </c:forEach>
   
</body>
</html>