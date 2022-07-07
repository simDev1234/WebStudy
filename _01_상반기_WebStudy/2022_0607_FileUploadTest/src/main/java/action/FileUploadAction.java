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

		// (POST) /upload.do?title=���&photo=back.jsp
		// ȭ�� ���ε� ó�� ��ü(MultipartRequest)�� ó���ؾ� �ȴ�.
		//MultipartRequest mr = new MultipartRequest(���� ���� ����, ������(������), �����ִ�ũ��, ���ڵ�, ���� ������ ���ε� �Ǹ� �̸��� �ٲ㼭 ����);
		//������ġ
		String web_path = "/upload/"; 
		//String path = "C:\\Work\\WebStudy\\WebLecture\\upload"; //������ �䱸
		//���� �� ���ؽ�Ʈ(���α׷�) ������ �����ϴ� ��ü
		ServletContext application = request.getServletContext(); 
		//WebPath(�� ���) - > AbsPath(������) �� ��ȯ
		String path = application.getRealPath(web_path);
		System.out.println(path);
		
		//���ε��ִ�ũ�� (byte)
		int max_size = 1024*1024*100; //1MB : 1024*1024, 100MB : 1024*1024*100
		MultipartRequest mr = new MultipartRequest(request, path, max_size, "utf-8", new DefaultFileRenamePolicy());

		//���1 : ���ε�� ���ϸ��� ���ϱ�
		String filename = "no_file";
//		File f = mr.getFile("photo");
		//���ε�� ������ ������
//		if (f != null) {
//			filename = f.getName(); //���ϸ��� ���ض�.
//		    String abs_path = f.getAbsolutePath(); //������ �����ε� ���� �� ����
//		}
		
		//���2
		filename = mr.getOriginalFileName("photo");
		if (filename == null) {
			filename = "no_file"; //���ϸ��� ���ض�.
		}
		System.out.println(filename);
		
		//Ÿ��Ʋ(parameter)�ޱ� -> mr�� �޾ƶ�..
		String title = mr.getParameter("title");
		System.out.println(title);
		
		//��, ���� IP������ request�� �޴´�.
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

