<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취업하고 싶어서</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap" rel="stylesheet">
<link rel = "stylesheet" href = "css/main.css">
<link rel = "stylesheet" href = "css/main_menu.css">
<link rel = "stylesheet" href = "css/apply/currentApply.css">
<link rel = "stylesheet" href = "css/apply/monthlyApply.css">
<link rel = "stylesheet" href = "css/apply/recruitSites.css">
<link rel = "stylesheet" href = "css/tool/commonTool.css">
<link rel = "stylesheet" href = "css/login.css">
<link rel = "stylesheet" href = "css/register.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="js/header.js"></script>
</head>
<body>
   <div id = "main_box">
      <div id = "header">
       <%@include file = "header/header.jsp" %>
       <div id = "menu">
	         <%@include file = "menu/main_menu.jsp" %>
	   </div>
   	  </div>
	   <div id = "content_box">
	      <div id = "content">
	         <!-- 메인(홈) 콘텐츠/ 채용사이트 > 채용정보 확인/지원 -->
	         <c:if test = "${ (empty param.menu) or (param.menu == 'home') or (param.menu == 'recruitSites') }">
	            <%@include file = "content/apply/recruitSites.jsp" %>
	         </c:if>
	         
	         <!-- 회원 > 로그인 -->
	         <c:if test = "${ param.menu == 'login' }">
	            <%@include file = "content/registration/login.jsp" %>
	         </c:if>
	         <!-- 회원 > 회원가입 -->
	         <c:if test = "${ param.menu == 'register' }">
	            <%@include file = "content/registration/register.jsp" %>
	         </c:if>
	         
	         <!-- 마이지원함 > 전체 목록 -->
	         <!-- 마이지원함 > 월간 일정 -->
	         <c:if test = "${ param.menu == 'monthlyApply' }">
	            <%@include file = "content/apply/monthlyApply.jsp" %>
	         </c:if>
	         <!-- 마이지원함 > 이력서 모음 -->
	         
	         <!-- 유용한툴 > 글자수 세기 -->
	         <c:if test = "${ param.menu == 'countLetters' }">
	            <%@include file = "content/tool/countLetters.jsp" %>
	         </c:if>
	      </div>
      </div> <!-- end content_box -->
      <div id = "footer">
         <%@include file = "footer/footer.jsp" %>
      </div>
   </div> 
</body>
</html>