<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class = "headbox">
      <a id = "hamberger" onclick = "showMenu()" href = "#"><img alt="메뉴" src="image/menu.png"></a>
      <h1 id = "logo"><a href = "?menu=home">취업하고 싶어서</a></h1>
      <div class = "headbuttons">
         <button type="button" class="btn btn-primary" onclick="location.href='?menu=login';">로그인</button>
         <button type="button" class="btn btn-default" onclick="location.href='?menu=register';">회원가입</button>
      </div>
   </div>
</body>
</html>