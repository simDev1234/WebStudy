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
<img src = "upload2/${ filename1 }" width = "120"><br>
<img src = "upload2/${ filename2 }" width = "120"><br>
ip  : ${ requestScope.ip }<br>
<a href = 'input_file2.html'>다시하기</a>
</body>
</html>