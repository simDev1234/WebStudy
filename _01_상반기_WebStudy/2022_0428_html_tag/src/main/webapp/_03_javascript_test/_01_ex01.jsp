<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
   // 1라인 주석 -- javacript용 주석
   /* 범위 주석 */
   
   /* 자료형 */
   /* 
      문자(열)형 : string
      숫자형    : number
      날짜형    : date
      논리형    : boolean
   */
   
   /* 변수선언 */
   //int a = 10; 과 같은 방식X
   //////////--> 변수의 타입을 미리 알 수 없다.
   var a;
   let b;
   
   //   012345
   a = '[닉네임]님, 안녕하세요.'; 
   
   //body 출력
   document.write(a + "<br>");
   document.write(a.length + "<br>"); //문자열의 길이
   document.write(a.substring(0,5)+"<br>"); //substring(시작, 시작+갯수)
   document.write(a.substr(2,2)+"<br>");    //substr(시작, 갯수)
   document.write(a.charAt(2)+"<br>");      //charAt(index)
   
   a = "100"; 
   //문자(숫자형) -> 정수변환함수 
   //[1] parseInt("123");
   //[2] Number("123");
   document.write(parseInt(a) + 1 +"<br>"); 
   
   a = new Date(); //현재 시스템 날짜
   document.write(a + "<br>");
   document.write(a.getYear() + 1900 + "<br>"); //연도만 가져온다.(1900을 기준으로 +year)
   document.write(a.getMonth() + 1 + "<br>"); //0월부터 시작하기 때문에 +1을 해야한다.
   document.write(a.getDate() + "<br>");
   document.write(a.getHours() + "<br>");
   document.write(a.getMinutes() + "<br>");
   document.write(a.getSeconds() + "<br>");
   
   a = 3 > 2;  
   document.write(a + "<br>");
   
   /* 상수 */
   const x = 0;
   
   var global_a; //전역변수
   /* 함수 */
   function testFn()
   {
	   //함수 내에서 var 붙이면 지역변수, 아니면 전역변수
	   var local_a = 10; //지역변수
	       global_b = 20; //전역변수
   }
   testFn(); //호출을 해야 내부 변수가 생성된다.
   
   //document.write(local_a+"<br>"); //에러! 선언하지 않음으로 에러가 난다.
   document.write(global_a+"<br>");  //undefined로 출력됨 -- 
   document.write(local_a+"<br>");  
   
</script>
</head>
<body>
   <input type = "button" value = "인사말" onclick = "javascript:window.alert('안녕하세요.');">
</body>
</html>