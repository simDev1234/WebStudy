package action;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleAction
 */
@WebServlet("/lifecycle.do")
public class LifeCycleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//1~2 : 객체 생성 및 초기화   ---- 최초 실행 1회만 (일종의 싱글톤 방식)
	/*
	----1.LifeCycleAction()----
	----2.init()----
	----3.service()----   <== A쓰레드
	----3.service()----   <== B쓰레드
	----3.service()----   <== C쓰레드
	----3.service()----   <== D쓰레드
	----4.destroy()----   <======== 언제 종료되는가? 원래는 서버 종료될 때 
	                                * 이클립스에서 저장하면 destroy 되는데? 
	                                  : 이클립스에서 저장하는 순간 컴파일되면서 Tomcat이 이전 버전의 서블렛을 내려버린다. -- 인위적으로 서버 종료한 것과 같은 효과
	                                * Servers > Tomcat > context.xml > <Context privileged="true" reloadable="true">
	                                  : reloadable ) 리로드 할 때 서버를 껐다 키지 않고, 컨텐츠만 리로드하겠다는 의미
	----1.LifeCycleAction()----  <==== 다시 구동하면, 생성/초기화를 다시한다.
	----2.init()----
	----3.service()----
	*/
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleAction() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("----1.LifeCycleAction()----");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("----2.init()----");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("----4.destroy()----");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("----3.service()----");
		
		//super.service(request, response);
		
		String method = request.getMethod();
		
		if (method.equals("GET"))
			doGet(request,response);
		else if (method.equals("POST"))
			doPost(request,response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("----3-1.doGet()----");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("----3-2.doPost()----");
	}

}
