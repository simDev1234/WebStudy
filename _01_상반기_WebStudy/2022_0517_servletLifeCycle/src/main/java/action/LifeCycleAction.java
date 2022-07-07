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
	
	//1~2 : ��ü ���� �� �ʱ�ȭ   ---- ���� ���� 1ȸ�� (������ �̱��� ���)
	/*
	----1.LifeCycleAction()----
	----2.init()----
	----3.service()----   <== A������
	----3.service()----   <== B������
	----3.service()----   <== C������
	----3.service()----   <== D������
	----4.destroy()----   <======== ���� ����Ǵ°�? ������ ���� ����� �� 
	                                * ��Ŭ�������� �����ϸ� destroy �Ǵµ�? 
	                                  : ��Ŭ�������� �����ϴ� ���� �����ϵǸ鼭 Tomcat�� ���� ������ ������ ����������. -- ���������� ���� ������ �Ͱ� ���� ȿ��
	                                * Servers > Tomcat > context.xml > <Context privileged="true" reloadable="true">
	                                  : reloadable ) ���ε� �� �� ������ ���� Ű�� �ʰ�, �������� ���ε��ϰڴٴ� �ǹ�
	----1.LifeCycleAction()----  <==== �ٽ� �����ϸ�, ����/�ʱ�ȭ�� �ٽ��Ѵ�.
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
