package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberModifyAction
 */
@WebServlet("/member/modify.do")
public class MemberModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberModifyAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		///member/modify.do?m_idx=1&m_name=일길동&m_id=one&m_pwd=1234&m_zipcode=12345&m_addr=서울시+마포구+노고산동&m_grade=일반
		
		//1. 수신 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//2. parameter 받기
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		String m_name = request.getParameter("m_name");
		String m_id  = request.getParameter("m_id");
		String m_pwd  = request.getParameter("m_pwd");
		String m_zipcode  = request.getParameter("m_zipcode");
		String m_addr  = request.getParameter("m_addr");
		String m_grade = request.getParameter("m_grade");
		
		//ip얻어오기
		String m_ip = request.getRemoteAddr();
		
		//3. MemberVo로 포장하기
		MemberVo vo = new MemberVo(m_idx, m_name, m_id, m_pwd, m_zipcode, m_addr, m_grade, m_ip);
		
		//4. DB 수정하기
		int res = MemberDao.getInstance().update(vo);

		//5. sendRedirect
		response.sendRedirect("list.do");
	}

}

