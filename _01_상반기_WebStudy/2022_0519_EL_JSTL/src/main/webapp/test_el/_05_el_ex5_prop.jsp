<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //key,value형식으로 저장
    //문자열 위주로 저장
    Properties prop = new Properties();
    prop.put("name","홍길동");  //객체로 들어감
    prop.setProperty("age","30"); //String으로 들어감
    prop.setProperty("addr","서울시 마포구 노고산동");
    
    //EL로 출력하세요.
    request.setAttribute("prop",prop);
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h2>Properties 내 값 출력</h2>
   <p>name : ${ prop['name'] }</p>
   <p>age  : ${ prop['age'] }</p>
   <p>addr : ${ prop.addr }</p>
</body>
</html>