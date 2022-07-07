package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitCheckPasswordAction
 */
@WebServlet("/visit/check_pwd.do")
public class VisitCheckPasswordAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisitCheckPasswordAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// /visit/check_pwd.do?idx=11&c_pwd=1234
		// 1. 수신 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		// 2. parameter 받기
		int idx = Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd");
		
		// 3. idx에 해당되는 게시물 정보 얻어오기
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		// 비번체크(동일여부)
		boolean bResult = vo.getPwd().equals(c_pwd);
		
		// 4. JSON 포장
		JSONObject json = new JSONObject();
		json.put("result", bResult); //{"result" : true} or {"result" : false}
		String json_str = json.toJSONString();
		
		// 5. 요청사항을 응답처리
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json_str);
		
	}

}

