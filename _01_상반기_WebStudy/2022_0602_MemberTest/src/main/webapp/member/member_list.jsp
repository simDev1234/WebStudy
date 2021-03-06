<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<!-- Bootstrap 3.x -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
   #box{ 
     width : 1000px;
     margin : auto;
     margin-top : 30px;
   }
   
   #title{ 
     text-align  : center;
     font-size   : 32px;
     font-weight : bold;
   }
   
   #enroll{
     text-align : right;
     margin-bottom : 5px;
   }
   
   th{
     text-align : center;
   }
   
   td{
     /* 들여쓰기 */
     text-indent : 10px;
   }

</style>
<script type="text/javascript">
    function del(m_idx){
    	//if (confirm("정말 삭제 하시겠습니까?")==false) return;
    	
    	Swal.fire({
		  title: '정말 삭제 하시겠습니까?',
		  html: "<h5>삭제 후 이 작업을 돌이킬 수 없습니다.</h5>",
		  icon: 'question',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: '삭제하기',
		  cancelButtonText : '취소하기'
		}).then((result) => {
			
	      //삭제 버튼을 누르면
		  if (result.isConfirmed) {
			
			location.href = 'delete.do?m_idx='+m_idx;
			  
		  }
	      
		})
		
		//alert('삭제한다');
    }
</script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
   <div id = "box">
      <h1 id = "title">::::: 회원목록 :::::</h1>
      
      <!-- 회원가입 -->
      <div id = "enroll">
         <input class = "btn btn-primary" type = "button" value = "회원가입" onclick = "location.href = 'insert_form.do';">
      </div>
      
      <!-- 데이터 출력 -->
      <div>
         <table class = "table table-striped">
            <!-- title --> 
            <tr class = "info">
              <th>번호</th>
              <th>이름</th>
              <th>아이디</th>
              <th>비밀번호</th>
              <th>우편번호</th>
              <th>주소</th>
              <th>회원등급</th>
              <th>아이피</th>
              <th>가입일자</th>
              <th>편집</th>
            </tr>
            <!-- data -->
            <!-- 데이터가 하나도 없는 경우 -->
            <c:if test = "${ empty list }">
              <tr>
                <td colspan = "10" align = "center">
                   <font color = "red">등록된 회원이 없습니다.</font>
                </td>
              </tr>
            </c:if>
            
            <!-- 데이터가 하나 이상 있는 경우 -->
            <c:forEach var = "vo" items = "${ list }">
              <tr>
                <td>${ vo.m_idx }</td>
                <td>${ vo.m_name }</td>
                <td>${ vo.m_id }</td>
                <td>${ vo.m_pwd }</td>
                <td>${ vo.m_zipcode }</td>
                <td>${ vo.m_addr }</td>
                <td>${ vo.m_grade }</td>
                <td>${ vo.m_ip }</td>
                <td>${ fn:substring(vo.m_regdate,0,10) }</td>
                <td>
                                                                                <!-- 세션 트랙킹 : location.href 와 같이 get방식으로 전달. 정보 상태를 유지시키는 방법 -->
                  <input class = "btn btn-info"   type = "button" value = "수정" onclick = "location.href='modify_form.do?m_idx=${ vo.m_idx }';">
                  <input class = "btn btn-danger" type = "button" value = "삭제" onclick = "del('${ vo.m_idx }');">
                </td>
              </tr>
            </c:forEach>
         </table>
      </div>
   </div>
</body>
</html>