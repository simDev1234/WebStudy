package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myutil.Jumin;

/**
 * Servlet implementation class JuminAction
 */
@WebServlet("/jumin.do")
public class JuminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JuminAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// jumin.do?jumin_no=801212-1234560
		//1. ���� ���ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		//2. �ֹ� ��ȣ �ޱ�
		String jumin_no = request.getParameter("jumin_no");
		
		//3. �ΰ� ���� ����
	    Jumin jumin = new Jumin();
	    jumin.setJumin_no(jumin_no); //������ �ֹι�ȣ ��ü�� �ֱ�
	    
	    boolean bValid  = jumin.isValid();
	    int     year    = jumin.getYear();
	    String  ganji   = jumin.getGanji();
	    String  season  = jumin.getSeason();
	    int     age     = jumin.getAge();
	    String  tti     = jumin.getTti();
	    String  gender  = jumin.getGender();
	    String  local   = jumin.getLocal();
	    
	    //JSON���� ����
	    //{"year" : 2022, "bValid" : true.......}
	    StringBuffer sb = new StringBuffer("{");
	                           //java���� JSON���� �ÿ��� �� " "�� �־��־�� �Ѵ�.
	                           // *** ' '�� String.format���� �ν����� ���Ѵ�.
	    sb.append(String.format("\"bValid\":%b,",bValid));
	    sb.append(String.format("\"year\":%d,"  ,year));
	    sb.append(String.format("\"ganji\":\"%s\"," ,ganji));
	    sb.append(String.format("\"season\":\"%s\",",season));
	    sb.append(String.format("\"age\":%d,"   ,age));
	    sb.append(String.format("\"tti\":\"%s\","   ,tti));
	    sb.append(String.format("\"gender\":\"%s\",",gender));
	    sb.append(String.format("\"local\":\"%s\""  ,local));
	    sb.append("}");
	    
		//����
	    //                       text/plain(�Ϲݺ��빮��), html, xml �� �ü� �ִ�.
	    response.setContentType("text/json; charset = utf-8");
	    //����
	    response.getWriter().print(sb.toString());
		
	}

}

