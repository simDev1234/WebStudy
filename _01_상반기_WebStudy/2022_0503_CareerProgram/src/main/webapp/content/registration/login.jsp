<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/login.js"></script>
</head>
<body>
   <div id = "login_box" class = "container">
      <form>
         <table>
            <tr>
              <th><h2 id = "login_title">취업하고 싶어서</h2></th>
            </tr>
            <tr>
              <td>
                <input placeholder = "아이디" type = "text" name = "userId" id = "userId">
                <p class = "input_validation id_valid">아이디를 입력하세요.</p>
              </td>
            </tr>
            <tr>
              <td>
                <input placeholder = "비밀번호" type = "text" name = "userPwd" id = "userPwd">
                <p class = "input_validation pwd_valid">비밀번호를 입력하세요.</p>
              </td>
            </tr>
            <tr>
              <td>
                <input type = "checkbox" id = "login_status" name = "login_status">
                <label>로그인 상태 유지</label>
              </td>
            </tr>
            <tr>
              <td>
                <button type = "button" id = "btn_login" class="btn btn-info" onclick = "return loginSend(this.form)">로그인</button>
              </td>
            </tr>
            <tr>
              <td>
                <button type = "button" class = "btn_bottom btn_findPassword btn-default">비밀번호 찾기</button>
                <button type = "button" class = "btn_bottom btn_findID btn-default">아이디 찾기</button>
                <button type = "button" class = "btn_bottom btn_reg btn-default" onclick="location.href='?menu=register'">회원가입</button>
              </td>
            </tr>
         </table>
      </form>
   </div>
</body>
</html>