//아이디/비번 입력 포맷에 맞는지 확인 
//아이디/비번 체크 정규식 : 5~20자의 영문 소문자, 숫자와 특수기호 -, _ 만 사용 가능
var regLog = /^[a-z0-9_]{5,20}$/;

function loginSend(f){
	//필수 입력 정보 유효성 확인
	var bValid = logInvalidation();
	
	//필수 입력 정보가 유효할 경우
	if(bValid){
		
		//회원 정보 확인하는 코드		
		
		f.method = "GET";
		f.action = "";
		f.submit();
	}
}

function logInvalidation(){
	
	//[1] 아이디와 비밀번호를 둘 다 입력하지 않은 경우
	if($("#userId").val()=="" && $("#userPwd").val()==""){
		$(".id_valid").css("visibility","visible");
		$(".pwd_valid").css("visibility","visible");
		$("#userId").focus();
		return false;
	}

	//[2] 아이디를 입력하지 않은 경우
	if($("#userId").val()==""){
		$(".id_valid").css("visibility","visible");
		$("#userId").focus();
		return false;
	}
	
	//[3] 비밀번호를 입력하지 않은 경우
	if($("#userPwd").val()==""){
		$(".pwd_valid").css("visibility","visible");
		$("#userPwd").focus();
		return false;
	}
	
	//[4] 아이디의 정규식 확인
	if(!regLog.test($("#userId").val())){
		alert('아이디는 5~20자의 영문 소문자, 숫자와 특수기호 -, _ 로 작성해주세요');
		$("#userId").val("");
		$("#userId").focus();
		return false;
	}
	
	//[5] 비밀번호의 정규식 확인
	if(!regLog.test($("#userPwd").val())){
		alert('비밀번호는 5~20자의 영문 소문자, 숫자와 특수기호 -, _ 로 작성해주세요');
		$("#userPwd").val("");
		$("#userPwd").focus();
		return false;
	}
	
	return true;
}



