package action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcAction
 */
@WebServlet("/calc.do")
public class CalcAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalcAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		// /calc.do?su1=10&su2=20&op=+
		// /calc.do?su1=10&su2=20&op=-
		// /calc.do?su1=10&su2=20&op=*
		// /calc.do?su1=10&su2=20&op=/
		String op = request.getParameter("op");
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		
		PrintWriter writer = response.getWriter();
		
		//연산자별 응답처리
		if(op.equals("+")) {
			writer.print(su1+su2);
		}else if (op.equals("-")) {
			writer.print(su1-su2);
		}else if (op.equals("*")) {
			writer.print(su1*su2);
		}else if (op.equals("/")) {
			int result = su2 == 0? 0 : su1/su2;
			writer.print(result);
		}
		
		
		
	}

}

