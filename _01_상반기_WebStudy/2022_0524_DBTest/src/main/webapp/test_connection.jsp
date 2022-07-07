<%@ page import = "java.sql.Connection" %>
<%@ page import = "service.DBService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%! 
    int count = 0;
%>
<%
    Connection conn = DBService.getInstance().getConnection();
	System.out.printf("--success:%d--\n",count);
	count++;
	out.print(String.format("--success:%d--\n",count));
	
	//사용 후 반드시 닫아줘야 한다.
	conn.close();
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