<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	/* textarea의 글자수를 세어주는 제이쿼리문 */
	$(document).ready(function() {
	    $('.countContext').on('keyup', function() {
	        $('.counts p em').html($(this).val().length);
	    });
	});
	
	/* 글자수 reset */
	function count_reset(){
		$('.countContext').val("");
		$('.counts p em').html("0");
	}
</script>
<style type="text/css">
   .toolContent_countContent{ width : 1300px; margin : auto; }
   .countContext_left{ 
       width : 750px; 
       float : left;
    }
   .countContext{    
       width : 100%;
       height : 550px;
       resize : none; 
       padding : 20px; 
       box-sizing : border-box;
   }
   .countSu{ text-align : right; }
   .countContext_right{
       width : 400px;
       height : 550px;
       float : left;
       padding : 30px;
       background-color : #caccce;
       box-sizing : border-box;
   }
   .countContext_right h4{ font-weight : bold; margin-bottom:15px;}
   .counts{ 
       width : 100%; 
       background-color : white; 
       padding : 5px; 
       box-sizing : border-box;
   }
   .counts{ margin-bottom : 40px; }
   .counts > p {display : inline-block; width : 80%;}
   .counts > input {}
   .counts > p > em { color : red; }
   .countBottom{ clear : both; }
</style>
</head>
<body>
   <!-- 공고 현황 -->
   <div class = "toolContent toolContent_countContent">
      <h2 class = "toolTitle">글자수 세기</h2>
	  <div class = "toolBox">
	      <div class = "countContext_left">
	         <textarea class = "countContext" name = "countContext" rows="25" cols="10" placeholder = "자기소개서를 입력해주세요. 최소 200자는 적어주는 편이 좋습니다."></textarea>
	      	 <div class = "countSu"></div>
	      </div>
	      <div class = "countContext_right">
	          <div class = "counts">
	             <p>현재까지 글자 수 : <em>0</em></p>
	             <input type = "button" value = "초기화" onclick = "count_reset();">
	          </div>
	          <div>
	            <h4>TIP! 회사가 선호하는 자기소개 글자수</h4>
	            <strong>1. 글자수 자체는 큰 의미가 없다</strong>
	            <p>여백의 미가 생긴다면 성의 없어 보일까 걱정이 되겠지만 인사담당자들은 글자수 제한을 다 채울 필요는 없다고 강조한다.</p>
	            <strong>2. 보통 80~90% 정도를 채우면 적당하다.</strong>
	            <p>제한 글자수가 있다면 어느 정도 적정 분량을 채워야 성실성을 보여줄 수 있을 것. 80~90% 분량을 채우는 것은 최소한의 성의다. 핵심만 간단히!</p>
	            <strong>3. 한정된 글자수 내에서 진심과 열정을 보여라</strong>
	            <p>기업분석이 완벽하게 이루어져 있고 입사에 대한 진정성이 있다면 글자수 제한은 오히려 장벽이 될 것이다. 진심과 열정을 다해 자소서를 작성하는 것이 가장 현명한 방법이다.</p>
	            <p><a href = "https://www.jobkorea.co.kr/goodjob/tip/view?News_No=11759">[출처] 잡코리아</a></p>
	          </div>
	      </div>
	      <div class = "countBottom"></div>
      </div>
   </div>
</body>
</html>