<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
    #box{
       width  : 500px;
       margin : auto;
       margin-top : 50px;
    }
    
    textarea{
       width : 100%;
       height : 200px;
       resize : none;
    }
    
    /* #p_photo{
       color : transparent;
    } */
    
</style>
<script type="text/javascript">

	function send(f){
    	
    	var p_subject = f.p_subject.value.trim();
    	var p_content = f.p_content.value.trim();
    	/* var p_photo = f.p_photo.value; */
    	
    	if (p_subject == ''){
    		alert("제목을 입력하세요.");
    		f.p_subject.value = '';
    		f.p_subject.focus();
    		return;
    	}
    	
    	if (p_content == ''){
    		alert('내용을 입력하세요.');
    		f.p_content.value = '';
    		f.p_content.focus();
    		return;
    	}
    	
    	/* if (p_photo == ''){
    		alert('사진을 첨부하세요.');
    		return;
    	} */
    	
    	f.action = "modify.do";
    	f.submit();
    	
    }
    
    /* function file_change(){
    	var p_photo = $("#p_photo").val();
    	
    	if (p_photo == ''){
    		$("#p_photo_label").html(${ vo.p_filename });
    	}else{
    		var theSplit = p_photo.split('\\');
    		$("#p_photo_label").html(theSplit[theSplit.length-1]);
    	}
    } */
    
    //Ajax 파일 업로드
    function ajaxFileUpload() {
        // 업로드 버튼이 클릭되면 파일 찾기 창을 띄운다.
        $("#ajaxFile").click();
    }

    function ajaxFileChange() {
        // 파일이 선택되면 업로드를 진행한다.
        photo_upload();
    }
    
    function photo_upload() {

         //파일선택->취소시
         if( $("#ajaxFile")[0].files[0]==undefined)return;
                     
         var form = $("#ajaxForm")[0];
         var formData = new FormData(form);
         formData.append("p_idx", '${ vo.p_idx }');
         formData.append("photo", $("#ajaxFile")[0].files[0]);

         $.ajax({
               url : "photo_upload.do", //PhotoUploadAction
               type : "POST",
               data : formData,
               processData : false, //Get방식처럼 QueryString으로 보내지 않겠다는의미
               contentType : false, 
               /* 
                  contentType : default 값은 "application/x-www-form-urlencoded; charset=UTF-8", 
                                "multipart/form-data"로 전송되도록 false 설정. 
                                 명시적으로 "multipart/form-data"으로 설정해주면 boundary string이 안 들어가 제대로 동작하지 않는다.
                  boundary string : 브라우저에서 넣어주는 전송되는 데이터 영역을 구분해주는 구분자
               */
               dataType : 'json',   //보내는 데이터 타입이 아니라 서버에게 반환받을 데이터 타입. 
               success:function(result_data) {
                  //result_data = {"p_filename":"aaa.jpb"}
                   
                  //location.href=''; //자신의 페이지를 리로드(refresh)
                  
                  $("#my_img").attr("src","../upload/" + result_data.p_filename);
                  
               },
               error : function(err){
                  alert(err.responseText);
               }
     });
    }
</script>
</head>
<body>
   <!-- 파일 업로드용 폼 -->
   <form enctype="multipart/form-data" id="ajaxForm" method="post">
      <input type="file" id="ajaxFile" style="display:none;"  onChange="ajaxFileChange();" >
   </form>
   
   <form>
      <input type = "hidden" name = "p_idx" value = "${ vo.p_idx }">
      <div id = "box">
         <div class="panel panel-primary">
	       <div class="panel-heading"><h4>사진 수정하기</h4></div>
	       <div class="panel-body">
	          <table class = "table table-striped">
	              <tr>
	                <td colspan = "2" align = "center">
	                  <img id = "my_img" src = "../upload/${ vo.p_filename }" width = "80%">
	                  <br><br>
	                  <input type = "button" value = "사진수정" onclick = "ajaxFileUpload();">
	                </td>
	              </tr>
	              <tr>
	                <th>제목</th>
	                <td><input name = "p_subject" style = "width : 100%" value = "${ vo.p_subject }"></td>
	              </tr>
	              <tr>
	                <th>내용</th>
	                <td><textarea name = "p_content">${ vo.p_content }</textarea></td>
	              </tr>
	              <%-- <tr>
	                <th>사진</th>
	                <td>
	                   <input id = "p_photo" type = "file" name = "p_photo" onchange = "file_change()">
	                   <label id = "p_photo_label" for = "p_photo">${ vo.p_filename }</label>
	                </td>
	              </tr> --%>
	              <tr>
	                <td colspan = "2" align = "center">
	                  <input class = "btn btn-primary" type = "button" value = "수정하기" onclick = "send(this.form);">
	                  <input class = "btn btn-success" type = "button" value = "돌아가기" onclick = "location.href = 'list.do'">
	                </td>
	              </tr>
	          </table>
	       </div>
	     </div>
      </div>
   </form>
</body>
</html>