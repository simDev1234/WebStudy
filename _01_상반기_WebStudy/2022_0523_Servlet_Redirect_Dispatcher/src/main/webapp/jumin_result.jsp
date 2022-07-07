<%@page import="myutil.Jumin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
   #box{ width : 400px; margin : auto; }
   td{padding-left : 20px; padding-right : 20px;}
</style>
</head>
<body>
   <div id = "box">
	   <table border = '1' cellspacing = '0' class="table .table-striped">
	     <c:if test="${ bValid eq false }">
	         <tr style = 'text-align : center;'>
		       <td>
		          유효하지 않은 주민번호입니다.
		       </td>
		     </tr>
	     </c:if>
	     <c:if test="${ bValid eq true }">
		     <tr>
		       <th>주민번호</th>
		       <td>${ jumin_no }</td>
		     </tr>
		     <tr>
		       <th>출생년도</th>
		       <td>${ jumin_year }( ${ jumin_ganji } )</td>
		     </tr>
		     <tr>
		       <th>나이</th>
		       <td>${ jumin_age }</td>
		     </tr>
		     <tr>
		       <th>성별</th>
		       <td>${ jumin_gender }</td>
		     </tr>
		     <tr>
		       <th>띠</th>
		       <td>${ jumin_tti }</td>
		     </tr>
		     <tr>
		       <th>출생계절</th>
		       <td>${ jumin_season }</td>
		     </tr>
		     <tr>
		       <th>출생지역</th>
		       <td>${ jumin_local }</td>
		     </tr>
		     <tr style = 'text-align : center;'>
		       <td colspan = '2'>
		          <input type = "button" value = "다시하기" onclick = "location.href='jumin.html';">
		       </td>
		     </tr>
	     </c:if>
	   </table>
   </div>
</body>
</html>