<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
   #box{ width : 800px; margin : auto; margin-top : 30px; }
   #title{ 
       text-align : center; 
       font-weight : bold; 
       font-size : 20pt; 
       color : grey; 
       text-shadow : 1px 1px 1px black; 
  }
  th,td{ text-align : center; }
</style>
<script type="text/javascript">
  function del(idx){

	  if(confirm('정말 삭제하시겠습니까?')==false){
		  return;
	  }
	  
	  //삭제할 레코드의 idx를 쿼리로 넘긴다.
	  location.href = "delete.do?idx="+idx;
	  
	  //alert(idx + '번호 게시물 삭제');
	  
  }
</script>
</head>
<body>
   <div id = "box">
     <h1 id = "title">::::성적 관리::::</h1>
     <div style = "text-align : left; margin-top : 10px; margin-bottom:10px">
        <input class = "btn btn-primary" type = "button" value = "성적 등록하기" onclick = "location.href='sung_insert_form.jsp'">
     </div>
   <div>
      <table class = "table table-striped table-hover">
         <tr>
           <th>번호</th>
           <th>이름</th>
           <th>국어</th>
           <th>영어</th>
           <th>수학</th>
           <th>총점</th>
           <th>평균</th>
           <th>등수</th>
           <th>비고</th>
         </tr>
         
         <!-- 데이터가 없을 경우 -->
         <c:if test = "${ empty list }">
            <tr>
              <td colspan = "9" align = "center">
                 <span style = "color : red">데이터가 없습니다.</span>
              </td>
            </tr>
         </c:if>
         
         <!-- 데이터 -->
         <c:forEach var = "vo" items = "${ list }">
            <tr>
              <td>${ vo.idx }</td>
              <td>${ vo.name }</td>
              <td>${ vo.kor }</td>
              <td>${ vo.eng }</td>
              <td>${ vo.mat }</td>
              <td>${ vo.tot }</td>
              <td>${ vo.avg }</td>
              <td>${ vo.rank }</td>
              <td>
                <input class = "btn btn-info" type = "button" value = "수정" onclick = "location.href = 'modify_form.do?idx=${vo.idx}'">
                <input class = "btn btn-danger" type = "button" value = "삭제" onclick="del('${vo.idx}')">
              </td>
            </tr>
         </c:forEach>
      </table>
   </div>
   </div>
</body>
</html>