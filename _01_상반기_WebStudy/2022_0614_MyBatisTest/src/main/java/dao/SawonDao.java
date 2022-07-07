package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import service.MyBatisConnector;
import vo.SawonVo;

public class SawonDao {
	
	SqlSessionFactory factory;
	
	static SawonDao single = null;

	public static SawonDao getInstance() {
		if (single == null)
			single = new SawonDao();
		return single;
	}

	//�ܺο��� �������� ����
	private SawonDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//������ ��������
	public List<SawonVo> selectList(){
		
		List<SawonVo> list = null;
		
		//1. SqlSession ���� (�ϲ� ����)
		SqlSession sqlSession = factory.openSession(); //Connection ����
		
		//2. �۾� ����                  namespace.mapper_id
		list = sqlSession.selectList("sawon.sawon_list");
		
		//3. sqlSession�� ���� Connection �ݴ´�. 
		sqlSession.close();
		
		return list;
	}

	//�μ���ȣ�� �̿��ؼ� ������ ��������
	public List<SawonVo> selectListDeptno(int deptno) {
		
		List<SawonVo> list = null;
		
		//1. SqlSession ���� (�ϲ� ����)
		SqlSession sqlSession = factory.openSession(); //Connection ����
		
		//2. �۾� ����                    namespace.mapper_id    parameter
		list = sqlSession.selectList("sawon.sawon_list_deptno",deptno);
		
		/*
		   mapper�� �ִ� id = "sawon_list_deptno"�� �ִ� SQL���� �̿��ؼ� VO���� -> ArrayList ���� 
		*/
		
		//3. sqlSession�� ���� Connection �ݴ´�. 
		sqlSession.close();
		
		return list;
		
	}

	public List<SawonVo> selectListSahire(Map<String, Integer> map) {
		
		List<SawonVo> list = null;
		
		//1. SqlSession ���� 
		SqlSession sqlSession = factory.openSession();
		
		//2. �۾� ����
		list = sqlSession.selectList("sawon.sawon_list_sahire_year",map);
		
		//3. sqlSession�� ���� Connection �ݴ´�.
		sqlSession.close();
		
		return list;
		
	}
	
}
