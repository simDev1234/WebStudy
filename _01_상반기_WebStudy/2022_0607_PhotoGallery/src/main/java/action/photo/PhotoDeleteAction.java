package action.photo;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDao;

/**
 * Servlet implementation class PhotoDeleteAction
 */
@WebServlet("/photo/delete.do")
public class PhotoDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhotoDeleteAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//파일 idx
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		
		//파일 경로
		String web_path = "/upload/";
		String abs_path = request.getServletContext().getRealPath(web_path);
		String filename = PhotoDao.getInstance().selectOne(p_idx).getP_filename();
		
		/*
		 * StringBuilder buff = new StringBuilder(); buff.append(abs_path);
		 * buff.append(filename);
		 * String abs_filePath = buff.toString();
		 */
		
		//데이터 삭제
		int res = PhotoDao.getInstance().delete(p_idx);
		
		//파일 삭제
		//                         절대경로     파일 이름
		File targetFile = new File(abs_path, filename);
		boolean isDelete = false; 
		if (targetFile.exists()) {
			isDelete = targetFile.delete();
		}
		
		//파일 삭제 여부에 따라 
		//페이지이동 
		response.sendRedirect("list.do?isDelete="+isDelete);
		
		
	}


}

