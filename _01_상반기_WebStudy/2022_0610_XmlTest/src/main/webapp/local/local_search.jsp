<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- BootStrap3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<table class = "table table=striped">
   <tr class = "success">
     <th>번호</th>
     <th>위치명</th>
     <th>도로주소</th>
     <th>연락처</th>
     <th>거리</th>
     <th>위도</th>
     <th>경도</th>
     <th>지도보기</th>
   </tr>
   <c:forEach var = "vo" items = "${ list }" varStatus = "loop">
     <tr>
       <td>${ start + loop.index }</td>
       <td><a href = "${ vo.place_url }" target = "_blank">${ vo.place_name }</a></td>
       <td>${ vo.road_address_name }</td>
       <td>${ vo.phone }</td>
       <td>${ vo.distance }m</td>
       <td>${ fn:substring(vo.latitude,0,8) }</td>
       <td>${ fn:substring(vo.longitude,0,9) }</td>
       <td>
          <input type="button" value="길찾기" 
                         onclick="location.href='http://map.daum.net/link/to/${vo.place_name},${vo.latitude },${ vo.longitude }'">
          <input type="button" value="지도보기"
                     onclick="location.href='local/map_view.jsp?latitude=${vo.latitude}&longitude=${ vo.longitude }'">
       </td>
     </tr>
   </c:forEach>
</table>
</body>
</html>