package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�Է� : HTTP�� ���� ���� ���� parameter �ޱ�
		String jumin_no = request.getParameter("jumin_no");
		request.setCharacterEncoding("utf-8");
		
		//ó�� : Jumin��ü Ȱ��
		Jumin jumin = new Jumin();
		jumin.setJumin_no(jumin_no);
		boolean bValid = jumin.isValid();
		
		//validation 
		request.setAttribute("bValid", bValid);
	    request.setAttribute("jumin_no", jumin_no);
	    request.setAttribute("jumin_year", jumin.getYear());
	    request.setAttribute("jumin_ganji", jumin.getGanji());
	    request.setAttribute("jumin_age", jumin.getAge());
	    request.setAttribute("jumin_gender", jumin.getGender());
	    request.setAttribute("jumin_tti", jumin.getTti());
	    request.setAttribute("jumin_season", jumin.getSeason());
	    request.setAttribute("jumin_local", jumin.getLocal());
		
		//��� ���� : �ٸ� �������� ó������ ������
		RequestDispatcher disp = request.getRequestDispatcher("jumin_result.jsp");
		disp.forward(request, response);
	}

}
