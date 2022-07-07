<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    System.out.println("--a.jsp 호출됨--");
    
    //Dispatcher(서버 내부에서 전송)
    //requestDispatcher -- interface
    //ㄴ Dispatcher 방식 또는 forward 방식 (동일 명칭)
    RequestDispatcher disp = request.getRequestDispatcher("b.jsp");
    //현재 a.jsp의 request, response 그대로 전달
    disp.forward(request, response);
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