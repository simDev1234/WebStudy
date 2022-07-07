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
	
	//�ܺο��� �������� ����
	private VisitDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//���� ��ȸ(��ü��ȸ)
	public List<VisitVo> selectList() {

		List<VisitVo> list = null;
		
		//1.SqlSession ����
		SqlSession sqlSession = factory.openSession();

		//2.list��������
		list = sqlSession.selectList("visit.visit_list");
		
		//3.SqlSession �ݱ�
		sqlSession.close();

		return list;

	}//end selectList()
	
	//�˻������ ���� selectList
	public List<VisitVo> selectList(Map<String,String> map) {

		List<VisitVo> list = null;
		
		//1.SqlSession ����
		SqlSession sqlSession = factory.openSession();

		//2.list��������
		list = sqlSession.selectList("visit.visit_list_condition",map);
		
		//3.SqlSession �ݱ�
		sqlSession.close();

		return list;

	}//end selectList()

	public int insert(VisitVo vo) {
			
		int res = 0;
		
		//1. SqlSession ����
		SqlSession sqlSession = factory.openSession();
		
		//2. insert
		res = sqlSession.insert("visit.visit_insert",vo);
		
		//Transaction ����
		sqlSession.commit();
		
		//3. close
		sqlSession.close();
		
		return res;
			
	}//end insert()

	public int delete(int idx) {

		int res = 0;
		
	    //1. SqlSession ����
		SqlSession sqlSession = factory.openSession();
		
		//2. delete
		res = sqlSession.delete("visit.visit_delete",idx);
		
		//Transaction ����
		sqlSession.commit();
		
		//3. close
		sqlSession.close();
		
		return res;
			
	}//end delete()

	//idx�� �ش�Ǵ� ��ü 1�� ���ϱ�
	public VisitVo selectOne(int idx) {
		
		VisitVo vo = null;
		
		//1. SqlSession ����
		SqlSession sqlSession = factory.openSession();
		
		//2. vo ��ü ��������
		vo = sqlSession.selectOne("visit.visit_list_idx",idx);
		
		//3. sqlSession �ݱ�
		sqlSession.close();

		return vo;

	}//end selectOne()
	
	public int update(VisitVo vo) {

		int res = 0;
		
		//1. SqlSession ����
		SqlSession sqlSession = factory.openSession();
		
		//2. update ����
		res = sqlSession.update("visit.visit_update",vo);
		
		//Transaction ����
		sqlSession.commit();
		
		//3. close
		sqlSession.close();
		
		return res;
			
	}//end update()
	
	/*
	   insert/update/delete�� ���, �Ʒ��� ���� Transaction(�ӽ�����)�� ��ģ��.
	   --------------------------------------------------------------
	   [ DAO ] -(�ӽ�����)-> [ Transaction log ] -(commit)-> [ DB ]
	                     insert, update, delete  
	   ---------------------------------------------------------------
	   *commit�� ���� �ʰ� ������ rollback(���)�� �ȴ�.
	   
	   ===>> 
	   Transaction 
	   [1] ���1 : insert/update/delete �� commit�� �Ѵ�.
	   sqlSession.commit();
	   
	   [2] ���2 : ó���� factory���� openSession(boolean)�� ��, true�� �ش�.
	   * �ǹ� ) true <-- Auto Commit  // Transaction(�ӽ�����) �ݿ� �� �ϰ�, �ٷ� commit�Ѵٴ� �ǹ�.
	   SqlSession sqlSession = factory.openSession(true); 
	*/
	
}
