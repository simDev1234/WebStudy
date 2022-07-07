package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitModifyAction
 */
@WebServlet("/visit/modify.do")
public class VisitModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisitModifyAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1. 수신 인코딩 설명
		request.setCharacterEncoding("utf-8");
		
		//2. param 수신/포장
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		
		//content 띄어쓰기, 줄바꿈 세팅
		content = content.replaceAll("\r\n", "<br>");
		content = content.replaceAll(" ", "&nbsp;");
		
		VisitVo vo = new VisitVo();
		vo.setIdx(idx);
		vo.setName(name);
		vo.setContent(content);
		int res = VisitDao.getInstance().update(vo);

		//3. 이동
		response.sendRedirect("list.do");
		
	}

}

