package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SungDao;
import vo.SungVo;

/**
 * Servlet implementation class SungModifyFormAction
 */
@WebServlet("/sung/modify_form.do")
public class SungModifyFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SungModifyFormAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idx = Integer.parseInt(request.getParameter("idx"));
		//SungVo 객체 1건 얻어오기
		SungVo vo = SungDao.getInstance().selectOne(idx);
		
		//request binding
		request.setAttribute("vo", vo);

		//forward
		String forward_page = "sung_modify_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}

