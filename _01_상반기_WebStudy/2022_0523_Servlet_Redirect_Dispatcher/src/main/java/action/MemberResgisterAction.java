package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberResgisterAction
 */
@WebServlet("/member_register.do")
public class MemberResgisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라메터 받고 -> 데이터 편집 
		request.setCharacterEncoding("utf-8");
		String name    = request.getParameter("name");
		String id      = request.getParameter("id");
		String pwd     = request.getParameter("pwd");
		String profile = request.getParameter("profile");
		String gender  = request.getParameter("gender");
		String blood   = request.getParameter("blood");
		
		//비빌번호 마스킹 처리 : 앞 1/2을 노출 + 나머지 *처리
		String pwdFront = pwd.substring(0,pwd.length()/2);
		StringBuilder pwdSb = new StringBuilder();
		pwdSb.append(pwdFront);
		for (int i = pwd.length()/2; i < pwd.length(); i++) {
			pwdSb.append("*");
		}
		String pwd_masked = pwdSb.toString();
		
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
		String friend_list;
		StringBuilder sb1 = new StringBuilder();
		
		for (String friend : friend_array) {
			sb1.append(friend).append(" ");
		}
		friend_list = sb1.toString().trim();
		
		if (friend_list.isEmpty()) {
			friend_list = "친구없음";
		}
		
		//Business Logic ▲ (데이터 가공)
		
		//request binding (request 영역에 데이터를 넣어서 데이터 공유 (연결))
		request.setAttribute("name", name);
		request.setAttribute("id",id);
		request.setAttribute("pwd_mask", pwd_masked);
		request.setAttribute("gender", gender);
		request.setAttribute("blood", blood);
		request.setAttribute("profile", profile);
		request.setAttribute("friend_list", friend_list);
		request.setAttribute("hobby_list", hobby_list);
		
		// 2. 출력 지시 (Dispatcher)
		RequestDispatcher disp = request.getRequestDispatcher("member_result.jsp");
		// 현재 서블릿에서 사용되는 request, response를 그대로 넘겨준다.
		disp.forward(request, response);
		
	}

}
