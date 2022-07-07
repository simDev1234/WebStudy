<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
    /*
    // 자바 코드
    // EL (Expression Language) : 표현언어
    // 1. 형식 : ${ 상수 또는 변수 또는 연산자 }
    // 2. 변수 : 각 scope(영역)에 저장된 변수  *scope : pageScope, requestScope, sessionScope, applicationScope
    //    - param 변수 : xxx.jsp?name = 홍길동   >>   ${ param.name }
    // 3. 읽기전용 
    // 4. 연산자
        1) 산술연산자 : +         -      *      /(div)  %(mod)
        2) 관계연산자 : >(gt)    >=(ge)  <(lt)  <=(le)  ==(eq)  !=(ne)
        3) 논리연산자 : &&(and)  ||(or)  !(not) 
        4) 삼항연산자 : (조건) ? 참값 : 거짓값
        5) 기타     : empty
      
    */
%>
<!-- Html 주석 -->
<%-- jsp  주석 : EL 표현형식 : ${  변수  } --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
  산술연산자
<hr>
\${ 1+2 } => ${ 1+2 } <br>
\${ 3-2 } => ${ 3-2 } <br>
\${ 1*2 } => ${ 1*2 } <br>
\${ 10/3 } => ${ 10/3 } or ${ 10 div 3 }<br>
\${ 10%3 } => ${ 10%3 } or ${ 10 mod 3 }<br>
<hr>
  관계(비교)연산자
<hr>
\${ 3 > 2 }  => ${ 3 > 2 }  or ${ 3 gt 2 }<br> <!-- gt : greater than -->
\${ 3 >= 2 } => ${ 3 >= 2 } or ${ 3 ge 2 }<br> <!-- ge : greater equal -->
\${ 3 < 2 }  => ${ 3 < 2 }  or ${ 3 lt 2 }<br> <!-- lt : less than -->
\${ 3 <= 2 } => ${ 3 <= 2 } or ${ 3 le 2 }<br> <!-- le : less equal -->
\${ 3 == 2 } => ${ 3 == 2 } or ${ 3 eq 2 }<br> <!-- eq : equal -->
\${ 3 != 2 } => ${ 3 != 2 } or ${ 3 ne 2 }<br> <!-- ne : not equal -->
<hr>
  논리연산자
<hr>
\${ true && true }   => ${ true && true }<br>
\${ true && false }  => ${ true && false }<br>

\${ false || false } => ${ false || false }<br>
\${ true || false }  => ${ true || false }<br>
<hr>
  기타 : empty(특정객체가 비어있냐?)
<hr>
parameter메시지 : ${ empty param.msg ? '전달 메시지 없음' : param.msg }
</body>
</html>