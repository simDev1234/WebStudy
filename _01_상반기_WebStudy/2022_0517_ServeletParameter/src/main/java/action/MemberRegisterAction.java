package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberRegisterAction
 */
@WebServlet("/member_register.do")
public class MemberRegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRegisterAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//?name=%ED%99%8D%EA%B8%B8%EB%8F%99&id=ddddd&pwd=1234&gender=male&hobby=book&friend=222222&friend=&friend=&friend=&blood=A&photo=&profile=qqqqq
		
		//0.수신인코딩 설정 -- 가장 먼저 해야하는 작업 (POST 요청 시 무조건 처리/GET 요청 시 안 해도 된다) 
		request.setCharacterEncoding("utf-8");
		//get방식 인코딩 설정 :: server > Tomcat > <Connector URIEncoding="utf-8" connectionTimeout="20000" 
		
		String name = request.getParameter("name");
		//System.out.println(name); 
		//get : 홍길동, post : ????¸¸??? <<== post방식일 때 글자가 깨진다.
		//HTML에서 UTF-8 ---> JAVA에서 MS949
		//[해결방법] 위에서 수신인코딩 설정 
		String id      = request.getParameter("id");
		String pwd     = request.getParameter("pwd");
		String profile = request.getParameter("profile");
		String gender  = request.getParameter("gender");
		String blood   = request.getParameter("blood");
		
		//parameter명이 동일한 변수 -> 배열로 받는다
		String[] hobby_array = request.getParameterValues("hobby");
		String[] friend_array = request.getParameterValues("friend");
		
		//취미처리
		String hobby_list = "취미없음"; //기본값
		
		if (hobby_array != null) {
			
			//StringBuffer buffer = new StringBuffer();
			StringBuilder sb = new StringBuilder();
			
			//String[] hobby_array = {"운동", "독서"};
			for (String hobby : hobby_array) {
				sb.append(hobby).append(" ");
			}
			hobby_list = sb.toString();
			
		}
		
		//친구처리 **필수로 받은 내용. ""으로 들어온다.
		//String[] friend_array = {"","","",""};
		String friend_list;
		StringBuilder sb1 = new StringBuilder();
		
		for (String friend : friend_array) {
			sb1.append(friend).append(" ");
		}
		friend_list = sb1.toString().trim();
		
		if (friend_list.isEmpty()) {
			friend_list = "친구없음";
		}
		
		//---------Business Logic ▲ (데이터 가공)
		
		//---------Presentation Logic ▼
		
		//응답처리
		response.setContentType("text/html; charset = utf-8;");
		
		//HTML동적 생성 -> 저장할 버퍼
		StringBuffer sb_html = new StringBuffer();
		
		sb_html.append("<html><head><title>결과</title></head>");
		sb_html.append("<body><table border = '1' width = '400'>");
		sb_html.append(String.format("<tr><th>이름</th><td>%s</td></tr>", name));
		sb_html.append(String.format("<tr><th>아이디</th><td>%s</td></tr>", id));
		
		//비빌번호 마스킹 처리 : 앞 1/2을 노출 + 나머지 *처리
		//5자릿수 : 앞 두자리 + 세자리
		String pwdFront = pwd.substring(0,pwd.length()/2);
		StringBuilder pwdSb = new StringBuilder();
		pwdSb.append(pwdFront);
		for (int i = pwd.length()/2; i < pwd.length(); i++) {
			pwdSb.append("*");
		}
		pwd = pwdSb.toString();
		
		sb_html.append(String.format("<tr><th>비밀번호</th><td>%s</td></tr>", pwd));
		sb_html.append(String.format("<tr><th>성별</th><td>%s</td></tr>", gender));
		sb_html.append(String.format("<tr><th>혈액형</th><td>%s</td></tr>", blood));
		sb_html.append(String.format("<tr><th>자기소개</th><td>%s</td></tr>", profile));
		sb_html.append("<tr><td colspan = '2' align = 'center'><a href = 'member_input.html'>다시하기</a></td></tr>");
		sb_html.append("</table></body></html>");
		
		//전송
		response.getWriter().print(sb_html.toString());
		
	}

}
