<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap 3.x -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- 제이쿼리 lib -->
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script type="text/javascript">

    /* textarea의 글자수를 세어주는 제이쿼리문 */
	$(document).ready(function() {
	    $('#content').on('keyup', function() {
	        $('#count').html("("+$(this).val().length+" / 200)");
	 
	        if($(this).val().length > 200) {
	            $(this).val($(this).val().substring(0, 200));
	            alert("최대 200글자까지만 입력 가능합니다.");
	            $('#count').html("(200 / 200)");
	        }
	    });
	});

    /* 글올리기 - form 전송 */
    function send(f){
    	//입력값 체크
    	var name = f.name.value.trim();
    	var content = f.content.value.trim();
    	var pwd = f.password.value.trim();
    	
    	if (name == ''){
    		alert('이름을 입력하세요.');
    		f.name.value = '';
    		f.name.focus();
    		return;
    	}
    	
    	if (content == ''){
    		alert('내용을 입력하세요.');
    		f.content.value = '';
    		f.content.focus();
    		return;
    	}
    	
    	if (pwd == ''){
    		alert('비밀번호를 입력하세요.');
    		f.password.value = '';
    		f.password.focus();
    		return;
    	}
    	
    	f.action = "insert.do"; // 대상 : VistInsertAction
    	f.submit(); //전송
    }
    
</script>
<style type="text/css">
    #box{ 
       width : 550px; 
       margin : auto;
       margin-top : 50px;
    }
    textarea{
       width : 100%;
       resize : none; /* 크기 변경 불가 */
    }
</style>
</head>
<body>
   <form>
      <div id = "box">
         <div class="panel panel-primary">
		      <div class="panel-heading"><h4>방명록쓰기</h4></div>
		      <div class="panel-body">
		         <table class = "table">
		            <tr>
		              <th width = "150">이름</th>
		              <td><input name = "name"></td>
		            </tr>
		            <tr>
		              <th>내용</th>
		              <td>
		                <textarea id = "content" name = "content" rows ="7" cols ="50"></textarea>
		                <div id = "count" align = "right">(0 / 200)</div>
		              </td>
		            </tr>
		            <tr>
		              <th>비밀번호</th>
		              <td><input type = "password" name = "password"></td>
		            </tr>
		            <tr>
		              <td colspan = "2" align = "center">
		                 <input class = "btn btn-primary" type = "button" value = "글올리기" onclick = "send(this.form);">
		                 <input class = "btn btn-success" type = "button" value = "목록보기" onclick = "location.href = 'list.do'">
		              </td>
		            </tr>
		         </table>
		      </div>
          </div>
      </div>
   </form>
</body>
</html>