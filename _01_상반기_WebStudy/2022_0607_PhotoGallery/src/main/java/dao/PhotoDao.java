package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import service.DBService;
import vo.PhotoVo;

public class PhotoDao {
	
	static PhotoDao single = null;

	public static PhotoDao getInstance() {
		if (single == null)
			single = new PhotoDao();
		return single;
	}

	//외부에서 생성하지 말것
	private PhotoDao() {

	}
	
	//전체조회
	public List<PhotoVo> selectList() {

		List<PhotoVo> list = new ArrayList<PhotoVo>();

		Connection conn = null; //null을 일부로 초기값으로 설정
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM photo ORDER BY p_idx DESC";

		try {

			//1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2. PreparedStatment 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3. ResultSet 얻어오기
			rs = pstmt.executeQuery();

			//4. 포장 (record -> Vo -> list)
			while (rs.next()) {

				//rs가 가리키는 레코드(행)의 값을 읽어오기

				//Vo로 포장
				PhotoVo vo = new PhotoVo();
				
				vo.setP_idx(rs.getInt("p_idx"));
				vo.setP_subject(rs.getString("p_subject"));
				vo.setP_content(rs.getString("p_content"));
				vo.setP_filename(rs.getString("p_filename"));
				vo.setP_ip(rs.getString("p_ip"));
				vo.setP_regdate(rs.getString("p_regdate"));
				vo.setM_idx(rs.getInt("m_idx"));

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

	}//end select
	
	//idx에 해당되는 객체 1건 구하기
	public PhotoVo selectOne(int p_idx) {

		PhotoVo vo = null;
		Connection conn = null; //null을 일부로 초기값으로 설정
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM photo WHERE p_idx = ?";

		try {

			//1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2. PreparedStatment 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3. pstmt 세팅
			pstmt.setInt(1, p_idx);

			//4. ResultSet 얻어오기
			rs = pstmt.executeQuery();

			//5. 포장 (record -> Vo)
			if (rs.next()) {

				//Vo로 포장
				vo = new PhotoVo();
				
				vo.setP_idx(rs.getInt("p_idx"));
				vo.setP_subject(rs.getString("p_subject"));
				vo.setP_content(rs.getString("p_content"));
				vo.setP_filename(rs.getString("p_filename"));
				vo.setP_ip(rs.getString("p_ip"));
				vo.setP_regdate(rs.getString("p_regdate"));
				vo.setM_idx(rs.getInt("m_idx"));

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

	}//end selectOne
	
	public int insert(PhotoVo vo) {
			int res = 0; 
			
			Connection        conn  = null;
			PreparedStatement pstmt = null;                                  
			String            sql   = "INSERT INTO photo VALUES(seq_photo_p_idx.nextVal, ?, ?, ?, ?, sysdate, ?)";
			
			try {
				//1. Connection 얻어오기
				conn = DBService.getInstance().getConnection();
				
				//2. PreparedStatment 얻어오기
				pstmt = conn.prepareStatement(sql);
				
				//3. parameter 세팅 [[ 데이터 타입에 맞추어 세팅해야함 ]]
				pstmt.setString(1, vo.getP_subject());
				pstmt.setString(2, vo.getP_content());
				pstmt.setString(3, vo.getP_filename());
				pstmt.setString(4, vo.getP_ip());
				pstmt.setInt(5, vo.getM_idx());
				
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
	
	public int delete(int p_idx) {
			int res = 0; 
			
			Connection        conn  = null;
			PreparedStatement pstmt = null;                                  
			String            sql   = "DELETE FROM photo WHERE p_idx = ?";
			
			try {
				//1. Connection 얻어오기
				conn = DBService.getInstance().getConnection();
				
				//2. PreparedStatment 얻어오기
				pstmt = conn.prepareStatement(sql);
				
				//3. parameter 세팅 [[ 데이터 타입에 맞추어 세팅해야함 ]]
				pstmt.setInt(1, p_idx);
				
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
			
		}//end delete()
	
	public int update(PhotoVo vo) {
			int res = 0; 
			
			Connection        conn  = null;
			PreparedStatement pstmt = null;                                  
			String            sql   = "update photo set p_subject = ?, p_content = ?, p_ip = ?, p_regdate = sysdate where p_idx = ?";
			
			try {
				//1. Connection 얻어오기
				conn = DBService.getInstance().getConnection();
				
				//2. PreparedStatment 얻어오기
				pstmt = conn.prepareStatement(sql);
				
				//3. parameter 세팅 [[ 데이터 타입에 맞추어 세팅해야함 ]]
				pstmt.setString(1, vo.getP_subject());
				pstmt.setString(2, vo.getP_content());
				pstmt.setString(3, vo.getP_ip());
				pstmt.setInt(4, vo.getP_idx());
				
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
			
		}//end update()
	
	public int update_filename(PhotoVo vo) {
		int res = 0; 
		
		Connection        conn  = null;
		PreparedStatement pstmt = null;                                  
		String            sql   = "update photo set p_filename = ? where p_idx = ?";
		
		try {
			//1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			
			//2. PreparedStatment 얻어오기
			pstmt = conn.prepareStatement(sql);
			
			//3. parameter 세팅 [[ 데이터 타입에 맞추어 세팅해야함 ]]
			pstmt.setString(1, vo.getP_filename());
			pstmt.setInt(2, vo.getP_idx());
			
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
		
	}//end update()
	
}
