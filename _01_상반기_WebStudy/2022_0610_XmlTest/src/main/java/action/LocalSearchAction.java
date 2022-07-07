package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MySearchUtil;
import vo.LocalVo;

/**
 * Servlet implementation class LocationSearchAction
 */
@WebServlet("/local/search.do")
public class LocalSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LocalSearchAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//location/search.do?search_name=%EB%B3%91%EC%9B%90&page=1&size=15
		request.setCharacterEncoding("utf-8");
		
		//1. parameter 받기
		String search_name = request.getParameter("search_name");
		int page = 1;
		int start = 1;
		double latitude = 37.5045703;
		double longitude = 127.0494465;
		int radius = 5000;
		
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			start = Integer.parseInt(request.getParameter("start"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			latitude = Double.parseDouble(request.getParameter("latitude"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			longitude = Double.parseDouble(request.getParameter("longitude"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//2. 검색 정보 가져오기
		List<LocalVo> list = MySearchUtil.search_kakao_local(search_name, latitude, longitude, radius, page);
		
		//3 request biding
		request.setAttribute("list", list);
		request.setAttribute("start", start);

		//forward
		String forward_page = "local_search.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}

