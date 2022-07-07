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
   <table border = "1" width = "800">
       <!-- title -->
       <tr>
         <th>사원번호</th>
         <th>사원명</th>
         <th>성별</th>
         <th>부서번호</th>
         <th>직급</th>
         <th>입사일</th>
         <th>담당자</th>
         <th>연봉</th>
       </tr>
       
       <!-- Data가 없는 경우 -->
       <c:if test = "${ empty list }">
	     <tr>
	         <td colspan="8">Data가 없습니다.</td>
	     </tr>
       </c:if>
       
       <!-- Data가 있는 경우 -->
       <c:forEach var = "vo" items = "${ list }">
         <tr>
             <td>${ vo.sabun }</td>  
	         <td>${ vo.saname }</td>
	         <td>${ vo.sasex }</td>
	         <td>${ vo.deptno }</td>
	         <td>${ vo.sajob }</td>
	         <td>${ vo.sahire }</td>
	         <td>${ vo.samgr }</td>
	         <td>${ vo.sapay }</td>
         </tr>
       </c:forEach>
   </table>
</body>
</html>