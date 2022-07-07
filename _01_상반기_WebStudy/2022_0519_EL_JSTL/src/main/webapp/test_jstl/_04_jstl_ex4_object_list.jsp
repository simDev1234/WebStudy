<%@page import="java.util.ArrayList"%>
<%@page import="vo.PersonVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
    List<PersonVo> p_list = new ArrayList<PersonVo>();
    p_list.add(new PersonVo("일길동",20,"010-111-1234"));
    p_list.add(new PersonVo("이길동",21,"010-222-1234"));
    p_list.add(new PersonVo("삼길동",22,"010-333-1234"));
    p_list.add(new PersonVo("사길동",23,"010-444-1234"));
    p_list.add(new PersonVo("오길동",24,"010-555-1234"));
	
    pageContext.setAttribute("p_list",p_list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    td{ text-align:center }
</style>
</head>
<body>
   <table border = "1" cellspacing = "0" width = "500">
      <!-- 타이틀 부분 -->
	      <tr>
	        <th>번호</th>
	        <th>이름</th>
	        <th>나이</th>
	        <th>전화</th>
	      </tr>
      <!-- data -->
      <c:forEach var = "person" items = "${ p_list }" varStatus = "loop">
	      <tr>
	        <td>${ loop['count'] }</td>
	        <td>${ person.name }</td> <!-- vo.getName() 호출. **반드시 getter/setter가 있어야 가능 (or 500 에러)-->
	        <td>${ person.age }</td>
	        <td>${ person.tel }</td>
	      </tr>
      </c:forEach>
   </table>
</body>
</html>