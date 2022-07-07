package util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import vo.LocalVo;
import vo.ProductVo;

public class MySearchUtil {
                                                   //query
	public static List<ProductVo> search_shop(String p_name,int start,int display)
	{
		List<ProductVo> list = new ArrayList<ProductVo>();
		String clientId = "eNqZei9ZHBpKZTWfc8p1";
		String clientSecret = "6wxnkMXVaI";

		try {
			p_name = URLEncoder.encode(p_name, "utf-8");
			String urlStr = String.format("https://openapi.naver.com/v1/search/shop.xml?query=%s&start=%d&display=%d",
					         p_name,start,display
					);

			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			//발급받은 ID
			connection.setRequestProperty("X-Naver-Client-Id", clientId); 
			//발급받은 PW
			connection.setRequestProperty("X-Naver-Client-Secret", clientSecret); 
			// 받을요청타입
			connection.setRequestProperty("Content-Type", "application/xml"); 
			connection.connect();

			SAXBuilder builder = new SAXBuilder();
			Document   doc = builder.build (connection.getInputStream());

			Element  root     = doc.getRootElement(); //<rss>
			List<Element> element_list = root.getChild("channel").getChildren("item");

			for(Element item : element_list){
				String title = item.getChildText("title");
				String link  = item.getChildText("link");
				String image = item.getChildText("image");
				int lprice=0,hprice=0;
				try {
					lprice = Integer.parseInt(item.getChildText("lprice"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				try {
					hprice = Integer.parseInt(item.getChildText("hprice"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				String mallName = item.getChildText("mallName");
				
				//상품목록을 포장
				ProductVo vo = new ProductVo();
				vo.setTitle(title);
				vo.setLink(link);
				vo.setImage(image);
				vo.setLprice(lprice);
				vo.setHprice(hprice);
				vo.setMallName(mallName);
								
				//ArrayList에 넣기
				list.add(vo);
				

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	public static List<LocalVo> search_kakao_local(String search_name, double latitude, double longitude, int radius, int page)
	{
		List<LocalVo> list = new ArrayList<LocalVo>();
		String rest_api_key = "KakaoAK ff458ea2054306f94bcf0e0aaca725c3";

		try {
			search_name = URLEncoder.encode(search_name, "utf-8");
			String urlStr = String.format("https://dapi.kakao.com/v2/local/search/keyword.xml?query=%s&y=%.8f&x=%.8f&radius=%d&page=%d&sort=distance",
					         search_name, latitude, longitude, radius, page
					);

			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			// Rest API Key 설정
			connection.setRequestProperty("Authorization", rest_api_key); 
			// 받을요청타입
			connection.setRequestProperty("Content-Type", "application/xml"); 
			connection.connect();

			SAXBuilder builder = new SAXBuilder();
			Document   doc = builder.build (connection.getInputStream());

			Element  root     = doc.getRootElement(); //<result>
			List<Element> element_list = root.getChildren("documents");

			for(Element documents : element_list){
				
				String place_name = documents.getChildText("place_name");
				String road_address_name = documents.getChildText("road_address_name");
				String place_url = documents.getChildText("place_url");
				String phone = documents.getChildText("phone");
				
				//String -> Integer로 변경하는 중에, 만약 입력값이 없다면 예외가 발생할 수 있다 (NumberFormatException)
				//따라서 Try-Catch 로 감싸 예외처리를 하는 것이 필요.
				int distance = 0;
				try {
					distance = Integer.parseInt(documents.getChildText("distance"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				 
				double x = 0;
				try {
					x = Double.parseDouble(documents.getChildText("x"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				double y = 0;
				try {
					y = Double.parseDouble(documents.getChildText("y"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				//로컬 정보를 포장
				LocalVo vo = new LocalVo(place_name, road_address_name, place_url, phone, distance,
						x, y);
								
				//ArrayList에 넣기
				list.add(vo);

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
}
