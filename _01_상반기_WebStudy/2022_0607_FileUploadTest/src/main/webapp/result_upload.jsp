<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
업로드 결과
<hr>
제목 : ${ requestScope.title }<br>
<!-- //실제 src은 http://localhost:9090/(생략)/update/${ filename } -->
<img src = "upload/${ filename }" width = "120"><br>
<a href = 'input_file.html'>다시하기</a>
</body>
</html>