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
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//입력 : parameter 받기 (어떤 데이터타입이건 String으로 받게 되어 있다.)
		String su1 = request.getParameter("su1");
		String su2 = request.getParameter("su2");
		
		//처리
		int[] results = new int[5];
		String calcs = "+-*/%";
		int x = Integer.parseInt(su1);
		int y = Integer.parseInt(su2);
		
		results[0] = x + y;
		results[1] = x - y;
		results[2] = x * y;
		
		if (y != 0) {
			results[3] = x / y;
			results[4] = x % y;
		}
		
		//출력
		//응답처리
		response.setContentType("text/html; charset = utf-8"); 
		//출력객체 얻어오기
		PrintWriter out = response.getWriter(); 
		
		//html 결과 전송
		out.write("<html><head><title>calc응답</title></head><body>");
		out.write("::::계산결과::::<br>");
		
		for (int i = 0; i < results.length; i++) {
			if ((calcs.charAt(i) == '/' || calcs.charAt(i) == '%') && y == 0) {
				out.print("0으로 나눌 수 없습니다.<br>");
			}else {
				out.printf("%d%c%d=%d<br>",x,calcs.charAt(i),y,results[i]);
			}
		}
		
		out.write("<a href = 'calc.html'>다시하기</a></body></html>");
		
	}

}
