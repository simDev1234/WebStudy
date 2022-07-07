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
	
	//외부에서 생성하지 말것
	private VisitDao() {
		
	}
	
	//방명록 조회(전체조회)
	public List<VisitVo> selectList() {

		List<VisitVo> list = new ArrayList<VisitVo>();

		Connection conn = null; //null을 일부로 초기값으로 설정
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM visit ORDER BY idx DESC";

		try {

			//1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2. PreparedStatment 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3. ResultSet 얻어오기
			rs = pstmt.executeQuery();

			//4. 포장 (record -> Vo -> list)
			while (rs.next()) {
				
				//Vo로 포장
				VisitVo vo = new VisitVo();

				//rs가 가리키는 레코드(행)의 값을 읽어오기
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));

				//list에 추가
				list.add(vo);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				//연결(생성)되어 있을 시, close  --why? 다음 명령 위해 연결 해제
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
				//1. Connection 얻어오기
				conn = DBService.getInstance().getConnection();
				
				//2. PreparedStatment 얻어오기
				pstmt = conn.prepareStatement(sql);
				
				//3. parameter 세팅 [[ 데이터 타입에 맞추어 세팅해야함 ]]
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getContent());
				pstmt.setString(3, vo.getPwd());
				pstmt.setString(4, vo.getIp());
				
				//3. DML(insert/update/delete) : res <- 처리된 행수를 반환
				res = pstmt.executeUpdate();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			} finally {
				
				//닫기 (열린 역순으로)
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
				//1. Connection 얻어오기
				conn = DBService.getInstance().getConnection();
				
				//2. PreparedStatment 얻어오기
				pstmt = conn.prepareStatement(sql);
				
				//3. parameter 세팅 [[ 데이터 타입에 맞추어 세팅해야함 ]]
				pstmt.setInt(1, idx);
				
				//3. DML(insert/update/delete) : res <- 처리된 행수를 반환
				res = pstmt.executeUpdate();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			} finally {
				
				//닫기 (열린 역순으로)
				try {
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
			}
			
			return res;
			
		}//end insert()

	//idx에 해당되는 객체 1건 구하기
	public VisitVo selectOne(int idx) {

		VisitVo vo = null;
		Connection conn = null; //null을 일부로 초기값으로 설정
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from visit where idx = ?";

		try {

			//1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2. PreparedStatment 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3. pstmt 세팅
			pstmt.setInt(1, idx);

			//4. ResultSet 얻어오기
			rs = pstmt.executeQuery();

			//5. 포장 (record -> Vo)
			if (rs.next()) {

				//Vo로 포장
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
				//연결(생성)되어 있을 시, close  --why? 다음 명령 위해 연결 해제
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
				//1. Connection 얻어오기
				conn = DBService.getInstance().getConnection();
				
				//2. PreparedStatment 얻어오기
				pstmt = conn.prepareStatement(sql);
				
				//3. parameter 세팅 [[ 데이터 타입에 맞추어 세팅해야함 ]]
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getContent());
				pstmt.setInt(3, vo.getIdx());
				
				//3. DML(insert/update/delete) : res <- 처리된 행수를 반환
				res = pstmt.executeUpdate();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			} finally {
				
				//닫기 (열린 역순으로)
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
