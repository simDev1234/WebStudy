<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
   <table>
      <tr>
        <th>이름</th>
        <th>닉네임</th>
        <th>나이</th>
        <th>전화</th>
        <th>집전화</th>
      </tr>
      <c:forEach var = "vo" items = "${ list }">
        <tr>
	        <td>${ vo.name }</td>
	        <td>${ vo.nickname }</td>
	        <td>${ vo.age }</td>
	        <td>${ vo.tel }</td>
	        <td>${ vo.hometel }</td>
        </tr>
      </c:forEach>
   </table>
</body>
</html>