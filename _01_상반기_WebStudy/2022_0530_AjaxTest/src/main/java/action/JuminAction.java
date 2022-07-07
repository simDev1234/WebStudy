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
		//1. 수신 인코딩 실정
		request.setCharacterEncoding("utf-8");
		
		//2. 주민 번호 받기
		String jumin_no = request.getParameter("jumin_no");
		
		//3. 부가 정보 추출
	    Jumin jumin = new Jumin();
	    jumin.setJumin_no(jumin_no); //수신한 주민번호 객체에 넣기
	    
	    boolean bValid  = jumin.isValid();
	    int     year    = jumin.getYear();
	    String  ganji   = jumin.getGanji();
	    String  season  = jumin.getSeason();
	    int     age     = jumin.getAge();
	    String  tti     = jumin.getTti();
	    String  gender  = jumin.getGender();
	    String  local   = jumin.getLocal();
	    
	    //JSON으로 포장
	    //{"year" : 2022, "bValid" : true.......}
	    StringBuffer sb = new StringBuffer("{");
	                           //java에서 JSON전달 시에는 꼭 " "를 넣어주어야 한다.
	                           // *** ' '는 String.format에서 인식하지 못한다.
	    sb.append(String.format("\"bValid\":%b,",bValid));
	    sb.append(String.format("\"year\":%d,"  ,year));
	    sb.append(String.format("\"ganji\":\"%s\"," ,ganji));
	    sb.append(String.format("\"season\":\"%s\",",season));
	    sb.append(String.format("\"age\":%d,"   ,age));
	    sb.append(String.format("\"tti\":\"%s\","   ,tti));
	    sb.append(String.format("\"gender\":\"%s\",",gender));
	    sb.append(String.format("\"local\":\"%s\""  ,local));
	    sb.append("}");
	    
		//응답
	    //                       text/plain(일반보통문서), html, xml 등 올수 있다.
	    response.setContentType("text/json; charset = utf-8");
	    //전송
	    response.getWriter().print(sb.toString());
		
	}

}

