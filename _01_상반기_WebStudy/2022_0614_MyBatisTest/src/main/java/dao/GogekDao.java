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

	//외부에서 생성하지 말것
	private GogekDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//사원목록 가져오기
	public List<GogekVo> selectList(){
		
		List<GogekVo> list = null;
		
		//1. SqlSession 생성 (일꾼 생성)
		SqlSession sqlSession = factory.openSession(); //Connection 얻어옴
		
		//2. 작업 수행                  namespace.mapper_id
		list = sqlSession.selectList("gogek.gogek_list");
		
		//3. sqlSession이 얻어온 Connection 닫는다. 
		sqlSession.close();
		
		return list;
	}
	
}
