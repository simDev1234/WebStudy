<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- //Presentation Logic ▼ -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
   #box{ width : 400px; margin : auto; }
   caption{text-align : center;}
</style>

</head>
<body>
   <div id = "box">
	   <table border = "1" width = "400" class="table .table-striped">
	      <caption>:::회원정보 결과:::</caption>
	      <tr>
	        <th>이름</th>
	        <td>${ requestScope.name }</td> <!-- 표현식 = 출력식 -->
	      </tr>
	      <tr>
	        <th>아이디</th>
	        <td>${ id }</td> 
	      </tr>
	      <tr>
	        <th>비밀번호</th>
	        <td>${ pwd_mask }</td> 
	      </tr>
	      <tr>
	        <th>성별</th>
	        <td>${ gender }</td> 
	      </tr>
	      <tr>
	        <th>혈액형</th>
	        <td>${ blood }</td> 
	      </tr>
	      <tr>
	        <th>친구</th>
	        <td>${ friend_list }</td> 
	      </tr>
	      <tr>
	        <th>취미</th>
	        <td>${ hobby_list }</td> 
	      </tr>
	      <tr>
	        <th>자기소개</th>
	        <td>${ profile }</td> 
	      </tr>
	      <tr>
	        <td colspan = '2'><a href = "member_input.html">다시하기</a></td> 
	      </tr>
	   </table>
   </div>
</body>
</html>