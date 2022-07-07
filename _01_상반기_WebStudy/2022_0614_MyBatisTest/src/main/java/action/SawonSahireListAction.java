package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import vo.SawonVo;

/**
 * Servlet implementation class SawonSahireListAction
 */
@WebServlet("/sawon/sahire_list.do")
public class SawonSahireListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SawonSahireListAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// /sawon/sahire_list.do?start=1993&end=2000
		int start = 0;
		int end = 0;
		
		try {
			start = Integer.parseInt(request.getParameter("start"));
			end = Integer.parseInt(request.getParameter("end"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//Map포장
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		
		//DAO에서 사원 목록 가져오기
		List<SawonVo> list = SawonDao.getInstance().selectListSahire(map);
		
		request.setAttribute("list", list);

		//forward
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}

