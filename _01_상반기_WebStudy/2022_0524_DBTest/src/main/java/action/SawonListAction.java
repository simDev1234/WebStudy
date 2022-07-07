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

@WebServlet("/sawon/list.do")
public class SawonListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//何辑格废 夸没
		List<SawonVo> list = SawonDao.getInstance().selectList();
		
		//request binding
		request.setAttribute("list",list);
		
		//dispatcher 傈价
		RequestDispatcher disp = request.getRequestDispatcher("sawon_list.jsp");
		disp.forward(request, response);
		
	}

}
