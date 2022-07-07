package action.photo;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import dao.PhotoDao;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoUploadAction
 */
@WebServlet("/photo/photo_upload.do")
public class PhotoUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhotoUploadAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1. ������ (������)
		String path = request.getServletContext().getRealPath("/upload/");
		
		//2. ���ε� �ִ�뷮
		int max_size = 1024*1024*100;
		
		//3. ���ε� ���� ó��
		                                        //         ������ġ   �ִ�ũ��     ���ڵ�       ��������->�̸���������
		MultipartRequest mr = new MultipartRequest(request, path, max_size, "utf-8", new DefaultFileRenamePolicy());
		
		//4. parameter �ޱ�
		int p_idx = Integer.parseInt(mr.getParameter("p_idx"));
		
		//5. �������� ����
		PhotoVo originVo = PhotoDao.getInstance().selectOne(p_idx);
		File deleteFile = new File(path, originVo.getP_filename());
		deleteFile.delete();
		
		//6. ���ε� ���� �̸� ������
		String p_filename = mr.getOriginalFileName("photo");
		//������ ������
		if(p_filename == null) p_filename = "no_file";
		
		//7. DB update_filename 
		PhotoVo vo = new PhotoVo();
		vo.setP_idx(p_idx);
		vo.setP_filename(p_filename);
		
		int res = PhotoDao.getInstance().update_filename(vo);
		
		//8. ������� : JSON = {"p_filename":"a.jpg"}
		JSONObject json = new JSONObject();
		json.put("p_filename", p_filename);
		
		String json_str = json.toJSONString();
		response.setContentType("text/json; chearset=utf-8");
		response.getWriter().print(json_str);
		
	}

}

