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
//@WebServlet("/visit/insert.do") : 앞에 / 빠지면 오류가 나타난다. ** / --> webapp
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

		//visit/insert.do?name=홍길동&content=ㅇㅇㅇ&password=1234
		
		//1. 수신 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//2. parameter 받기
		String name    = request.getParameter("name");
		String content = request.getParameter("content");
		String pwd     = request.getParameter("password");
		
		//content에 \r\n -> <br>로 변경
		content = content.replaceAll("\r\n", "<br>");
		content = content.replaceAll(" ", "&nbsp;");
		
		//3. ip
		String ip      = request.getRemoteAddr(); // 작성자의 ip
		
		//4. VisitVo로 포장
		VisitVo vo = new VisitVo(name, content, pwd);
		vo.setIp(ip);
		
		//5. DB에 insert
		int res = VisitDao.getInstance().insert(vo);
		
		//6. 목록보기로 이동
		response.sendRedirect("list.do");

	}

}
