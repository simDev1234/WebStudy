package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import service.DBService;
import vo.SawonVo;

public class SawonDao {
	
	//ΩÃ±€≈Ê
	public static SawonDao single = null;
	
	public static SawonDao getInstance() {
		
		if (single == null)
			single = new SawonDao();
		
		return single;
		
	}
	
	private SawonDao() {}
	
	//¿¸√º¡∂»∏ List
	public List<SawonVo> selectList(){
		
		List<SawonVo> list = new ArrayList<SawonVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon";
		
		try {
			conn = DBService.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				SawonVo sv = new SawonVo();
				
				sv.setSabun(rs.getInt("sabun"));
				sv.setSaname(rs.getString("saname"));
				sv.setSasex(rs.getString("sasex"));
				sv.setDeptno(rs.getInt("deptno"));
				sv.setSajob(rs.getString("sajob"));
				sv.setSahire(rs.getString("sahire"));
				sv.setSamgr(rs.getInt("samgr"));
				sv.setSapay(rs.getInt("sapay"));
				
				list.add(sv);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
				
			} catch (Exception e2) {
				
				e2.printStackTrace();
				
			}
			
		}
		
		return list;
		
	}//end selectList();
	
}
