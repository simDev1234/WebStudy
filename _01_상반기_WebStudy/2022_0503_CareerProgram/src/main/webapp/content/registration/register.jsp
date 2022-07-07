<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/register.js"></script>
</head>
<body>
	<div id = "register_box" class = "container">
	   <form>
	      <table>
            <tr>
              <th><h2 id = "register_title">취업하고 싶어서</h2></th>
            </tr>
            <tr>
              <td>
                <label>아이디</label>
                <input type = "text" name = "rgUserId" id = "rgUserId">
                <p class = "input_validation rgId_valid">필수 정보입니다.</p>
              </td>
            </tr>
            <tr>
              <td>
                <label>비밀번호</label>
                <input type = "text" name = "rgUserPwd" id = "rgUserPwd">
                <p class = "input_validation rePwd_valid">필수 정보입니다.</p>
              </td>
            </tr>
            <tr>
              <td>
                <label>비밀번호 재확인</label>
                <input type = "text" name = "rgUserRePwd" id = "rgUserRePwd">
                <p class = "input_validation reRePwd_valid">필수 정보입니다.</p>
              </td>
            </tr>
            <tr>
              <td>
                <label>닉네임</label>
                <input type = "text" name = "rgUserNickName" id = "rgUserNickName">
                <p class = "input_validation rgNickName_valid">필수 정보입니다.</p>
              </td>
            </tr>
            <tr>
              <td>
                <label>휴대전화</label>
                <input type = "text" name = "rgUserPhone" id = "rgUserPhone">
                <button type = "button" id = "btn_rgphoneValid" class="btn btn-info">인증번호 받기</button>
                <input type = "text" placeholder = "인증번호 입력하세요" name = "rgCertifyPhone" id = "rgCertifyPhone" readonly>
                <p class = "input_validation rgPhone_valid">필수 정보입니다.</p>
              </td>
            </tr>
            <tr>
              <td>
                <button type = "button" id = "btn_register" class="btn btn-info" onclick = "return regSend(this.form)">회원가입</button>
              </td>
            </tr>
         </table>
	   </form>
	</div>
</body>
</html>