<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //내장 객체 : session request out...
    String session_id = session.getId();
    out.print("JSP내 : "+session_id + "<br>");
    
    HttpSession session1 = request.getSession();
    String session_id1 = session1.getId();
    out.print("내가 : "+ session_id1 + "<br>");
    
    /* 
    <동일한 session>
    - JSP내 : C7DF15DC0C7B039CB0C44E118AFB3175
    - 내가 : C7DF15DC0C7B039CB0C44E118AFB3175 */
    
    //유효시간 지정
    session.setMaxInactiveInterval(60);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>