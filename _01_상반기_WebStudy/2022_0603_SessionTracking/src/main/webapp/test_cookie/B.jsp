<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //                         key  value
    //                         name value
    Cookie cookie = new Cookie("B","B.jsp"); 
    
    //유효시간 설정
    cookie.setMaxAge(60);
    
    response.addCookie(cookie);
%>
<%@include file = "popup.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
여기는 B.jsp
<a href = "C.jsp">여기를 누르면 C.jsp로 이동</a>
</body>
</html>