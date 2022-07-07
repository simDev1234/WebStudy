<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- BootStrap3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
   .title_style {
      display : inline-block;
      width : 400px;
   }
</style>
</head>
<body>
<table class = "table table-striped">
   <tr class = "success">
     <th>번호</th>
     <th>이미지</th>
     <th>상품명</th>
     <th>가격(최저가)</th>
     <th>가격(최고가)</th>
     <th>판매처</th>
   </tr>
   <c:forEach var = "vo" items = "${ list }" varStatus = "loop">
        <tr>
          <td>${ param.start+loop.index }</td>
          <td><img src = "${ vo.image }" width = "200px"></td>
          <td><a target="_blank" href = "${ vo.link }"><span class = "title_style">${ vo.title }</span></a></td>
          <td><fmt:formatNumber value = "${ vo.lprice }"/></td>
          <td><fmt:formatNumber value = "${ vo.hprice }"/></td>
          <td>${ vo.mallName }</td>
        </tr>
   </c:forEach>
</table>
</body>
</html>