package action;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUploadAction2
 */
@WebServlet("/upload2.do")
public class FileUploadAction2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadAction2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1. 파일 업로드 객체 
		
		//경로 설정 (웹 경로)
		String web_path = "/upload2/"; //서블릿 실행시 웹 저장 경로
		ServletContext application = request.getServletContext(); //현재 앱 관리객체
		String abs_path = application.getRealPath(web_path); //현재 앱 관리객체가 알려준 web_path 절대 경로
		
		//파일 최대 크기 (1KB = 1024 / 1MB = 1024KB)
		int max_size = 1024*1024*100;
		
		//파일 업로드 처리 객체 생성 & 초기화
		MultipartRequest mr = new MultipartRequest(request, abs_path, max_size, "utf-8", new DefaultFileRenamePolicy());
		
		//2. DATA 처리
		//1) 업로드된 파일의 파일명 구하기
		File file1 = mr.getFile("photo1");
		File file2 = mr.getFile("photo2");
		
		String filename1 = "no_file";
		String filename2 = "no_file";
		
		if (file1 != null) {
			filename1 = file1.getName();
		}
		
		if (file2 != null) {
			filename2 = file2.getName();
		}
		
		//2) input "title" 의 데이터 받기
		String title = mr.getParameter("title");
		
		//3) data 전송 ip 받기
		String ip = request.getRemoteAddr();
		
		//3. 처리한 데이터를 request binding
		request.setAttribute("filename1", filename1);
		request.setAttribute("filename2", filename2);
		request.setAttribute("title", title);
		request.setAttribute("ip", ip);
		
		//4. forwarding
		String forward_page = "result_upload2.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
	}

}

