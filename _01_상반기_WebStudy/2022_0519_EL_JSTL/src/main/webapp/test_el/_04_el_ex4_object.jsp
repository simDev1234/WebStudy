<%@page import="vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    PersonVo p = new PersonVo("일길동",25,"010-111-2345");

    // requestScope 영역에 값을 넣기
    request.setAttribute("p", p);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
  PersonVo 출력하기
<hr>
이름 : ${ requestScope.p.name }<br>
나이 : ${ p.age }<br> <!-- p.getAge() call -->
전화 : ${ p['tel'] }<br>
</body>
</html>