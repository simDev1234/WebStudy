<!-- 헤더 : Encoding(전송시/현재페이지), , -->
<%@ page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
   //선언부
   //맴버변수
   int a = 10;

   //맴버메소드
   void sub(){
	   
   }
%>

<%
  //scriptlet : Java Code 작성
  //_jspService() 메소드 내에 코딩
  Random random = new Random();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
     for(int i = 0; i < 5; i++){
%>
        안녕 JSP야!! -> 반갑다! <br>
<% 
     }//end-for
%>
<% int x = 100; %>  <!-- scriptlet은 html 내부에도 쓸 수 있음 -->

<!-- 표현식 -->
a = <%= a %><br>
x = <%= x %>

<%
    for(int i = 0; i < 10; i++){
    	out.print(a + " ");
    }
%>

</body>
</html>