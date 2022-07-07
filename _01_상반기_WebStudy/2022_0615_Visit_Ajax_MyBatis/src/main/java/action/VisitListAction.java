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

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitListAction
 */
@WebServlet("/visit/list.do")
public class VisitListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisitListAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// /visit/list.do?search=all&search_textddd
		
		//1. ���� ���ڵ�
		request.setCharacterEncoding("utf-8");
		
		//2. parameter �ޱ�
		String search = request.getParameter("search");
		String search_text = request.getParameter("search_text");
		
		if(search == null || search.isEmpty()) search = "all";
		
		//�˻� ������ ���� Map
		Map<String, String> map = new HashMap<String, String>();
		
		if(!search.equals("all")) { //��ü�˻��� �ƴϸ� 
			
			if(search.equals("name_content")) { //�̸� + ����
				
				map.put("name", search_text);
				map.put("content", search_text);
				
			}else if(search.equals("name")) { //�̸�
				
				map.put("name", search_text);
				
			}else if(search.equals("content")) { //����
				
				map.put("content", search_text);
				
			}
			
		}
		
		//��� ��������
		List<VisitVo> list = VisitDao.getInstance().selectList(map);
		
		//request binding
		request.setAttribute("list", list);

		//forward
		String forward_page = "visit_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}

