package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitUpdateAction
 */
@WebServlet("/visit/modify_form.do")
public class VisitModifyFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisitModifyFormAction() {
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//인코딩방식
		request.setCharacterEncoding("utf-8");

		//idx에 해당되는 객체 1건 구하기
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		String content = vo.getContent();
		content = content.replaceAll("<br>","\r\n");
		content = content.replaceAll("&nbsp;"," ");
		vo.setContent(content);
		
		request.setAttribute("vo", vo);

		//forward
		String forward_page = "visit_modify_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}
