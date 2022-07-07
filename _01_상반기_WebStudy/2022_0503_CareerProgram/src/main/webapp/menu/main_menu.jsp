<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSTL Library 연결 -->
<%@taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <!-- Main Menu -->
   <ul id = "main_menu">
     <li>
        <h3 class = "menu_title">채용 사이트</h3>
	    <ul class = "menu_large">
	      <li><a href = "?menu=recruitSites">채용정보 확인/지원</a></li>
	    </ul>
     </li>
     <li>
        <h3 class = "menu_title">마이 지원함</h3>
	    <ul class = "menu_large">
	      <li><a href = "?menu=currentApply">지원 분석</a></li>
	      <li><a href = "?menu=monthlyApply">월간 일정</a></li>
	      <li><a href = "?menu=applications">이력서 모음</a></li>
	   </ul>
     </li>
     <li>
       <h3 class = "menu_title">유용한 툴</h3>
	   <ul class = "menu_large">
	      <li><a href = "?menu=countLetters">글자수 세기</a></li>
	      <li><a href = "#">연봉 계산기</a></li>
	   </ul>
     </li>
     <li>
       <h3 class = "menu_title">게시판</h3>
	   <ul class = "menu_large">
	      <li><a href = "#">정보 게시판</a></li>
	      <li><a href = "#">자유 게시판</a></li>
	   </ul>
     </li>
     <li>
       <h3 class = "menu_title">고객센터</h3>
	   <ul class = "menu_large">
	      <li><a href = "?menu=memberInfo">회원정보 수정</a></li>
	   </ul>
     </li>
   </ul>
</body>
</html>