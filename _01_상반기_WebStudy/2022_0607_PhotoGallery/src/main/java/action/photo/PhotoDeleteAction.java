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
		
		//���� idx
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		
		//���� ���
		String web_path = "/upload/";
		String abs_path = request.getServletContext().getRealPath(web_path);
		String filename = PhotoDao.getInstance().selectOne(p_idx).getP_filename();
		
		/*
		 * StringBuilder buff = new StringBuilder(); buff.append(abs_path);
		 * buff.append(filename);
		 * String abs_filePath = buff.toString();
		 */
		
		//������ ����
		int res = PhotoDao.getInstance().delete(p_idx);
		
		//���� ����
		//                         ������     ���� �̸�
		File targetFile = new File(abs_path, filename);
		boolean isDelete = false; 
		if (targetFile.exists()) {
			isDelete = targetFile.delete();
		}
		
		//���� ���� ���ο� ���� 
		//�������̵� 
		response.sendRedirect("list.do?isDelete="+isDelete);
		
		
	}


}

