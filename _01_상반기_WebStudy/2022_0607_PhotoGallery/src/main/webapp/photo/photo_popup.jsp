<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
   #photo_popup{
      width   : 300px;
      padding : 10px;
      border  : 2px solid white;
      position : absolute;
      left : 400px;
      top  : 100px;
      background : #222222;
      color : white;
      display : none;
   }
   #photo_popup img{
      width : 273px;
      height : 280px;
      border : 1px solid gray;
      outline : 1px solid black;
      margin : 2px;
   }
   #photo_subject{
      width : 98%;
      margin : 3px;
      padding : 3px;
      border : 1px solid grey;
      min-height : 40px;
      outline : 1px 1px 1px black;
      text-align : left;
   }
   #photo_content{
      width : 98%;
      margin : 3px;
      padding : 3px;
      border : 1px solid grey;
      min-height : 40px;
      outline : 1px 1px 1px black;
      text-align : left;
   }
   #photo_job{
      text-align : center;
      display : none;
   }
</style> 
</head>
<body>
   <div id = "photo_popup">
      <div style = "text-align:right">
         <span id = "photo_regdate"></span>
         <input type = "button" value = "x" onclick = "hide_photo_popup()">
         <img id = "img_photo">
         <div id = "photo_subject">제목</div>
         <div id = "photo_content">내용</div>
         <div id = "photo_job">
            <input class = "btn btn-primary" type = "button" value = "수정" onclick = "photo_modify();">
            <input class = "btn btn-danger"  type = "button" value = "삭제" onclick = "photo_delete();">
         </div>        
      </div>
   </div>
</body>
</html>