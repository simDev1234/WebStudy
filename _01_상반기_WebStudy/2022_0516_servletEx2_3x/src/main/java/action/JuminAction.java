package action;

import java.io.IOException;
import java.io.PrintWriter;

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
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//parameter 받기
		String jumin_no = request.getParameter("jumin_no");
		
		//--- Jumin객체
		Jumin jumin = new Jumin();
		jumin.setJumin_no(jumin_no);
		
		//출력 (응답처리 -> 출력)
		response.setContentType("text/html; charset = utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><head><title>jumin 응답</title><style>td{padding-left : 20px; padding-right : 20px;}</style></head><body><table border = '1' cellspacing = '0'><tr>");
		out.print("<th style = 'padding-left: 20px; padding-right : 20px;'>주민번호</th>");
		out.printf("<td>%s</td>",jumin_no);
		out.print("</tr><tr><th>출생년도</th>");
		out.printf("<td>%d</td></tr>", jumin.getYear());
		out.print("<tr><th>나이</th>");
		out.printf("<td>%d</td></tr>", jumin.getAge());
		out.print("<tr><th>성별</th>");
		out.printf("<td>%s</td></tr>", jumin.getGender());
		out.print("<tr><th>띠</th>");
		out.printf("<td>%s</td></tr>", jumin.getTti());
		out.print("<tr><th>출생계절</th>");
		out.printf("<td>%s</td></tr>", jumin.getSeason());
		out.print("<tr><th>출생지역</th>");
		out.printf("<td>%s</td></tr>", jumin.getLocal());
		out.print("<tr style = 'text-align : center;'><td colspan = '2'><a href = 'jumin.html' style = 'display : block;'>다시하기</a></td></tr></table></body></html>");   
		
	}

}
