<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   #box{
      width : 400px;
      margin : auto;
      margin-top:50px;
   }
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">

   //점수체크 정규식
   var regular_jumsu = /^[0-9]{1,3}$/; //0~999
   
   function send(f){
	   var name = f.name.value.trim();
	   var kor = f.kor.value;
	   var eng = f.eng.value;
	   var mat = f.mat.value;
	   
	   if(name == ''){
		   alert('이름을 입력하세요.');
		   f.name.value = '';
		   f.name.focus();
		   return;
	   }
	   
	   //국어점수
	   if(regular_jumsu.test(kor)==false || kor > 100){
		   alert('0~100사이의 점수만 입력하세요');
		   f.kor.value = '';
		   f.kor.focus();
		   return;
	   }
	   
	   //영어점수
	   if(regular_jumsu.test(eng)==false || eng > 100){
		   alert('0~100사이의 점수만 입력하세요');
		   f.eng.value = '';
		   f.eng.focus();
		   return;
	   }
	   
	   //수학점수
	   if(regular_jumsu.test(mat)==false || mat > 100){
		   alert('0~100사이의 점수만 입력하세요');
		   f.mat.value = '';
		   f.mat.focus();
		   return;
	   }
	   
	   f.action = "insert.do"; //전송대상 : SungInsertActions
	   f.submit();
   }
   
</script>
</head>
<body>
   <div id = "box">
      <div class="panel panel-primary">
      <div class="panel-heading"><h4>:::::성적입력:::::</h4></div>
      <div class="panel-body">
         <table class = "table table-striped">
            <tr>
              <th>이름</th>
              <td><input name = "name"></td>
            </tr>
            <tr>
              <th>국어</th>
              <td><input name = "kor"></td>
            </tr>
            <tr>
              <th>수학</th>
              <td><input name = "mat"></td>
            </tr>
            <tr>
              <th>영어</th>
              <td><input name = "eng"></td>
            </tr>
            <tr>
              <td colspan = "2" align = "center">
                 <input class = "btn btn-primary" type = "button" value = "등록하기" onclick = "send(this.form);">
                 <input class = "btn btn-success" type = "button" value = "목록보기" onclick = "location.href = 'list.do'">
              </td>
            </tr>
         </table>
      </div>
    </div>
   </div>
</body>
</html>