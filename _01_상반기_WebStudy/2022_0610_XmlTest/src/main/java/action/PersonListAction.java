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
			//Parser생성
			SAXBuilder builder = new SAXBuilder();
			
			String path = request.getServletContext().getRealPath("/");
			File f = new File(path, "person.xml");
			
			//전체 문서 정보 구함
			Document doc = builder.build(f);
			
			//Root Element 정보를 구한다. -- <persons>
			Element root = doc.getRootElement();
			
			//Root Element의 하위요소
			List<Element> person_list = root.getChildren("person");
			
			for(Element person : person_list) {
				
				//Element값 얻어오기
				String name = person.getChildText("name"); //name이라는 이름의 child element의 text를 가져온다.
				
				//Attribute 얻어오기
				String nickname = person.getChild("name").getAttributeValue("nickname"); //name element의 "nickname" 속성의 값 가져오기
				
				int age = 0;
				
				try {
					age = Integer.parseInt(person.getChildText("age"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				String tel = person.getChildText("tel");
				String hometel = person.getChild("tel").getAttributeValue("hometel");
				
				//Vo 포장
				PersonVo vo = new PersonVo(name, nickname, age, tel, hometel);
				
				//ArrayList에 추가
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

