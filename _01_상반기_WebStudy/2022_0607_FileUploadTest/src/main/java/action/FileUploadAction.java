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
 * Servlet implementation class FileUploadAction
 */
@WebServlet("/upload.do")
public class FileUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// (POST) /upload.do?title=배경&photo=back.jsp
		// 화일 업로드 처리 객체(MultipartRequest)가 처리해야 된다.
		//MultipartRequest mr = new MultipartRequest(수신 정보 위임, 저장경로(절대경로), 파일최대크기, 인코딩, 동일 파일이 업로드 되면 이름을 바꿔서 저장);
		//저장위치
		String web_path = "/upload/"; 
		//String path = "C:\\Work\\WebStudy\\WebLecture\\upload"; //절대경로 요구
		//현재 웹 컨텍스트(프로그램) 전역을 관리하는 객체
		ServletContext application = request.getServletContext(); 
		//WebPath(웹 경로) - > AbsPath(절대경로) 로 전환
		String path = application.getRealPath(web_path);
		System.out.println(path);
		
		//업로드최대크기 (byte)
		int max_size = 1024*1024*100; //1MB : 1024*1024, 100MB : 1024*1024*100
		MultipartRequest mr = new MultipartRequest(request, path, max_size, "utf-8", new DefaultFileRenamePolicy());

		//방법1 : 업로드된 파일명을 구하기
		String filename = "no_file";
//		File f = mr.getFile("photo");
		//업로드된 파일이 있으면
//		if (f != null) {
//			filename = f.getName(); //파일명을 구해라.
//		    String abs_path = f.getAbsolutePath(); //파일의 절대경로도 구할 수 있음
//		}
		
		//방법2
		filename = mr.getOriginalFileName("photo");
		if (filename == null) {
			filename = "no_file"; //파일명을 구해라.
		}
		System.out.println(filename);
		
		//타이틀(parameter)받기 -> mr로 받아라..
		String title = mr.getParameter("title");
		System.out.println(title);
		
		//단, 상대방 IP정보는 request로 받는다.
		String ip = request.getRemoteAddr();
		
		//request binding
		request.setAttribute("title", title);
		request.setAttribute("filename", filename);
		
		//forward
		String forward_page = "result_upload.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}

