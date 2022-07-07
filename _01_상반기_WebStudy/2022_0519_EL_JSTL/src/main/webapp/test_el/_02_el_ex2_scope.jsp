<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
    //수행 영역 : _jspService();
    //각 영역에 데이터 넣는다. ( key, value )
    pageContext.setAttribute("msg","페이지 영역");
	request.setAttribute("msg", "리퀘스트 영역");
	session.setAttribute("msg", "세션 영역");
	application.setAttribute("msg", "애플리케이션 영역");
%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>표현언어(EL) - 내장 객체</title>
	</head>
	<body>
		<%-- 형식 : ${영역, 객체(변수)명} --%>
		<hr>
		  각 영역에 저장된 속성 읽기
		<hr>
			pageScope내의 msg    : ${ pageScope.msg }   <br>
			requestScope내의 msg : ${ requestScope.msg }<br>     
			sessionScope내의 msg : ${ sessionScope.msg }<br>
		<hr>
			영역 지정 없이 속성 읽기
		<hr>
			${ msg }
		<div>
		   <h2>각 영역이 참조되는 순서</h2>
		   <p>pageScope -> requestScope -> sessionScope -> applicationScope</p>
		   <p>페이지 영역 : 포워드 되면 소멸되고 새로 만들어진다.</p>
		   <p>페이지 포워드 이후에는 [영역 지정 없이 속성을 준 경우] request영역에서 속성을 읽어온다.</p>
		</div>
	</body>
</html>