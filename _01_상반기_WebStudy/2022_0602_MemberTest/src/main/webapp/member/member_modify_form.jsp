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
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script type="text/javascript">
   
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
		   Swal.fire({
			   icon: 'error',
			   title: '이름을 입력하세요',
			   text: '수정할 이름이 비어있습니다',
			   didClose:function(){
				   f.m_name.value = '';
				   f.m_name.focus();
			   }
		   }); 
		   return;
	   }
	   
	   //비밀번호 입력여부 체크
	   if (m_pwd == ''){
		   //alert('비밀번호를 입력하세요');
		   Swal.fire({
			   icon: 'error',
			   title: '비밀번호 입력하세요',
			   text: '수정할 비밀번호가 비어있습니다',
			   didClose:function(){
				   f.m_pwd.value = '';
				   f.m_pwd.focus();
			   }
		   }) 
		   return;
	   }
	   
	   //우편번호 입력여부 체크
	   if (m_zipcode == ''){
		   //alert("우편번호를 입력하세요");
		   Swal.fire({
			   icon: 'warning',
			   title: '우편번호를 입력하세요',
			   text: '수정할 우편번호가 비어있습니다',
			   didClose:()=>{
				   f.m_zipcode.value = '';
				   f.m_zipcode.focus();
			   }
		   }) 
		   
		   return;
	   }
	   
	   //주소 입력여부 체크
	   if (m_addr == ''){
		   alert("주소를 입력하세요");
		   f.m_addr.value = '';
		   f.m_addr.focus();
		   return;
	   }
	   
	   //컨펌 메세지
	   Swal.fire({
		  title: '정말 수정 하시겠습니까?',
		  html: "<h5>수정 후 이 작업을 돌이킬 수 없습니다.</h5>",
		  icon: 'question',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: '수정하기',
		  cancelButtonText : '취소하기'
		}).then((result) => {
			
	      //[수정하기] 버튼을 누르면
		  if (result.isConfirmed) {
			
			  f.action = 'modify.do'; //MemberModifyAction
			  f.method = 'GET';
			  f.submit();
			  
		  }
	      
		})
	   
   }
</script>
<script type="text/javascript">

    //현재 Element가 배치완료되면 자동 호출
    $(document).ready(function(){
    	
    	//수정폼에 원래 회원등급을 설정
    	$("#m_grade").val('${ vo.m_grade }');
    	
    });
    
</script>
</head>
<body>
   <form>
      <input type = "hidden" name = "m_idx" value = "${ vo.m_idx }">
      <div id = "box">
         <div class="panel panel-primary">
           <div class="panel-heading"><h4>회원수정</h4></div>
           <div class="panel-body">
              <table class = "table table-striped">
                  <tr>
                    <th>이름</th>
                    <td><input name = "m_name" value = "${ vo.m_name }"></td>
                  </tr>
                  <tr>
                    <th>아이디</th>
                    <td>
                      <input name = "m_id" value = "${ vo.m_id }" readonly = "readonly">
                    </td>
                  </tr>
                  <tr>
                    <th>비밀번호</th>
                    <td><input type = "password" name = "m_pwd" value = "${ vo.m_pwd }"></td>
                  </tr>
                  <tr>
                    <th>우편번호</th>
                    <td>
                      <input id = "m_zipcode" name = "m_zipcode" value = "${ vo.m_zipcode }">
                      <input type = "button" value = "주소찾기" onclick = "find();">
                    </td>
                  </tr>
                  <tr>
                    <th>주소</th>
                    <td><input id = "m_addr" name = "m_addr" size = "60" value = "${ vo.m_addr }"></td>
                  </tr>
                  <tr>
                    <th>등급</th>
                    <td>
                      <select name = "m_grade" id = "m_grade">
                         <option value = "일반">일반</option>
                         <option value = "관리자">관리자</option>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <td colspan = "2" align = "center">
                       <input class = "btn btn-primary" type = "button" value = "수정하기" onclick = "send(this.form);">
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