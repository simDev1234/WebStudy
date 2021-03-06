package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.DeptVo;

public class DeptDao {
	
	//싱글톤
	public static DeptDao single = null;
	
	public static DeptDao getInstance() {
		if (single == null) 
			single = new DeptDao();
		
		return single;
	}
	
	//-생성자
	private DeptDao() {
		
	}
	
    //전체조회
	public List<DeptVo> selectList() {

		List<DeptVo> list = new ArrayList<DeptVo>();

		Connection conn = null; //null을 일부로 초기값으로 설정
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from dept";

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
				DeptVo vo = new DeptVo();
				
				vo.setDeptno(rs.getInt("deptno"));
				vo.setDname(rs.getString("dname"));
				vo.setLoc(rs.getString("loc"));

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
	
}
