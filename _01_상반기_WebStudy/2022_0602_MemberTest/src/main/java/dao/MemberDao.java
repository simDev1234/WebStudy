package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import service.DBService;
import vo.MemberVo;

public class MemberDao {
	
	static MemberDao single = null;

	public static MemberDao getInstance() {
		if (single == null)
			single = new MemberDao();
		return single;
	}

	//외부에서 생성하지 말것
	private MemberDao() {

	}
	
	//전체조회
	public List<MemberVo> selectList() {

		List<MemberVo> list = new ArrayList<MemberVo>();

		Connection conn = null; //null을 일부로 초기값으로 설정
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member2 order by m_idx";

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
				MemberVo vo = new MemberVo();
				
				vo.setM_idx(rs.getInt("m_idx"));
				vo.setM_name(rs.getString("m_name"));
				vo.setM_id(rs.getString("m_id"));
				vo.setM_pwd(rs.getString("m_pwd"));
				vo.setM_zipcode(rs.getString("m_zipcode"));
				vo.setM_addr(rs.getString("m_addr"));
				vo.setM_grade(rs.getString("m_grade"));
				vo.setM_ip(rs.getString("m_ip"));
				vo.setM_regdate(rs.getString("m_regdate"));	

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
	
	//m_idx에 해당되는 객체 1건 구하기
	public MemberVo selectOne(int m_idx) {

		MemberVo vo = null;
		Connection conn = null; //null을 일부로 초기값으로 설정
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member2 where m_idx = ?";

		try {

			//1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2. PreparedStatment 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3. pstmt 세팅
			pstmt.setInt(1, m_idx);

			//4. ResultSet 얻어오기
			rs = pstmt.executeQuery();

			//5. 포장 (record -> Vo)
			if (rs.next()) {

				//Vo로 포장
				vo = new MemberVo();
				
				vo.setM_idx(rs.getInt("m_idx"));
				vo.setM_name(rs.getString("m_name"));
				vo.setM_id(rs.getString("m_id"));
				vo.setM_pwd(rs.getString("m_pwd"));
				vo.setM_zipcode(rs.getString("m_zipcode"));
				vo.setM_addr(rs.getString("m_addr"));
				vo.setM_grade(rs.getString("m_grade"));
				vo.setM_ip(rs.getString("m_ip"));
				vo.setM_regdate(rs.getString("m_regdate"));

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
	
	//m_id에 해당되는 객체 1건 구하기
	public MemberVo selectOne(String m_id) {

		MemberVo vo = null;
		Connection conn = null; //null을 일부로 초기값으로 설정
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member2 where m_id = ?";

		try {

			//1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2. PreparedStatment 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3. pstmt 세팅
			pstmt.setString(1, m_id);

			//4. ResultSet 얻어오기
			rs = pstmt.executeQuery();

			//5. 포장 (record -> Vo)
			if (rs.next()) {

				//Vo로 포장
				vo = new MemberVo();
				
				vo.setM_idx(rs.getInt("m_idx"));
				vo.setM_name(rs.getString("m_name"));
				vo.setM_id(rs.getString("m_id"));
				vo.setM_pwd(rs.getString("m_pwd"));
				vo.setM_zipcode(rs.getString("m_zipcode"));
				vo.setM_addr(rs.getString("m_addr"));
				vo.setM_grade(rs.getString("m_grade"));
				vo.setM_ip(rs.getString("m_ip"));
				vo.setM_regdate(rs.getString("m_regdate"));

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
	
	//insert
	public int insert(MemberVo vo) {
		
		int res = 0; 
		
		Connection        conn  = null;
		PreparedStatement pstmt = null;                                  
		                                                                             // 1 2 3 4 5 6 7 (parameter index)
		String            sql   = "insert into member2 values(seq_member2_m_idx.nextVal,?,?,?,?,?,?,?,sysdate)";
		
		try {
			//1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			
			//2. PreparedStatment 얻어오기
			pstmt = conn.prepareStatement(sql);
			
			//3. parameter 세팅 [[ 데이터 타입에 맞추어 세팅해야함 ]]
			pstmt.setString(1, vo.getM_name());
			pstmt.setString(2, vo.getM_id());
			pstmt.setString(3, vo.getM_pwd());
			pstmt.setString(4, vo.getM_zipcode());
			pstmt.setString(5, vo.getM_addr());
			pstmt.setString(6, vo.getM_grade());
			pstmt.setString(7, vo.getM_ip());
			
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

	public int delete(int m_idx) {
			int res = 0; 
			
			Connection        conn  = null;
			PreparedStatement pstmt = null;                                  
			String            sql   = "delete from member2 where m_idx = ?";
			
			try {
				//1. Connection 얻어오기
				conn = DBService.getInstance().getConnection();
				
				//2. PreparedStatment 얻어오기
				pstmt = conn.prepareStatement(sql);
				
				//3. parameter 세팅 [[ 데이터 타입에 맞추어 세팅해야함 ]]
				pstmt.setInt(1, m_idx);
				
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
	
	public int update(MemberVo vo) {
			int res = 0; 
			
			Connection        conn  = null;
			PreparedStatement pstmt = null;                                  
			String            sql   = "update member2 set m_name = ?, m_pwd = ?, m_zipcode = ?, m_addr = ?, m_grade = ?, m_ip = ?, m_regdate = sysdate where m_id = ?";
			
			try {
				//1. Connection 얻어오기
				conn = DBService.getInstance().getConnection();
				
				//2. PreparedStatment 얻어오기
				pstmt = conn.prepareStatement(sql);
				
				//3. parameter 세팅 [[ 데이터 타입에 맞추어 세팅해야함 ]]
				pstmt.setString(1, vo.getM_name());
				pstmt.setString(2, vo.getM_pwd());
				pstmt.setString(3, vo.getM_zipcode());
				pstmt.setString(4, vo.getM_addr());
				pstmt.setString(5, vo.getM_grade());
				pstmt.setString(6, vo.getM_ip());
				pstmt.setString(7, vo.getM_id());
				
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
