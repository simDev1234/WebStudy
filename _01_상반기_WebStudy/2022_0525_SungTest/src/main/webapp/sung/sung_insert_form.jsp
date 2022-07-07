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

	function insert(f) {

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

		f.action = 'insert.do'; //전송대상

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
		<div id="box">

			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4 align="center">성적입력하기</h4>
				</div>
				<div class="panel-body">
					<table class="table table-striped">
						<tr>
							<th>이름</th>
							<td><input type="text" name="name"></td>
						</tr>

						<tr>
							<th>국어</th>
							<td><input type="text" name="kor"></td>


						</tr>

						<tr>
							<th>영어</th>
							<td><input type="text" name="eng"></td>


						</tr>



						<tr>
							<th>수학</th>
							<td><input type="text" name="mat"></td>
						</tr>

						<tr>
							<td colspan="2" align="center">
							<input class="btn btn-primary" type="button" value="등록"
								onclick="insert(this.form);"> 
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
