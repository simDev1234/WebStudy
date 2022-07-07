package action.photo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDao;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoModifyAction
 */
@WebServlet("/photo/modify.do")
public class PhotoModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhotoModifyAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1. �������ڵ�
		request.setCharacterEncoding("utf-8");
		
		//2. parameter �ޱ�
		///photo/modify.do?p_idx=9&p_subject=�׽�Ʈ2&p_content=test
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		String p_subject = request.getParameter("p_subject");
		String p_content = request.getParameter("p_content");
		
		//3. ip���ϱ�
		String p_ip = request.getRemoteAddr();
		
		//4. ����
		PhotoVo vo = new PhotoVo(p_idx, p_subject, p_content, p_ip);
		
		//5. DB ����
		int res = PhotoDao.getInstance().update(vo);
		
		//6. ������ �̵�
		response.sendRedirect("list.do");
		
	}

}

