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
			//1. InitialContext ����
			InitialContext ic = new InitialContext();
			
			//2. Resource�� ����� Context ���� ���ϱ�
			//Context context = (Context) ic.lookup("java:comp/env");
			
			//3. Context ���� Resource ������ ȹ��
			//ds = (DataSource) context.lookup("jdbc/oracle_test");
			
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/oracle_test");
			
		} catch (NamingException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	//DBCP�� ����� Ŀ�ؼ� ������
	public Connection getConnection() throws SQLException{
		
		return ds.getConnection();
		
	}
	
}
