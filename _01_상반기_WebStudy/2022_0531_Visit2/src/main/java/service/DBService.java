package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBService {
	
	DataSource ds;
	
	static DBService single = null;
	
	public static DBService getInstance() {
		if (single == null)
			single = new DBService();
		return single;
	}
	
	private DBService() {
		
		//JNDI (Java Naming Directory Interface)
		
		try {
			//1. InitialContext 생성
			InitialContext ic = new InitialContext();
			
			//2. Resource의 저장소 Context 정보 구하기
			//Context context = (Context) ic.lookup("java:comp/env");
			
			//3. Context 내의 Resource 정보를 획득
			//ds = (DataSource) context.lookup("jdbc/oracle_test");
			
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/oracle_test");
			
		} catch (NamingException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	//DBCP에 저장된 커넥션 얻어오기
	public Connection getConnection() throws SQLException{
		
		return ds.getConnection();
		
	}
	
}
