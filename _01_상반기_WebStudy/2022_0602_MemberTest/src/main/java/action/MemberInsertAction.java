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
 * Servlet implementation class MemberInsertAction
 */
@WebServlet("/member/insert.do")
public class MemberInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberInsertAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//member/insert.do?m_name=dddd&m_id=dddd&m_pwd=dddd&m_zipcode=dddd&m_addr=dddd
		
		//1.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//2.parameter 받기
		String m_name = request.getParameter("m_name");
		String m_id = request.getParameter("m_id");
		String m_pwd = request.getParameter("m_pwd");
		String m_zipcode = request.getParameter("m_zipcode");
		String m_addr = request.getParameter("m_addr");
		
		//3. ip구하기
		String m_ip = request.getRemoteAddr();
		
		//4.포장
		MemberVo vo = new MemberVo(m_name, m_id, m_pwd, m_zipcode, m_addr, "일반", m_ip);
		
		//5.DB와 연결 & insert
		int res = MemberDao.getInstance().insert(vo);
		
		//6.redirect
        response.sendRedirect("list.do");
	}

}
