<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //                         key  value
    //                         name value
    Cookie cookie = new Cookie("A","A.jsp"); 

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
여기는 A.jsp
<a href = "B.jsp">여기를 누르면 B.jsp로 이동</a>
</body>
</html>