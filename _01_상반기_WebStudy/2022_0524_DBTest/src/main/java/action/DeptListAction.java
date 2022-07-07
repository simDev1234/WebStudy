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

@WebServlet("/dept/list.do")  //url 경로 : 물리적으로 현재 나의 위치 - webapp == url상 자신의 위치 - dept
public class DeptListAction extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//부서목록 요청
		List<DeptVo> list = DeptDao.getInstance().selectList();
		
		//request binding
		request.setAttribute("list", list);
		
		//Dispatcher방식 : View로 forward
		//RequestDispatcher disp = request.getRequestDispatcher("dept_list.jsp");  //404 not found : 현재 나의 경로는 dept인데, 그 안에 없다.
		RequestDispatcher disp = request.getRequestDispatcher("dept_list.jsp"); //webapp안에 dept폴더를 만들고 그 안에 jsp파일을 생성.
		disp.forward(request, response);
		
	}

}
