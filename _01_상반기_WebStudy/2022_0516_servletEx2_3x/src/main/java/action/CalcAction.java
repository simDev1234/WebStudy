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
		//�Է� : parameter �ޱ� (� ������Ÿ���̰� String���� �ް� �Ǿ� �ִ�.)
		String su1 = request.getParameter("su1");
		String su2 = request.getParameter("su2");
		
		//ó��
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
		
		//���
		//����ó��
		response.setContentType("text/html; charset = utf-8"); 
		//��°�ü ������
		PrintWriter out = response.getWriter(); 
		
		//html ��� ����
		out.write("<html><head><title>calc����</title></head><body>");
		out.write("::::�����::::<br>");
		
		for (int i = 0; i < results.length; i++) {
			if ((calcs.charAt(i) == '/' || calcs.charAt(i) == '%') && y == 0) {
				out.print("0���� ���� �� �����ϴ�.<br>");
			}else {
				out.printf("%d%c%d=%d<br>",x,calcs.charAt(i),y,results[i]);
			}
		}
		
		out.write("<a href = 'calc.html'>�ٽ��ϱ�</a></body></html>");
		
	}

}
