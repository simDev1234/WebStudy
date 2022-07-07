//아이디/비번 입력 포맷에 맞는지 확인 
//아이디/비번 체크 정규식 : 5~20자의 영문 소문자, 숫자와 특수기호 -, _ 만 사용 가능
var regRegi = /^[a-z0-9_]{5,20}$/;

function regSend(f){
	//필수 입력 정보 유효성 확인
	var bValid = regInvalidation();
	
	//필수 입력 정보가 유효할 경우
	if(bValid){
		
		//회원 정보 확인하는 코드		
		
		f.method = "GET";
		f.action = "";
		f.submit();
	}
}

function regInvalidation(){
	
	//[1] 아이디를 입력하지 않은 경우
	if($("#rgUserId").val()==""){
		$(".rgId_valid").css("visibility","visible");
		$("#rgUserId").focus();
		return false;
	}
	
	//[2] 비밀번호를 입력하지 않은 경우
	if($("#rgUserPwd").val()==""){
		$(".rePwd_valid").css("visibility","visible");
		$("#rgUserPwd").val("");
		$("#rgUserPwd").focus();
		return false;
	}
	
	//[3] 비밀번호 재확인을 입력하지 않은 경우
	if($("#rgUserRePwd").val()==""){
		$(".reRePwd_valid").css("visibility","visible");
		$("#rgUserRePwd").val("");
		$("#rgUserRePwd").focus();
		return false;
	}
	
	//[4] 닉네임을 입력하지 않은 경우
	if($("#rgUserNickName").val()==""){
		$(".rgNickName_valid").css("visibility","visible");
		$("#rgUserNickName").val("");
		$("#rgUserNickName").focus();
		return false;
	}
	
	//[5] 휴대전화를 입력하지 않은 경우
	if($("#rgUserPhone").val()==""){
		$(".rgPhone_valid").css("visibility","visible");
		$("#rgUserPhone").val("");
		$("#rgUserPhone").focus();
		return false;
	}
	
	//[1-2] 아이디를 입력한 경우, 정규식 확인
	if(regRegi.test($("#rgUserId").val())==false){
		$(".rgId_valid").html('아이디는 5~20자의 영문 소문자, 숫자와 특수기호 -, _ 로 작성해주세요');
		$("#rgUserId").val("");
		$("#rgUserId").focus();
		return false;
	}
	
	//[2-1]비밀번호를 입력한 경우, 정규식 확인
	if(!regRegi.test($("#userPwd").val())){
		$(".rgPwd_valid").html('비밀번호는 5~20자의 영문 소문자, 숫자와 특수기호 -, _ 로 작성해주세요');
		$("#rgUserPwd").val("");
		$("#rgUserPwd").focus();
		return false;
	}
	
	//[3-1] [2]과 비밀번호가 동일한지 확인
	
	//[4-1] 닉네임이 **수정 필요 (회원가입 후에 닉네임을 지정하게 하자.)
	
	//[5-1] 연락처 인증
	
	return true;
}



