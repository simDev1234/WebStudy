package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.SungVo;

public class SungDao {

	static SungDao single = null;
	
	public static SungDao getInstance() {
		
		if (single == null) {
			
			single = new SungDao();
			
		}

		return single;
		
	}
	
	//��ü��ȸ
	public List<SungVo> selectList() {

		List<SungVo> list = new ArrayList<SungVo>();

		Connection conn = null; //null�� �Ϻη� �ʱⰪ���� ����
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM sungtb_view";

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
				SungVo vo = new SungVo();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				
				//DB �÷�Ÿ�԰� �����ϰ� String������ �о�� �� �ִ�.
				vo.setTot(rs.getString("tot"));
				vo.setAvg(rs.getString("avg"));
				vo.setRank(rs.getString("rank"));

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

	public int insert(SungVo vo) {
		int res = 0; 
		
		Connection        conn  = null;
		PreparedStatement pstmt = null;                                   //         1  2  3  4  -- parameter index
		String            sql   = "INSERT INTO sungtb VALUES(seq_sungtb_idx.nextVal, ?, ?, ?, ?)";
		
		try {
			//1. Connection ������
			conn = DBService.getInstance().getConnection();
			
			//2. PreparedStatment ������
			pstmt = conn.prepareStatement(sql);
			
			//3. parameter ���� [[ ������ Ÿ�Կ� ���߾� �����ؾ��� ]]
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			
			//3. insert : res <- ó���� ����� ��ȯ
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
		String            sql   = "DELETE FROM sungtb WHERE idx = ?";
		
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
		
	}//end delete()
	
	public int update(SungVo vo) {
		int res = 0; 
		
		Connection        conn  = null;
		PreparedStatement pstmt = null;                                  
		String            sql   = "UPDATE sungtb SET name = ?, kor = ?, eng = ?, mat = ? WHERE idx = ?";
		
		try {
			//1. Connection ������
			conn = DBService.getInstance().getConnection();
			
			//2. PreparedStatment ������
			pstmt = conn.prepareStatement(sql);
			
			//3. parameter ���� [[ ������ Ÿ�Կ� ���߾� �����ؾ��� ]]
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			pstmt.setInt(5, vo.getIdx());
			
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
	public SungVo selectOne(int idx) {

		SungVo vo = null;
		Connection conn = null; //null�� �Ϻη� �ʱⰪ���� ����
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//                                                  1 <= parameter(��������) index
		String sql = "SELECT * FROM sungtb_view WHERE idx = ?";

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
				vo = new SungVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				
				//DB �÷�Ÿ�԰� �����ϰ� String������ �о�� �� �ִ�.
				vo.setTot(rs.getString("tot"));
				vo.setAvg(rs.getString("avg"));
				vo.setRank(rs.getString("rank"));

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
	
}
