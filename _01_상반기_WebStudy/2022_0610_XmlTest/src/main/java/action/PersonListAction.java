package action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import vo.PersonVo;

/**
 * Servlet implementation class PersonListAction
 */
@WebServlet("/person/list.do")
public class PersonListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonListAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<PersonVo> list = new ArrayList<PersonVo>();
		
		//XML Parsing 
		try {
			//Parser����
			SAXBuilder builder = new SAXBuilder();
			
			String path = request.getServletContext().getRealPath("/");
			File f = new File(path, "person.xml");
			
			//��ü ���� ���� ����
			Document doc = builder.build(f);
			
			//Root Element ������ ���Ѵ�. -- <persons>
			Element root = doc.getRootElement();
			
			//Root Element�� �������
			List<Element> person_list = root.getChildren("person");
			
			for(Element person : person_list) {
				
				//Element�� ������
				String name = person.getChildText("name"); //name�̶�� �̸��� child element�� text�� �����´�.
				
				//Attribute ������
				String nickname = person.getChild("name").getAttributeValue("nickname"); //name element�� "nickname" �Ӽ��� �� ��������
				
				int age = 0;
				
				try {
					age = Integer.parseInt(person.getChildText("age"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				String tel = person.getChildText("tel");
				String hometel = person.getChild("tel").getAttributeValue("hometel");
				
				//Vo ����
				PersonVo vo = new PersonVo(name, nickname, age, tel, hometel);
				
				//ArrayList�� �߰�
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//request binding
		request.setAttribute("list", list);

		//forward
		String forward_page = "person_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}

