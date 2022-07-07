<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
    //Java Code --> _jspService(request, response) 메소드 내에 삽입
    
    //JSP 내장 객체 : pageContext, request, response, session, application 
    //             out 
    
    //0.수신인코딩 설정 -- 가장 먼저 해야하는 작업 (POST 요청 시 무조건 처리/GET 요청 시 안 해도 된다) 
	request.setCharacterEncoding("utf-8");
	//get방식 인코딩 설정 :: server > Tomcat > <Connector URIEncoding="utf-8" connectionTimeout="20000" 
	
	String name = request.getParameter("name");
	//System.out.println(name); 
	//get : 홍길동, post : ????¸¸??? <<== post방식일 때 글자가 깨진다.
	//HTML에서 UTF-8 ---> JAVA에서 MS949
	//[해결방법] 위에서 수신인코딩 설정 
	String id      = request.getParameter("id");
	String pwd     = request.getParameter("pwd");
	String profile = request.getParameter("profile");
	String gender  = request.getParameter("gender");
	String blood   = request.getParameter("blood");
	
	//비빌번호 마스킹 처리 : 앞 1/2을 노출 + 나머지 *처리
	//5자릿수 : 앞 두자리 + 세자리
	String pwdFront = pwd.substring(0,pwd.length()/2);
	StringBuilder pwdSb = new StringBuilder();
	pwdSb.append(pwdFront);
	for (int i = pwd.length()/2; i < pwd.length(); i++) {
		pwdSb.append("*");
	}
	String pwd_masked = pwdSb.toString();
	
	//parameter명이 동일한 변수 -> 배열로 받는다
	String[] hobby_array = request.getParameterValues("hobby");
	String[] friend_array = request.getParameterValues("friend");
	
	//취미처리
	String hobby_list = "취미없음"; //기본값
	
	if (hobby_array != null) {
		
		//StringBuffer buffer = new StringBuffer();
		StringBuilder sb = new StringBuilder();
		
		//String[] hobby_array = {"운동", "독서"};
		for (String hobby : hobby_array) {
			sb.append(hobby).append(" ");
		}
		hobby_list = sb.toString();
		
	}
	
	//친구처리 **필수로 받은 내용. ""으로 들어온다.
	//String[] friend_array = {"","","",""};
	String friend_list;
	StringBuilder sb1 = new StringBuilder();
	
	for (String friend : friend_array) {
		sb1.append(friend).append(" ");
	}
	friend_list = sb1.toString().trim();
	
	if (friend_list.isEmpty()) {
		friend_list = "친구없음";
	}
	
	//Business Logic ▲ (데이터 가공)
%>

<!-- //Presentation Logic ▼ -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
   #box{ width : 400px; margin : auto; }
   caption{text-align : center;}
</style>

</head>
<body>
   <div id = "box">
	   <table border = "1" width = "400" class="table .table-striped">
	      <caption>:::회원정보 결과:::</caption>
	      <tr>
	        <th>이름</th>
	        <td><%= name %></td> <!-- 표현식 = 출력식 -->
	      </tr>
	      <tr>
	        <th>아이디</th>
	        <td><%= id %></td> 
	      </tr>
	      <tr>
	        <th>비밀번호</th>
	        <td><%= pwd_masked %></td> 
	      </tr>
	      <tr>
	        <th>성별</th>
	        <td><%= gender %></td> 
	      </tr>
	      <tr>
	        <th>혈액형</th>
	        <td><%= blood %></td> 
	      </tr>
	      <tr>
	        <th>자기소개</th>
	        <td><%= profile %></td> 
	      </tr>
	      <tr>
	        <td colspan = '2'><a href = "member_input.html">다시하기</a></td> 
	      </tr>
	   </table>
   </div>
</body>
</html>