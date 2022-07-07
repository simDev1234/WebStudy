package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBService {

	
	DataSource ds;
	
	//single-ton : 객체 1개만 생성해서 사용하자
	static DBService single = null;

	public static DBService getInstance() {

		//객체가 없으면 생성해라
		if (single == null)
			single = new DBService();

		return single;
	}

	//외부에서 생성하지 말것
	private DBService() {
		// TODO Auto-generated constructor stub
		//JNDI(Java Naming Directory(검색) Interface)
		
		try {
			//1.InitialContext생성
			InitialContext ic = new InitialContext();
			
			//2.Resource의 저장소 Context정보 구하기
			//Context context = (Context) ic.lookup("java:comp/env");
			//3.Context내의 Resource정보를 획득
			//ds = (DataSource) context.lookup("jdbc/oracle_test");
			
			//2+3한번에 
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/oracle_test");
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//DBCP에 저장된 컨넥션 얻어오기
	public Connection getConnection() throws SQLException {
		
		return ds.getConnection();
		
	}
	
	
	
	
	
	
}
