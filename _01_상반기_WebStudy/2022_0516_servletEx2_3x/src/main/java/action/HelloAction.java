package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */

//Servlet �� http�� ���� ���� ��û���׿� ���� �������� ó���ؼ� html�� ��ȯ���ִ� ���� ��ü 

//Annotation 
//1. ���α׷� �ּ� (2�� �� ������ ��� XML���� Servelet�� Ŭ������ ����ϰ�, URL�� �����Ѵ�) 
//2. Tomcat ��û�ּ� (URL pattern)�� �м� -> �ش� ������ ����
//3. LifeCycleException�� �߻��Ǹ� ������ url-pattern �κп��� �߻��� ����

//URL pattern 
//�� ȣ����
//�Ķ���͸� ���ؼ� ������ �ְ����
@WebServlet("/hello.do")  	//3.0�̻� ������ ���, ��ó�� Annotation�� ����Ѵ�. 
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest request,  //��û ó�� ��ü (client - > ���� ������ �Ѿ���� ����)
			HttpServletResponse response //���� ó�� ��ü (���� -> client������ ���޵Ǵ� ����)
			) throws ServletException, IOException {
		
			String ip = request.getRemoteAddr();
		
		    System.out.printf("[%s]:--HelloAction Call--\n",ip);
		    
		    
		    // ��û������ Query(Parameter)�� ���ؼ� �����Ѵ�. (����)
		    // /2022_0516_servletEx2_3x/hello.do            ---> null
		    // /2022_0516_servletEx2_3x/hello.do?nation=kor
		    // /2022_0516_servletEx2_3x/hello.do?nation=eng
		    // /2022_0516_servletEx2_3x/hello.do?nation=jpn
		    // /2022_0516_servletEx2_3x/hello.do?nation=chn
		    // /2022_0516_servletEx2_3x/hello.do?nation=ger
		    // /2022_0516_servletEx2_3x/hello.do?nation=fra
		    
		    // Parameter �ޱ�
		    String nation = request.getParameter("nation");
		    
		    if (nation == null) nation = "kor";
		    
		    //----�׻� Ŭ���̾�Ʈ���� ���� ���� �� String���ڿ��� �޴´�.
		    String message = "";
		    
		    switch(nation) {
		         case "kor" : message = "[�ѱ���] : �ȳ��ϼ���"; break;
		         case "eng" : message = "[�� ��] : Hi everyone"; break;
		         case "jpn" : message = "[�Ϻ���] : ���۳�������"; break;
		         case "chn" : message = "[�߱���] : ���Ͽ���"; break;
		         case "ger" : message = "[���Ͼ�] : ����Ź"; break;
		         case "fra" : message = "[������] : ���긣"; break;
		         default : message = "[�����Ҹ�] : ����";
		    }
		    
		    
		
		    //����ó��(response �̿�)
		    //1. ���� ���� ���� :        mime type + ���ڵ�
		    //                       text/xml
		    //                       text/json
		    //                       image/jpg
		    //**ContentType�� �߸� ����(��Ÿ) html�� �ν����� ����
		    //**�Ʒ� �����ϸ�, [0:0:0:0:0:0:0:1]? ????? �� ��Ÿ�� << ���ڵ� Ÿ�� ����X
		    response.setContentType("text/html; charset = utf-8;"); //���� �����Ϸ��� ������ text�̸鼭 html���� �˷��� + �� ���ڵ� Ÿ���� �˷��־�� ������ ����
		    
		    //2. ���� ��� ��Ʈ�� ������ *PrintStream (����Ʈ ���� ��Ʈ��) --> ����ȭ�� �� --> PrintWriter
		    PrintWriter out = response.getWriter();
		    
		    //3. �������� HTML ���� ����
		    //write -- ���ڿ��� ���� ���� / print�� ��� ������ Ÿ�� ���� ����
		    out.write("<html>");
		    out.write("<head><title>hello����</title></head>");
		    out.write("<body>");
		    out.printf("[%s]�� (%s)<br>",ip,message);
		    out.write("<a href = 'hello.html'>�ٽ��ϱ�</a>");
		    out.write("</body>");
		    out.write("</html>");
		    
//		    out.println("<html>");
//		    out.println("<head><title>hello����</title></head>");
//		    out.println("<body>");
//		    out.printf("[%s]�� �ȳ��ϼ���<br>",ip);
//		    out.println("</body>");
//		    out.println("</html>");
		    
		    
		    
	}

}
