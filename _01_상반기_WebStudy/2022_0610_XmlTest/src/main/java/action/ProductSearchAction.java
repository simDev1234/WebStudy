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
import vo.ProductVo;

/**
 * Servlet implementation class ProductSearchAction
 */
@WebServlet("/product/search.do")
public class ProductSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductSearchAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		///product/search.do?/p_name=노트북&start=11&display=10
		request.setCharacterEncoding("utf-8");
		
		//1. parameter 받기
		String p_name = request.getParameter("p_name");
		
		int start = 1;
		int display = 10;
		
		try {
			start   = Integer.parseInt(request.getParameter("start"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			display = Integer.parseInt(request.getParameter("display"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//검색정보 가져오기
		List<ProductVo> list = MySearchUtil.search_shop(p_name, start, display);
		
		//2. request_binding
		request.setAttribute("list", list);
		request.setAttribute("start", start);

		//forward
		String forward_page = "product_search.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}

