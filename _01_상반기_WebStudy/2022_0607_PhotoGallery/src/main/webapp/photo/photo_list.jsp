<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap 3.x -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">
<style type="text/css">

   #box {
      width : 800px; 
      height : 100px;
      margin : auto;
      margin-top : 30px;
      font-family: 'Playfair Display', serif;
   }
   
   #title{
     text-align : center;
     color : #6667AB;
     font-weight : bold;
     text-shadow : 1px 1px 2px black;
   }
   
   #empty_msg{
     text-align : center;
     color : red;
   }
   
   #empty_msg > img { height : 500px; }
   
   #photo_box{
     width : 100%;
     height : 510px;
     border : 2px solid grey;
     overflow-y : scroll;
     box-sizing : border-box;
   }
   
   .photo{
     width   : 120px;
     height  : 210px;
     border  : 1px solid #ffcccc;
     margin  : 35px;
     margin-top : 20px;
     margin-bottom : 15px;
     padding : 10px;
     float   : left;
     box-sizing : border-box;
   }
   
   .photo:hover{
     border  : 1px solid #6667AB;
     box-sizing : border-box;
   }
   
   .photo > img{
     width   : 100px;
     height  : 100px;
     border  : 1px solid grey;
     outline : 1px solid black;
     box-sizing : border-box;
   }
   
   /* 멀티라인 글자수 제한 */
   /* https://junistory.blogspot.com/2017/06/css-ellipsis.html */
   .photo_class{
     border : 1px solid grey;
     margin-top : 5px;
     margin-bottom : 2px;
     padding : 3px;
     overflow : hidden;
     text-overflow : ellipsis;
     white-space:nowrap;
     box-sizing : border-box;
   }
</style>
<script type="text/javascript">

   var global_p_idx;

   function upload_photo(){
	   //로그인 여부 체크
	   //ㄴ로그인 하지 않은 상태 
	   if ("${ empty sessionScope.user }" == "true"){
		   if (confirm("로그인하신 후, 파일 업로드가 가능합니다.\n로그인 하시겠습니까?")==false){
			   return;
		   }else{
			   //로그인 폼으로 이동
			   location.href = "${ pageContext.request.contextPath }/member/login_form.do";
			   return;
		   }
	   }
	   
	   //ㄴ로그인된 경우
	   location.href = "insert_form.do"; //PhotoInsertFormAction
   }
   
   function download(p_filename){
	   //로그인 여부 체크
	   //ㄴ로그인 하지 않은 상태 
	   if ("${ empty sessionScope.user }" == "true"){
		   if (confirm("로그인하신 후, 파일 다운로드가 가능합니다.\n로그인 하시겠습니까?")==false){
			   return;
		   }else{
			   //로그인 폼으로 이동
			   location.href = "${ pageContext.request.contextPath }/member/login_form.do";
			   return;
		   }
	   }
	   
	  //ㄴ로그인된 경우
	  //파일 다운로드 서블릿 호출(다운로드 받을 파일명이 한글 또는 특수문자면 인코딩해서 전송해야한다. -- 웹 표준 맞추기 위해서)
	  //location.href = "../FileDownload.do?dir=/upload/&filename="+encodeURIComponent(p_filename, "utf-8");
	  location.href = "../FileDownload.do?dir=/upload/&filename="+encodeURIComponent(p_filename);
   }
   
   function photo_view(p_idx){
	   
	   //누른이미지의 p_idx값 전달
	   global_p_idx = p_idx;
	   
	   //화면중앙배치
	   center_photo_popup();
	   $("#photo_popup").show();
	   
	   //데이터 가져와서 세팅하기
	   $.ajax({
		   url  : 'photo_view.do', //PhotoViewAction
		   data : {'p_idx':p_idx},
		   dataType : 'json',
		   success  : function(res_data){
			   //팝업 윈도우 배치작업
			   //res_data = {'p_idx':20, 'p_subject':'제목', 'p_content':'내용', 'p_filename':'~~~'}
			   $("#img_photo").attr({'src':"../upload/"+res_data.p_filename});
			   $("#photo_subject").html(res_data.p_subject);
			   $("#photo_content").html(res_data.p_content);
			   $("#photo_regdate").html(res_data.p_regdate.substring(0,16));
			   
			   //수정/삭제 버튼의 사용유무
			   //     게시글의 주인인 경우                       관리자인 경우
			   if(('${ user.m_idx }' == res_data.m_idx) || ("${ user.m_grade eq '관리자'}"=="true")){
				   $("#photo_job").show();
			   }else{
				   $("#photo_job").hide();
			   }
		   },
		   error    : function(err){
			   alert(err.responseText);
		   }
	   });
	   
   }
   
   function center_photo_popup(){
	   
	   var w_width  = $(window).width();
	   var w_height = $(window).height();
	   
	   console.log(w_width, w_height);
	   
	   //popup 크기 구하기
	   var p_width = $("#photo_popup").width();
	   var p_height = $("#photo_popup").height();
	   
	   console.log(p_width, p_height);
	   
	   var left = w_width/2  - p_width/2;
	   var top  = w_height/2 - p_height/2;
	   
	   $("#photo_popup").css({'left':left, 'top':top});
	   $("#photo_popup").show();
	   
   }
   
   function hide_photo_popup(){	   
	   $("#photo_popup").hide();
   }
   
   //사진삭제
   function photo_delete(){
	   if (confirm(global_p_idx + "를 정말 삭제하시겠습니까?") == false) return;
	   //삭제하기
	   location.href = "delete.do?p_idx="+global_p_idx; //PhotoDeleteAction
       
	   if ("${ param.isDelete }"=="true"){
    	   alert("삭제되었습니다.");
       }else if ("${ param.isDelete }"=="false"){
    	   alert("이런, 문제가 발생하여 파일이 삭제되지 않았습니다. 다시 시도해보세요!");
       }
   }
   
   //사진수정
   function photo_modify(){
	   //수정폼 띄우기
	   location.href = "modify_form.do?p_idx="+global_p_idx; //PhotoModifyFormAction
   }
   
</script>
</head>
<body>
<!-- photo popup 추가 -->
<%@include file = "photo_popup.jsp" %>
<div id = "box">
   <h1 id = "title">: : : : : &nbsp;Photo Gallery&nbsp;  : : : : :</h1>
   
   <div style = "text-align : right">
     <!-- 로그인이 안 된 경우 -->
     <c:if test = "${ empty sessionScope.user }">
        <input type = "button" value = "로그인" onclick = "location.href='../member/login_form.do';">
        <input type = "button" value = "회원가입" onclick = "location.href='../member/insert_form.do';">
     </c:if>
     <!-- 로그인이 된 경우 -->
     <c:if test = "${ not empty sessionScope.user }">
        <b>${ user.m_name }님</b> 환영합니다.
        <input type = "button" value = "로그아웃" onclick = "location.href='../member/logout.do';">
     </c:if>
   </div>
   
   <div>
     <input type = "button" value = "사진올리기" onclick = "upload_photo();">
   </div>
   
   <div id = "photo_box">
      <!-- 데이터가 없는 경우 -->
	  <c:if test = "${ empty list }">
	      <div id = "empty_msg"><img src = "../image/no_data.png"></div>
	  </c:if>
	  
	  <!-- 데이터가 있는 경우 -->
	  <c:forEach var = "vo" items = "${ list }">
      	  <div class = "photo">
      	     <img src = "../upload/${ vo.p_filename }" onclick = "photo_view('${ vo.p_idx }');">
      	     <div class = "photo_class">${ vo.p_subject }</div>
      	     <div class = "photo_class">${ fn:substring(vo.p_regdate,0,10) }</div>
      	     <div>
      	        <input type = "button" value = "다운로드" onclick = "download('${ vo.p_filename }');">
      	     </div>
      	  </div>
      </c:forEach>
   </div>
</div>
</body>
</html>