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

	//외부에서 생성하지 말것
	private SawonDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//사원목록 가져오기
	public List<SawonVo> selectList(){
		
		List<SawonVo> list = null;
		
		//1. SqlSession 생성 (일꾼 생성)
		SqlSession sqlSession = factory.openSession(); //Connection 얻어옴
		
		//2. 작업 수행                  namespace.mapper_id
		list = sqlSession.selectList("sawon.sawon_list");
		
		//3. sqlSession이 얻어온 Connection 닫는다. 
		sqlSession.close();
		
		return list;
	}

	//부서번호를 이용해서 사원목록 가져오기
	public List<SawonVo> selectListDeptno(int deptno) {
		
		List<SawonVo> list = null;
		
		//1. SqlSession 생성 (일꾼 생성)
		SqlSession sqlSession = factory.openSession(); //Connection 얻어옴
		
		//2. 작업 수행                    namespace.mapper_id    parameter
		list = sqlSession.selectList("sawon.sawon_list_deptno",deptno);
		
		/*
		   mapper에 있는 id = "sawon_list_deptno"에 있는 SQL문을 이용해서 VO포장 -> ArrayList 포장 
		*/
		
		//3. sqlSession이 얻어온 Connection 닫는다. 
		sqlSession.close();
		
		return list;
		
	}

	public List<SawonVo> selectListSahire(Map<String, Integer> map) {
		
		List<SawonVo> list = null;
		
		//1. SqlSession 생성 
		SqlSession sqlSession = factory.openSession();
		
		//2. 작업 수행
		list = sqlSession.selectList("sawon.sawon_list_sahire_year",map);
		
		//3. sqlSession이 얻어온 Connection 닫는다.
		sqlSession.close();
		
		return list;
		
	}
	
}
