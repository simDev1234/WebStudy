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
		// 1. �Ķ���� �ް� -> ������ ���� 
		request.setCharacterEncoding("utf-8");
		String name    = request.getParameter("name");
		String id      = request.getParameter("id");
		String pwd     = request.getParameter("pwd");
		String profile = request.getParameter("profile");
		String gender  = request.getParameter("gender");
		String blood   = request.getParameter("blood");
		
		//�����ȣ ����ŷ ó�� : �� 1/2�� ���� + ������ *ó��
		String pwdFront = pwd.substring(0,pwd.length()/2);
		StringBuilder pwdSb = new StringBuilder();
		pwdSb.append(pwdFront);
		for (int i = pwd.length()/2; i < pwd.length(); i++) {
			pwdSb.append("*");
		}
		String pwd_masked = pwdSb.toString();
		
		//parameter���� ������ ���� -> �迭�� �޴´�
		String[] hobby_array = request.getParameterValues("hobby");
		String[] friend_array = request.getParameterValues("friend");
		
		//���ó��
		String hobby_list = "��̾���"; //�⺻��
		
		if (hobby_array != null) {
			
			//StringBuffer buffer = new StringBuffer();
			StringBuilder sb = new StringBuilder();
			
			//String[] hobby_array = {"�", "����"};
			for (String hobby : hobby_array) {
				sb.append(hobby).append(" ");
			}
			hobby_list = sb.toString();
			
		}
		
		//ģ��ó�� **�ʼ��� ���� ����. ""���� ���´�.
		String friend_list;
		StringBuilder sb1 = new StringBuilder();
		
		for (String friend : friend_array) {
			sb1.append(friend).append(" ");
		}
		friend_list = sb1.toString().trim();
		
		if (friend_list.isEmpty()) {
			friend_list = "ģ������";
		}
		
		//Business Logic �� (������ ����)
		
		//request binding (request ������ �����͸� �־ ������ ���� (����))
		request.setAttribute("name", name);
		request.setAttribute("id",id);
		request.setAttribute("pwd_mask", pwd_masked);
		request.setAttribute("gender", gender);
		request.setAttribute("blood", blood);
		request.setAttribute("profile", profile);
		request.setAttribute("friend_list", friend_list);
		request.setAttribute("hobby_list", hobby_list);
		
		// 2. ��� ���� (Dispatcher)
		RequestDispatcher disp = request.getRequestDispatcher("member_result.jsp");
		// ���� �������� ���Ǵ� request, response�� �״�� �Ѱ��ش�.
		disp.forward(request, response);
		
	}

}
