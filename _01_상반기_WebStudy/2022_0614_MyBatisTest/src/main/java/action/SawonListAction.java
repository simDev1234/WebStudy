package action;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.SawonDao;
import vo.SawonVo;

/**
 * Servlet implementation class SawonListAction
 */
@WebServlet("/sawon/list.do")
public class SawonListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SawonListAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// /sawon/list.do ---> error(deptno를 기본적으로 0으로 준다)
		// /sawon/list.do?deptno=0  ---> 
		// /sawon/list.do?deptno=10 --->
		
		int deptno = 0;
		
		try {
			deptno = Integer.parseInt(request.getParameter("deptno"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		List<SawonVo> list = SawonDao.getInstance().selectList();
		
		if(deptno==0) {//전체조회
			list = SawonDao.getInstance().selectList();
		}else {//부서별조회
			list= SawonDao.getInstance().selectListDeptno(deptno);
		}
		
		//request binding
		request.setAttribute("list", list);

		//forward
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}

