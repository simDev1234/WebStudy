package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitInsertAction
 */
//@WebServlet("/visit/insert.do") : �տ� / ������ ������ ��Ÿ����. ** / --> webapp
@WebServlet("/visit/insert.do")
public class VisitInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisitInsertAction() {
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//visit/insert.do?name=ȫ�浿&content=������&password=1234
		
		//1. ���� ���ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		//2. parameter �ޱ�
		String name    = request.getParameter("name");
		String content = request.getParameter("content");
		String pwd     = request.getParameter("password");
		
		//content�� \r\n -> <br>�� ����
		content = content.replaceAll("\r\n", "<br>");
		content = content.replaceAll(" ", "&nbsp;");
		
		//3. ip
		String ip      = request.getRemoteAddr(); // �ۼ����� ip
		
		//4. VisitVo�� ����
		VisitVo vo = new VisitVo(name, content, pwd);
		vo.setIp(ip);
		
		//5. DB�� insert
		int res = VisitDao.getInstance().insert(vo);
		
		//6. ��Ϻ���� �̵�
		response.sendRedirect("list.do");

	}

}
