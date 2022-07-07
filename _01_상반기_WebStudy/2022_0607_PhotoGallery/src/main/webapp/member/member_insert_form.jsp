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
<style type="text/css">
   #box{
      width : 700px;
      margin : auto;
      margin-top : 60px;
   }
   
   #id_msg{
      text-indent : 10px;
   }
</style>
<!-- Daum 우편번호 검색 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">

   var regular_id = /^[a-zA-Z0-9]{3,16}$/; 

   //문서 내 element의 배치가 완료가 되면 
   $(document).ready(function(){
	   //아이디 입력창에서 키가 입력되면 
	   //                  콜백함수(시스템에 의해 자동호출)
	   $("#m_id").keyup(function(event){
		   
		   var m_id = $(this).val();

           //console.log(m_id);
           
           if(regular_id.test(m_id)==false){
        	   $("#id_msg").html("영문자 및 숫자로 3~16자리만 가능합니다").css("color","red");
        	   $("#btn_register").attr("disabled",true);
        	   return;
           }
           
           //$("#id_msg").html("정규식 만족합니다").css("color","blue");
           
           //서버에 사용 가능 여부를 확인(jQuery Ajax)
		   $.ajax({
			   url      : 'check_id.do',     //MemberCheckIdAction
			   data     : {'m_id' : m_id},   //parameter : check_id.do?m_id = one
			   dataType : 'json',
			   success  : function(res_data){
				   //res_data = {"result" : true}  -- 사용가능
				   //res_data = {"result" : false} -- 사용중(사용 못함)
				   if (res_data.result){
					   $("#id_msg").html("사용 가능한 아이디입니다").css("color","blue");
					   $("#btn_register").attr("disabled",false);
				   }else{
					   $("#id_msg").html("이미 사용중인 아이디입니다").css("color","red");
					   $("#btn_register").attr("disabled",true);
				   }
			   },
			   error    : function(err){
				   alert(err.responseText);
			   }
		   });
           
	   });
   });
   
   //주소찾기 
   //카카오 주소찾기 api : https://postcode.map.daum.net/guide
   function find(){
	   var width = 500; //팝업의 너비
	   var height = 600; //팝업의 높이
	   
	   new daum.Postcode({
		    width: width, //생성자에 크기 값을 명시적으로 지정해야 합니다.
            height: height,
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            //         json방식으로 되어 있다.
	            // data = {'zonecode' : 12345, 'address' : '경기 성남시...','roadAddress':'','jibunAddress':''}
	            
	            // 선택된 주소의 우편번호 넣기
	            $("#m_zipcode").val(data.zonecode);
	            $("#m_addr").val(data.address);
	        }
	    }).open(
	    	//중앙에 띄우겠다.
	    	{
	    	    left: (window.screen.width / 2) - (width / 2),
	            top: (window.screen.height / 2) - (height / 2)
	        }
	    );
   }
   
   function send(f){
	   
	   //입력값 체크 (이름, 비번, 우편번호, 주소)
	   var m_name = f.m_name.value.trim();
	   var m_pwd  = f.m_pwd.value.trim();
	   var m_zipcode = f.m_zipcode.value.trim();
	   var m_addr = f.m_addr.value.trim();
	   
	   //이름 입력여부 체크
	   if (m_name == ''){
		   alert('이름을 입력하세요');
		   f.m_name.value = '';
		   f.m_name.focus();
		   return;
	   }
	   
	   //비밀번호 입력여부 체크
	   if (m_pwd == ''){
		   alert('비밀번호를 입력하세요');
		   f.m_pwd.value = '';
		   f.m_pwd.focus();
		   return;
	   }
	   
	   //우편번호 입력여부 체크
	   if (m_zipcode == ''){
		   alert("우편번호를 입력하세요");
		   f.m_zipcode.value = '';
		   f.m_zipcode.focus();
		   return;
	   }
	   
	   //주소 입력여부 체크
	   if (m_addr == ''){
		   alert("주소를 입력하세요");
		   f.m_addr.value = '';
		   f.m_addr.focus();
		   return;
	   }
	   
	   f.action = 'insert.do';
	   f.method = 'GET';
	   f.submit();
   }
</script>
</head>
<body>
<%-- RootContext 경로 : ${ pageContext.request.contextPath }<br> --%>
   <form>
      <div id = "box">
         <div class="panel panel-primary">
           <div class="panel-heading"><h4>회원가입</h4></div>
           <div class="panel-body">
              <table class = "table table-striped">
                  <tr>
                    <th>이름</th>
                    <td><input name = "m_name"></td>
                  </tr>
                  <tr>
                    <th>아이디</th>
                    <td>
                      <input name = "m_id" id = "m_id">
                      <span id = "id_msg"></span>
                    </td>
                  </tr>
                  <tr>
                    <th>비밀번호</th>
                    <td><input type = "password" name = "m_pwd"></td>
                  </tr>
                  <tr>
                    <th>우편번호</th>
                    <td>
                      <input id = "m_zipcode" name = "m_zipcode">
                      <input type = "button" value = "주소찾기" onclick = "find();">
                    </td>
                  </tr>
                  <tr>
                    <th>주소</th>
                    <td><input id = "m_addr" name = "m_addr" size = "60"></td>
                  </tr>
                  <tr>
                    <td colspan = "2" align = "center">
                       <!-- 아이디 중복 확인해서 성공할 경우에만 '가입하기' 버튼 노출 할 것 >> 최초에는 disabled 처리 -->
                       <input class = "btn btn-primary" type = "button" value = "가입하기" id = "btn_register" disabled = "disabled" onclick = "send(this.form);">
                       <input class = "btn btn-success" type = "button" value = "목록보기" onclick = "location.href = '${ pageContext.request.contextPath }/photo/list.do'">
                    </td>
                  </tr>
              </table>
           </div>
         </div>
      </div>
   </form>
</body>
</html>