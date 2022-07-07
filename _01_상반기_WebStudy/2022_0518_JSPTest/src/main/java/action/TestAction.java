package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestAction
 */
@WebServlet("/test.do")
public class TestAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//맴버변수 선언
	int a = 10;
	
	//맴버메소드
	void sub() {
		
	}
	
	protected void service(HttpServletRequest request, 
			               HttpServletResponse response) 
			               throws ServletException, IOException {

		
		
	}

}
