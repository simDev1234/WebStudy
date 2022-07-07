package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.GogekVo;

public class GogekDao {
	
	SqlSessionFactory factory;
	
	static GogekDao single = null;

	public static GogekDao getInstance() {
		if (single == null)
			single = new GogekDao();
		return single;
	}

	//�ܺο��� �������� ����
	private GogekDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//������ ��������
	public List<GogekVo> selectList(){
		
		List<GogekVo> list = null;
		
		//1. SqlSession ���� (�ϲ� ����)
		SqlSession sqlSession = factory.openSession(); //Connection ����
		
		//2. �۾� ����                  namespace.mapper_id
		list = sqlSession.selectList("gogek.gogek_list");
		
		//3. sqlSession�� ���� Connection �ݴ´�. 
		sqlSession.close();
		
		return list;
	}
	
}
