<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
	Map map = new HashMap();
	//        key       value
	map.put("driver", "oracle.jdbc.driver.OracleDriver");
	map.put("url"   , "jdbc:oracle:thin:@localhost:1521:xe");
	map.put("user"  , "scott");
	map.put("pwd"   , "tiger");
	
	// Map을 PageContext에 넣기 -> 왜? -> EL 사용
	pageContext.setAttribute("map", map);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
  EL을 이용한 Map Data 출력하기
<hr>
${ pageScope.map } <br>
Driver : ${ pageScope.map.driver }<br>
<%-- URL    : ${ pageScope.map.url } --%>
URL    : ${ map.url }<br>
USER   : ${ map['user'] }<br>
PWD    : ${ map["pwd"] }<br>
</body>
</html>