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
		
		//0.�������ڵ� ���� -- ���� ���� �ؾ��ϴ� �۾� (POST ��û �� ������ ó��/GET ��û �� �� �ص� �ȴ�) 
		request.setCharacterEncoding("utf-8");
		//get��� ���ڵ� ���� :: server > Tomcat > <Connector URIEncoding="utf-8" connectionTimeout="20000" 
		
		String name = request.getParameter("name");
		//System.out.println(name); 
		//get : ȫ�浿, post : ????����??? <<== post����� �� ���ڰ� ������.
		//HTML���� UTF-8 ---> JAVA���� MS949
		//[�ذ���] ������ �������ڵ� ���� 
		String id      = request.getParameter("id");
		String pwd     = request.getParameter("pwd");
		String profile = request.getParameter("profile");
		String gender  = request.getParameter("gender");
		String blood   = request.getParameter("blood");
		
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
		//String[] friend_array = {"","","",""};
		String friend_list;
		StringBuilder sb1 = new StringBuilder();
		
		for (String friend : friend_array) {
			sb1.append(friend).append(" ");
		}
		friend_list = sb1.toString().trim();
		
		if (friend_list.isEmpty()) {
			friend_list = "ģ������";
		}
		
		//---------Business Logic �� (������ ����)
		
		//---------Presentation Logic ��
		
		//����ó��
		response.setContentType("text/html; charset = utf-8;");
		
		//HTML���� ���� -> ������ ����
		StringBuffer sb_html = new StringBuffer();
		
		sb_html.append("<html><head><title>���</title></head>");
		sb_html.append("<body><table border = '1' width = '400'>");
		sb_html.append(String.format("<tr><th>�̸�</th><td>%s</td></tr>", name));
		sb_html.append(String.format("<tr><th>���̵�</th><td>%s</td></tr>", id));
		
		//�����ȣ ����ŷ ó�� : �� 1/2�� ���� + ������ *ó��
		//5�ڸ��� : �� ���ڸ� + ���ڸ�
		String pwdFront = pwd.substring(0,pwd.length()/2);
		StringBuilder pwdSb = new StringBuilder();
		pwdSb.append(pwdFront);
		for (int i = pwd.length()/2; i < pwd.length(); i++) {
			pwdSb.append("*");
		}
		pwd = pwdSb.toString();
		
		sb_html.append(String.format("<tr><th>��й�ȣ</th><td>%s</td></tr>", pwd));
		sb_html.append(String.format("<tr><th>����</th><td>%s</td></tr>", gender));
		sb_html.append(String.format("<tr><th>������</th><td>%s</td></tr>", blood));
		sb_html.append(String.format("<tr><th>�ڱ�Ұ�</th><td>%s</td></tr>", profile));
		sb_html.append("<tr><td colspan = '2' align = 'center'><a href = 'member_input.html'>�ٽ��ϱ�</a></td></tr>");
		sb_html.append("</table></body></html>");
		
		//����
		response.getWriter().print(sb_html.toString());
		
	}

}
