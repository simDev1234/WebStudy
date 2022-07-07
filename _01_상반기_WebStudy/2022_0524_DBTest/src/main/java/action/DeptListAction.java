package action;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DeptDao;
import vo.DeptVo;

@WebServlet("/dept/list.do")  //url ��� : ���������� ���� ���� ��ġ - webapp == url�� �ڽ��� ��ġ - dept
public class DeptListAction extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�μ���� ��û
		List<DeptVo> list = DeptDao.getInstance().selectList();
		
		//request binding
		request.setAttribute("list", list);
		
		//Dispatcher��� : View�� forward
		//RequestDispatcher disp = request.getRequestDispatcher("dept_list.jsp");  //404 not found : ���� ���� ��δ� dept�ε�, �� �ȿ� ����.
		RequestDispatcher disp = request.getRequestDispatcher("dept_list.jsp"); //webapp�ȿ� dept������ ����� �� �ȿ� jsp������ ����.
		disp.forward(request, response);
		
	}

}
