<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap 3.x -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<script type="text/javascript">

	function modify(f) {

		var name = f.name.value.trim();
		var kor = f.kor.value.trim();
		var eng = f.eng.value.trim();
		var mat = f.mat.value.trim();

		if (name == '') {
			alert('이름를 입력하세요.');
			f.name.value = '';
			f.name.focus();
			return;
		}

		var numReg = /^[0-9]{1,3}$/ // 0 ~ 100

		if (kor == '') {
			alert('데이터를 입력하세요.');
			f.kor.value = '';
			f.kor.focus();
			return;
		}

		if (numReg.test(kor) == false || kor > 100) {
			alert('국어점수 0 ~ 100 사이 정수만 입력하세요.');
			f.kor.value = '';
			f.kor.focus();
			return;
		}
		/* 영어 */
		if (eng == '') {
			alert('데이터를 입력하세요.');
			f.eng.value = '';
			f.eng.focus();
			return;
		}

		if (numReg.test(eng) == false || eng > 100) {
			alert('영어점수 0 ~ 100 사이 정수만 입력하세요.');
			f.eng.value = '';
			f.eng.focus();
			return;
		}
		if (mat == '') {
			alert('데이터를 입력하세요.');
			f.mat.value = '';
			f.mat.focus();
			return;
		}

		if (numReg.test(mat) == false || mat > 100) {
			alert('수학점수 0 ~ 100 사이 정수만 입력하세요.');
			f.mat.value = '';
			f.mat.focus();
			return;
		}
		
		//수정 확인
		if (confirm("정말 수정하시겠습니까?")==false){
			return;
		}

		f.action = 'modify.do'; //전송대상 : SungModifyAction

		f.submit(); //전송

	}
</script>



<style type="text/css">
#box {
	width: 500px;
	margin: auto;
	margin-top: 50px;
}
</style>

</head>
<body>
	<form>
	    <!-- 방법2 : Session Tracking중 1가지 
	         > hidden tag 사용 - 시각적으로 보이지는 않지만, idx 값이 넘어간다. -->
	    <input type="hidden" name="idx" value = "${ vo.idx }">
		<div id="box">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4 align="center">성적수정하기</h4>
				</div>
				<div class="panel-body">
					<table class="table table-striped">
					
					    <%-- 
					    방법1 : readonly = "readonly"를 주어 넘긴다. (편집만 못할 뿐, form parameter로 값을 넘김)
					    **주의! >> disabled = "disabled"를 주면 값이 넘어가지 않는다.
					    <tr>
							<th>번호</th>
							<td><input type="text" name="idx" value = "${ vo.idx }" readonly = "readonly"></td>
						</tr>
					    --%>
					    
						<tr>
							<th>이름</th>
							<td><input type="text" name="name" value = "${ vo.name }"></td>
						</tr>

						<tr>
							<th>국어</th>
							<td><input type="text" name="kor" value = "${ vo.kor }"></td>
						</tr>

						<tr>
							<th>영어</th>
							<td><input type="text" name="eng" value = "${ vo.eng }"></td>
						</tr>

						<tr>
							<th>수학</th>
							<td><input type="text" name="mat" value = "${ vo.mat }"></td>
						</tr>

						<tr>
							<td colspan="2" align="center">
							<input class="btn btn-primary" type="button" value="수정"
								onclick="modify(this.form);"> 
							<input class="btn btn-warning" type="button" value="돌아가기"
								onclick="location.href='list.do'"></td>
						</tr>
					</table>
				</div> <!-- 부트스트랩 바디 -->
			</div>
		</div>
	</form>
</body>
</html>
