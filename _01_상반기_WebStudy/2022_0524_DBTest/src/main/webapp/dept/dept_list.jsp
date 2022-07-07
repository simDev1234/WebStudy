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
   <table border = "1" width = "400">
       <!-- title -->
       <tr>
         <th>부서번호</th>
         <th>부서명</th>
         <th>위치</th>
       </tr>
       
       <!-- Data가 없는 경우 -->
       <c:if test = "${ empty list }">
       <tr>
         <td colspan="3">Data가 없습니다.</td>
       </tr>
       </c:if>
       
       <!-- Data가 있는 경우 -->
       <!-- for(DeptVo vo : list) 동일함 -->
       <c:forEach var = "vo" items = "${ requestScope.list }">
         <tr>
             <!-- jsp안에서의 임시 변수는 pageScope안에 들어간다. -->
	         <td>${ pageScope.vo.deptno }</td>  <!-- vo의 deptno를 getter로 가져온다. -->
	         <td>${ vo.dname }</td>
	         <td>${ vo['loc'] }</td>
         </tr>
       </c:forEach>
   </table>
</body>
</html>