package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import service.DBService;
import vo.VisitVo;

public class VisitDao {
	
	//singleton
	static VisitDao single = null;
	
	public static VisitDao getInstance() {
		if (single == null)
			single = new VisitDao();
		return single;
	}
	
	//�ܺο��� �������� ����
	private VisitDao() {
		
	}
	
	//���� ��ȸ(��ü��ȸ)
	public List<VisitVo> selectList() {

		List<VisitVo> list = new ArrayList<VisitVo>();

		Connection conn = null; //null�� �Ϻη� �ʱⰪ���� ����
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM visit ORDER BY idx DESC";

		try {

			//1. Connection ������
			conn = DBService.getInstance().getConnection();

			//2. PreparedStatment ������
			pstmt = conn.prepareStatement(sql);

			//3. ResultSet ������
			rs = pstmt.executeQuery();

			//4. ���� (record -> Vo -> list)
			while (rs.next()) {
				
				//Vo�� ����
				VisitVo vo = new VisitVo();

				//rs�� ����Ű�� ���ڵ�(��)�� ���� �о����
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));

				//list�� �߰�
				list.add(vo);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				//����(����)�Ǿ� ���� ��, close  --why? ���� ��� ���� ���� ����
				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return list;

	}

	public int insert(VisitVo vo) {
			int res = 0; 
			
			Connection        conn  = null;
			PreparedStatement pstmt = null;                                  
			String            sql   = "insert into visit values(seq_visit_idx.nextVal, ?, ?,?,?,sysdate)";
			
			try {
				//1. Connection ������
				conn = DBService.getInstance().getConnection();
				
				//2. PreparedStatment ������
				pstmt = conn.prepareStatement(sql);
				
				//3. parameter ���� [[ ������ Ÿ�Կ� ���߾� �����ؾ��� ]]
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getContent());
				pstmt.setString(3, vo.getPwd());
				pstmt.setString(4, vo.getIp());
				
				//3. DML(insert/update/delete) : res <- ó���� ����� ��ȯ
				res = pstmt.executeUpdate();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			} finally {
				
				//�ݱ� (���� ��������)
				try {
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
			}
			
			return res;
			
		}//end insert()

	public int delete(int idx) {
			int res = 0; 
			
			Connection        conn  = null;
			PreparedStatement pstmt = null;                                  
			String            sql   = "delete from visit where idx = ?";
			
			try {
				//1. Connection ������
				conn = DBService.getInstance().getConnection();
				
				//2. PreparedStatment ������
				pstmt = conn.prepareStatement(sql);
				
				//3. parameter ���� [[ ������ Ÿ�Կ� ���߾� �����ؾ��� ]]
				pstmt.setInt(1, idx);
				
				//3. DML(insert/update/delete) : res <- ó���� ����� ��ȯ
				res = pstmt.executeUpdate();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			} finally {
				
				//�ݱ� (���� ��������)
				try {
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
			}
			
			return res;
			
		}//end insert()

	//idx�� �ش�Ǵ� ��ü 1�� ���ϱ�
	public VisitVo selectOne(int idx) {

		VisitVo vo = null;
		Connection conn = null; //null�� �Ϻη� �ʱⰪ���� ����
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from visit where idx = ?";

		try {

			//1. Connection ������
			conn = DBService.getInstance().getConnection();

			//2. PreparedStatment ������
			pstmt = conn.prepareStatement(sql);

			//3. pstmt ����
			pstmt.setInt(1, idx);

			//4. ResultSet ������
			rs = pstmt.executeQuery();

			//5. ���� (record -> Vo)
			if (rs.next()) {

				//Vo�� ����
				vo = new VisitVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setIp(rs.getString("ip"));
				vo.setName(rs.getString("name"));
				vo.setPwd(rs.getString("pwd"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setContent(rs.getString("content"));

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				//����(����)�Ǿ� ���� ��, close  --why? ���� ��� ���� ���� ����
				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return vo;

	}
	
	public int update(VisitVo vo) {
			int res = 0; 
			
			Connection        conn  = null;
			PreparedStatement pstmt = null;                                  
			String            sql   = "update visit set name = ?, content = ? where idx = ?";
			
			try {
				//1. Connection ������
				conn = DBService.getInstance().getConnection();
				
				//2. PreparedStatment ������
				pstmt = conn.prepareStatement(sql);
				
				//3. parameter ���� [[ ������ Ÿ�Կ� ���߾� �����ؾ��� ]]
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getContent());
				pstmt.setInt(3, vo.getIdx());
				
				//3. DML(insert/update/delete) : res <- ó���� ����� ��ȯ
				res = pstmt.executeUpdate();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			} finally {
				
				//�ݱ� (���� ��������)
				try {
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
			}
			
			return res;
			
		}//end insert()
	
}
