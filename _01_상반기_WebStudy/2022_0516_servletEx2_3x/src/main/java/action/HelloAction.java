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

//Servlet 은 http로 전달 받은 요청사항에 대해 동적으로 처리해서 html로 반환해주는 서비스 객체 

//Annotation 
//1. 프로그램 주석 (2점 대 서블릿의 경우 XML에서 Servelet의 클래스를 명명하고, URL을 맵핑한다) 
//2. Tomcat 요청주소 (URL pattern)를 분석 -> 해당 서블릿을 구동
//3. LifeCycleException이 발생되면 무조건 url-pattern 부분에서 발생된 에러

//URL pattern 
//ㄴ 호출방법
//파라미터를 통해서 정보를 주고받음
@WebServlet("/hello.do")  	//3.0이상 버전의 경우, 이처럼 Annotation을 사용한다. 
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
			HttpServletRequest request,  //요청 처리 객체 (client - > 서버 측으로 넘어오는 정보)
			HttpServletResponse response //응답 처리 객체 (서버 -> client측으로 전달되는 정보)
			) throws ServletException, IOException {
		
			String ip = request.getRemoteAddr();
		
		    System.out.printf("[%s]:--HelloAction Call--\n",ip);
		    
		    
		    // 요청사항을 Query(Parameter)를 통해서 전달한다. (고객이)
		    // /2022_0516_servletEx2_3x/hello.do            ---> null
		    // /2022_0516_servletEx2_3x/hello.do?nation=kor
		    // /2022_0516_servletEx2_3x/hello.do?nation=eng
		    // /2022_0516_servletEx2_3x/hello.do?nation=jpn
		    // /2022_0516_servletEx2_3x/hello.do?nation=chn
		    // /2022_0516_servletEx2_3x/hello.do?nation=ger
		    // /2022_0516_servletEx2_3x/hello.do?nation=fra
		    
		    // Parameter 받기
		    String nation = request.getParameter("nation");
		    
		    if (nation == null) nation = "kor";
		    
		    //----항상 클라이언트에서 값을 받을 때 String문자열로 받는다.
		    String message = "";
		    
		    switch(nation) {
		         case "kor" : message = "[한국어] : 안녕하세요"; break;
		         case "eng" : message = "[영 어] : Hi everyone"; break;
		         case "jpn" : message = "[일본어] : 오겡끼데스까"; break;
		         case "chn" : message = "[중국어] : 니하오마"; break;
		         case "ger" : message = "[독일어] : 구텐탁"; break;
		         case "fra" : message = "[프랑스] : 봉쥬르"; break;
		         default : message = "[국적불명] : 몰라";
		    }
		    
		    
		
		    //응답처리(response 이용)
		    //1. 전송 문서 정보 :        mime type + 인코딩
		    //                       text/xml
		    //                       text/json
		    //                       image/jpg
		    //**ContentType을 잘못 쓰면(오타) html로 인식하지 못함
		    //**아래 생략하면, [0:0:0:0:0:0:0:1]? ????? 로 나타남 << 인코딩 타입 전달X
		    response.setContentType("text/html; charset = utf-8;"); //내가 전달하려는 문서는 text이면서 html임을 알려줌 + 꼭 인코딩 타입을 알려주어야 깨지지 않음
		    
		    //2. 문자 출력 스트림 얻어오기 *PrintStream (바이트 단위 스트림) --> 문자화한 것 --> PrintWriter
		    PrintWriter out = response.getWriter();
		    
		    //3. 동적으로 HTML 생성 전송
		    //write -- 문자열만 전송 가능 / print는 모든 데이터 타입 전송 가능
		    out.write("<html>");
		    out.write("<head><title>hello응답</title></head>");
		    out.write("<body>");
		    out.printf("[%s]님 (%s)<br>",ip,message);
		    out.write("<a href = 'hello.html'>다시하기</a>");
		    out.write("</body>");
		    out.write("</html>");
		    
//		    out.println("<html>");
//		    out.println("<head><title>hello응답</title></head>");
//		    out.println("<body>");
//		    out.printf("[%s]님 안녕하세요<br>",ip);
//		    out.println("</body>");
//		    out.println("</html>");
		    
		    
		    
	}

}
