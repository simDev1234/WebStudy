<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<% 

    List<String> seoul = new ArrayList<String>();

	seoul.add("강서구");
	seoul.add("강동구");
	seoul.add("강북구");
	seoul.add("강남구");
	
	List<String> busan = new ArrayList<String>();
	
	busan.add("해운대구");
	busan.add("사하구");
	busan.add("수영구");
	busan.add("남구");
	
	List<String> daegu = new ArrayList<String>();
	
	daegu.add("수성구");
	daegu.add("달서구");
	daegu.add("북구");
	daegu.add("중구");
	
	Map<String, List<String>> sidoMap = new HashMap<String, List<String>>();
	sidoMap.put("seoul",seoul);
	sidoMap.put("busan",busan);
	sidoMap.put("daegu",daegu);
	
	pageContext.setAttribute("sidoMap",sidoMap);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forEach를 사용해 테이블 내 테이블 만들기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
   div{ width : 800px; margin : auto; margin-top : 30px; font-size:16px;}
</style>
</head>
<body>
    <div>
	    <table border = "1" class="table table-bordered outer_table">
	       <tr>
	         <th>시</th>
	         <th>도</th>
	       </tr>
	       <!-- 바깥 for문 : 바깥 테이블의 행을 한 줄씩 만든다. -->
	       <!-- for (Entry sido : sidoMap) -->
	       <c:forEach var = "sido" items = "${ sidoMap }">
		       <tr>
		         <td>${ sido.key }</td>
		         <td>
		            <!-- 안쪽 for문 : 안쪽 테이블의 2번째 열에서, 새로운 테이블 형성 -->
		            <!-- for ( String sido_item : sido.value ) -->
		            <table>
		            <c:forEach var = "sido_item" items = "${ sido.value }">
			           <tr><td>${ sido_item }</td></tr>
		            </c:forEach>
		            </table>
		         </td>
		       </tr>
	       </c:forEach>
	    </table>
	</div>
</body>
</html>