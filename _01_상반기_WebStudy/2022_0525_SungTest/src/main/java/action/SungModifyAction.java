package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SungDao;
import vo.SungVo;

/**
 * Servlet implementation class SungModifyAction
 */
@WebServlet("/sung/modify.do")
public class SungModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SungModifyAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1. 수신 인코딩 설정
		request.setCharacterEncoding("utf-8");
	
		//2. parameter(전달인자) 수신 / 포장
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		int    kor  = Integer.parseInt(request.getParameter("kor"));
		int    eng  = Integer.parseInt(request.getParameter("eng"));
		int    mat  = Integer.parseInt(request.getParameter("mat"));
		
		//3. 포장
		SungVo vo = new SungVo(idx, name, kor, eng, mat);
		
		//4. DB update
		int res = SungDao.getInstance().update(vo);
		
		//redirect (목록보기)
		response.sendRedirect("list.do");
		
	}

}

