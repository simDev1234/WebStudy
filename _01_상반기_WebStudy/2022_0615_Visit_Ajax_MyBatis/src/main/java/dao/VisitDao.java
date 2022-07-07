package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.VisitVo;

public class VisitDao {
	
	SqlSessionFactory factory;
	
	//singleton
	static VisitDao single = null;
	
	public static VisitDao getInstance() {
		if (single == null)
			single = new VisitDao();
		return single;
	}
	
	//외부에서 생성하지 말것
	private VisitDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//방명록 조회(전체조회)
	public List<VisitVo> selectList() {

		List<VisitVo> list = null;
		
		//1.SqlSession 생성
		SqlSession sqlSession = factory.openSession();

		//2.list가져오기
		list = sqlSession.selectList("visit.visit_list");
		
		//3.SqlSession 닫기
		sqlSession.close();

		return list;

	}//end selectList()
	
	//검색결과에 따라 selectList
	public List<VisitVo> selectList(Map<String,String> map) {

		List<VisitVo> list = null;
		
		//1.SqlSession 생성
		SqlSession sqlSession = factory.openSession();

		//2.list가져오기
		list = sqlSession.selectList("visit.visit_list_condition",map);
		
		//3.SqlSession 닫기
		sqlSession.close();

		return list;

	}//end selectList()

	public int insert(VisitVo vo) {
			
		int res = 0;
		
		//1. SqlSession 생성
		SqlSession sqlSession = factory.openSession();
		
		//2. insert
		res = sqlSession.insert("visit.visit_insert",vo);
		
		//Transaction 적용
		sqlSession.commit();
		
		//3. close
		sqlSession.close();
		
		return res;
			
	}//end insert()

	public int delete(int idx) {

		int res = 0;
		
	    //1. SqlSession 생성
		SqlSession sqlSession = factory.openSession();
		
		//2. delete
		res = sqlSession.delete("visit.visit_delete",idx);
		
		//Transaction 적용
		sqlSession.commit();
		
		//3. close
		sqlSession.close();
		
		return res;
			
	}//end delete()

	//idx에 해당되는 객체 1건 구하기
	public VisitVo selectOne(int idx) {
		
		VisitVo vo = null;
		
		//1. SqlSession 생성
		SqlSession sqlSession = factory.openSession();
		
		//2. vo 객체 가져오기
		vo = sqlSession.selectOne("visit.visit_list_idx",idx);
		
		//3. sqlSession 닫기
		sqlSession.close();

		return vo;

	}//end selectOne()
	
	public int update(VisitVo vo) {

		int res = 0;
		
		//1. SqlSession 생성
		SqlSession sqlSession = factory.openSession();
		
		//2. update 실행
		res = sqlSession.update("visit.visit_update",vo);
		
		//Transaction 적용
		sqlSession.commit();
		
		//3. close
		sqlSession.close();
		
		return res;
			
	}//end update()
	
	/*
	   insert/update/delete의 경우, 아래와 같이 Transaction(임시저장)을 거친다.
	   --------------------------------------------------------------
	   [ DAO ] -(임시저장)-> [ Transaction log ] -(commit)-> [ DB ]
	                     insert, update, delete  
	   ---------------------------------------------------------------
	   *commit을 하지 않고 끝내면 rollback(취소)이 된다.
	   
	   ===>> 
	   Transaction 
	   [1] 방법1 : insert/update/delete 후 commit을 한다.
	   sqlSession.commit();
	   
	   [2] 방법2 : 처음에 factory에서 openSession(boolean)할 때, true를 준다.
	   * 의미 ) true <-- Auto Commit  // Transaction(임시저장) 반영 안 하고, 바로 commit한다는 의미.
	   SqlSession sqlSession = factory.openSession(true); 
	*/
	
}
