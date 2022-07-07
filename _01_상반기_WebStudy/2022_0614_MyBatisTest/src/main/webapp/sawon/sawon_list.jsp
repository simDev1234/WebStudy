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
   <table class="table">
       <tr class = "success">
         <th>번호</th>
         <th>이름</th>
         <th>직위</th>
         <th>성별</th>
         <th>부서번호</th>
         <th>입사일자</th>
         <th>상사번호</th>
         <th>연봉</th>
       </tr>
       <!-- for(SawonVo vo : list) -->
       <c:forEach var = "vo" items = "${ list }" varStatus = "loop">
          <tr>
            <td>${ loop.count }</td>
            <td>${ vo.saname }</td>
            <td>${ vo.sajob }</td>
            <td>${ vo.sasex }</td>
            <td>${ vo.deptno }</td>
            <td>${ vo.sahire }</td>
            <td>${ vo.samgr }</td>
            <td>${ vo.sapay }</td>
          </tr>
       </c:forEach>
   </table>
</body>
</html>