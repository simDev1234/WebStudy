package action.photo;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import dao.PhotoDao;
import vo.MemberVo;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoInsertAction
 */
@WebServlet("/photo/insert.do")
public class PhotoInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhotoInsertAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//0. 로그인 정보 읽어오기 (세션 정보 확인)
		//로그인한 회원 객체
		MemberVo user = (MemberVo) request.getSession().getAttribute("user"); 
		
		//세션이 만료된 경우
		if (user == null) {
			response.sendRedirect("../member/login_form.do?reason=session_timeout");
			return;
		}

		//1. 저장 경로 설정
		String web_path = "/upload/";
		String abs_path = request.getServletContext().getRealPath(web_path);
		
		//2. 업로드 크기 설정
		int max_size = 1024*1024*100; //100MB
		
		//3. MultipartRequest
		MultipartRequest mr = new MultipartRequest(request, abs_path, max_size, "utf-8", new DefaultFileRenamePolicy());
		
		//4. 나머지 파라메터 수신
		String p_subject = mr.getParameter("p_subject");  //제목
		String p_content = mr.getParameter("p_content").replaceAll("\r\n","<br>"); //내용
		String p_filename = "no_file"; //파일
		int m_idx = user.getM_idx(); //user의 m_idx
		
		File file = mr.getFile("p_photo");
		
		if (file != null) {
			p_filename = file.getName();
		}
		
		String p_ip = request.getRemoteAddr(); //아이피
		
		//5. PhotoVo 포장
		//PhotoVo(String p_subject, String p_content, String p_filename, String p_ip, int m_idx)
		PhotoVo p_vo = new PhotoVo(p_subject, p_content, p_filename, p_ip, m_idx);
		
		//6. DB insert
		int res = PhotoDao.getInstance().insert(p_vo);

		//7. 목록보기로 이동
		response.sendRedirect("list.do");
	}

}

