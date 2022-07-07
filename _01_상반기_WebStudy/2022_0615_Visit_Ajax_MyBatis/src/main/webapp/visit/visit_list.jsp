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
<style type="text/css">

   #box{ 
      width  : 500px; 
      margin : auto;
      margin-top : 10px;
   }
   
   #title{
      font-weight : bold;
      font-size : 30px;
      font-family : 휴먼옛체, 굴림체, 돋움체;
      text-align : center;
      color : #3366ff;
      text-shadow : 1px 1px 1px black;
   }
   
   .submit{
      margin-top : 10px;
      margin-bottom : 10px;
      text-align : right;
   }
   
   .content_type{
      padding : 5px;
      min-height : 60px;
      border : 1px solid grey;
      box-shadow : -1px -1px 1px #555555;
      text-shadow : none;
      color : black;
   }
   
</style>
<script type="text/javascript">

    function del(f){ //f = this.form
    	
    	var idx = f.idx.value; //게시물 번호
        var c_pwd = f.c_pwd.value.trim(); //입력한 비번
        
        if (c_pwd == ''){
        	alert("삭제할 게시물의 비밀번호를 입력하세요.");
        	f.c_pwd.value = '';
        	f.c_pwd.focus();
        	return;
        }
        
        //jQuery Ajax
        $.ajax({
        	url      : 'check_pwd.do', //VisitCheckPasswordAction
        	data     : {'idx':idx, 'c_pwd' : c_pwd},
        	dataType : 'json',
        	success  : function(res_data){
        		//비밀번호 맞은 경우 : res_data = {"result" : true}
        		//비밀번호 틀린 경우 : res_data = {"result" : false}
        		if (res_data.result == false){
        			alert('비밀번호가 틀립니다.');
        			return;
        		}
        		
        		if (confirm('정말 삭제하시겠습니까?')==false) 
        			return;
        		
        		//삭제 수행
        		location.href = 'delete.do?idx='+idx;
        	},
        	error    : function(err){
        		alert(err.responseText);
        	}
        });
        
    }
    
    function modify(f){
    	var idx = f.idx.value; //게시물 번호
    	var c_pwd = f.c_pwd.value.trim(); //입력한 비번
    	
    	if (c_pwd == ''){
    		alert("수정할 게시물의 비밀번호를 입력하세요.");
    		f.c_pwd.value = '';
    		f.c_pwd.focus();
    		return;
    	}
    	
    	//jQuery Ajax
        $.ajax({
        	url      : 'check_pwd.do', //VisitCheckPasswordAction
        	data     : {'idx':idx, 'c_pwd' : c_pwd},
        	dataType : 'json',
        	success  : function(res_data){
        		//비밀번호 맞은 경우 : res_data = {"result" : true}
        		//비밀번호 틀린 경우 : res_data = {"result" : false}
        		if (res_data.result == false){
        			alert('비밀번호가 틀립니다.');
        			return;
        		}
        		
        		//삭제 수행
        		location.href = 'modify_form.do?idx='+idx;
        	},
        	error    : function(err){
        		alert(err.responseText);
        	}
        });
    }
    
    function search(){
    	
    	var search = $("#search").val();
    	var search_text = $("#search_text").val().trim();
    	
    	//전체검색이 아닌 경우
    	if (search != 'all' && search_text == ''){
    		alert('검색어를 입력하세요!');
    		$("#search_text").val("");
    		$("#search_text").focus();
    		return;
    	}
    	
    	//검색내용을 parameter로 목록보기(list.do) 호출
    	location.href = "list.do?search="+search+"&search_text="+encodeURIComponent(search_text);
    	
    }
</script>
</head>
<body>
   <div id = "box">
      <h1 id = "title">::::방명록::::</h1>
      <div class = "submit">
          <input class = "btn btn-primary" type = "button" value = "글쓰기"  
          onclick = "location.href='insert_form.do'">
      </div>
      
      <!-- 검색메뉴 -->
      <div style = "text-align : center; margin : 10px">
         <select id = "search">
             <option value = "all">전체</option>
             <option value = "name">이름</option>
             <option value = "content">내용</option>
             <option value = "name_content">이름+내용</option>
         </select>
         <input id = "search_text">
         <input type = "button" value = "검색" onclick = "search();">
      </div>
      
      <!-- 게시물이 없으면 -->
      <c:if test = "${empty list}">
	      <div>게시물이 없습니다.</div>
      </c:if>
      
      <!-- 게시물이 있으면 -->
      <c:forEach var = "vo" items = "${list}">
        <form>
           <input type = "hidden" name = "idx" value = "${vo.idx}">
           <input type = "hidden" name = "pwd" value = "${vo.pwd}">
           <div class="panel panel-primary">
		      <div class="panel-heading"><h4>[${vo.name}]님의 글</h4></div>
		      <div class="panel-body">
		         <div class = "content_type">${vo.content}</div>
		         <div class = "regdate_type">작성일자 : ${fn:substring(vo.regdate,0,16)}(${vo.ip})</div>
		         <div>
		            비밀번호(${vo.pwd}) : <input type = "password" name = "c_pwd">
		                    <input class = "btn btn-info"   type = "button" value = "수정" onclick = "modify(this.form);">
		                    <input class = "btn btn-danger" type = "button" value = "삭제" onclick = "del(this.form);">
		         </div>
		      </div>
            </div>
         </form>
      </c:forEach>
   </div>
</body>
</html>