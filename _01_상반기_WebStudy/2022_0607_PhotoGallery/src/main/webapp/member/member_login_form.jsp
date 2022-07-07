<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap 3.x -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
    #box{
       width : 300px;
       margin : auto;
       margin-top : 100px;
    }
</style>
<title>Insert title here</title>
<script type="text/javascript">
    function send(f){
    	
    	var m_id = f.m_id.value.trim();
    	var m_pwd = f.m_pwd.value.trim();
    	
    	if (m_id == ''){
    		alert("아이디를 입력하세요.");
    		f.m_id.focus();
    		return;
    	}
    	
    	if (m_pwd == ''){
    		alert("비밀번호를 입력하세요.");
    		f.m_pwd.focus();
    		return;
    	}
    	
    	f.action = "login.do"; //MemberLoginAction
    	f.submit();
    	
    }
</script>
<script type="text/javascript">
   $(document).ready(function(){
	   //0.1초 후에 showMessage 함수 호출
	   setTimeout(showMessage,100);
   });
   
   function showMessage(){
	   ///member/login_form.do?reason=fail_id
       //제이쿼리 $가 이미 있기 때문에, 문자열로 감싸 처리한다.
       //먼저 EL처리된 후 문자열로 변경 == 문자열값과 비교
	   if ("${ param.reason eq 'fail_id' }" == "true"){
		   alert('해당되는 아이디가 존재하지 않습니다.');
		   return;
	   }
	   
	   if ("${ param.reason eq 'fail_pwd' }" == "true"){
		   alert('비밀번호를 잘못 입력하셨습니다.');
		   return;
	   }
	   
	   if ("${ param.reason eq 'session_timeout' }" == "true"){
		   alert('인증이 만료되어 재로그인이 필요합니다.');
		   return;
	   }
   }
</script>
</head>
<body>
   <form>
      <div id = "box">
         <div class="panel panel-primary">
		    <div class="panel-heading"><h5>로그인</h5></div>
		    <div class="panel-body">
		       <table class = "table table-striped">
		           <tr>
		             <th>아이디</th>
		             <td><input name = "m_id" value = "${ param.m_id }"></td>
		           </tr>
		           <tr>
		             <th>비밀번호</th>
		             <td><input type = "password" name = "m_pwd"></td>
		           </tr>
		           <tr>
		             <td colspan = "2" align = "center">
		                <input type = "button" value = "로그인" onclick = "send(this.form);">
		                <input type = "button" value = "목록보기" onclick = "location.href = '../photo/list.do'">
		             </td>
		           </tr>
		       </table>
		    </div>
		 </div>    
      </div>
   </form>
</body>
</html>