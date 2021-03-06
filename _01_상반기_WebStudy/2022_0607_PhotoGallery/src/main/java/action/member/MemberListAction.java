package action.member;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberListAction
 */
@WebServlet("/member/list.do")
public class MemberListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberListAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//회원목록 가져오기
		List<MemberVo> list = MemberDao.getInstance().selectList();
		
		//request binding
		request.setCharacterEncoding("utf-8");
		request.setAttribute("list", list);

		//forward
		String forward_page = "member_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}

