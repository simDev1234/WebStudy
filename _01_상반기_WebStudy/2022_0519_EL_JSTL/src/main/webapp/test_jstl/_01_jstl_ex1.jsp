<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL Library 연결 -->
<%@ taglib prefix = "c"   uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn"  uri = "http://java.sun.com/jsp/jstl/functions"%>
<%
    /*
        JSTL(JSP Standard Tag Library) 
        1. core <c:>   : if, choose, forEach
        2. fmt  <fmt:> : 숫자, 날짜
        3. fn   <fn:>  : 문자열기능(substring, indexOf, length....)
    
    */
    
    //숫자
    int money = 1234500000;
        
    //날짜
    Date today = new Date(); //현재 시스템 날짜를 구한다.
    
    //문자열 날짜
    String str_date = "2022-05-18 15:42:30.0";
    
    //pageContext에 넣기
    //                               Object타입
    pageContext.setAttribute("money",money); //int -> Integer로 autoboxing되어 들어감
    pageContext.setAttribute("today",today);
    pageContext.setAttribute("str_date",str_date);
        
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- JSTL 내에서 사용되는 값은 EL 표현식으로 값을 표현 -->
	<h2>각 국가별 통화단위</h2>                  <!-- $ 앞에 공백 띄면 에러난다.  -->
	<p>내가 소유한 현금 : <fmt:formatNumber value = "${ money }" type = "currency"/></p>
	
	<h2>각 국가별 통화단위</h2>
	<p>한국 : <fmt:setLocale value = "ko_kr"/><fmt:formatNumber value = "${ money }" type = "currency"/></p>
	<p>일본 : <fmt:setLocale value = "ja_jp"/><fmt:formatNumber value = "${ money }" type = "currency"/></p>
	<p>미국 : <fmt:setLocale value = "en_us"/><fmt:formatNumber value = "${ money }" type = "currency"/></p>
	
	<h2>JSTL 날짜 출력</h2>
	<p><fmt:formatDate pattern = "yyyy년-MM월-dd일 hh:mm:ss" value = "${ today }"/></p>
	
	<h2>JSTL 문자열 잘라내기</h2>
	<p>${ str_date }</p>
	<p>${ fn:substring(str_date,0,16) }</p>
	
	
</body>
</html>