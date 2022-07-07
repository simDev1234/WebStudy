<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL Library 연결 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href = "css/main.css">
<link rel = "stylesheet" href = "css/main_menu.css">
<link rel = "stylesheet" href = "css/sub_menu.css">
</head>
<body>
   <div id = "main_box">
      <div id = "header">
         <!-- 외부 파일을 포함 -->
         <%@include file = "header/header.jsp"%> 
      </div>
      <div id = "aside">
         <%@include file = "menu/sub_menu_company.jsp"%>
      </div>
      <!-- 
         main_company.jps?menu=intro
         main_company.jps?menu=history
         main_company.jps?menu=location
       -->
      <!-- JSTL의 if문을 이용해서 분류
        조건식 EL(Expression Language : 표현언어) : ${ 값 }
	  -->
      <div id = "content">
                 <!-- (empty param.menu) : null -->
         <c:if test="${ (empty param.menu) or (param.menu == 'intro') }">
            <%@include file = "content/company/intro.jsp" %>
         </c:if>
         <c:if test="${ param.menu == 'history' }">
            <%@include file = "content/company/history.jsp" %>
         </c:if>
         <c:if test="${ param.menu == 'location' }">
            <%@include file = "content/company/location.jsp" %>
         </c:if>
      </div>
      <div id = "footer">
         <%@include file = "footer/footer.jsp" %>
      </div>
   </div>
</body>
</html>