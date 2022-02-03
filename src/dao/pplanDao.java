package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.JdbcUtil;
import dto.pplanDto;

public class pplanDao {
	private JdbcUtil ju;
	
	public pplanDao() {
		ju = JdbcUtil.getInstance();
		System.out.println(ju);
	}
	
	public int getCount_P(String oid) {
		
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select count(*) from W_PPLAN where B_OID = " + "'"+ oid + "'";
		System.out.println(sql);
		try {
			conn = ju.getConnection();
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch(Exception e) {
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();	
			}catch(Exception e2) {
				e2.getStackTrace();
				}	
			}
		
		return count;
	}
	
	

	public ArrayList<pplanDto> selectPPLAN(int page, String oid, int displayRow) {
		System.out.println("page : " + page);
		int startNum = (page-1)*displayRow + 1;
		int endNum = page*displayRow;

		ArrayList<pplanDto> SelectPPLANList = new ArrayList<pplanDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM ("
	            + "SELECT * FROM ("
	            + "SELECT ROWNUM row_num, w_pplan.* FROM w_pplan"
	            + ") WHERE row_num >= ?"
	            + ") WHERE row_num <= ?"
	            + " and b_oid like '" + oid + "'";
		System.out.println(sql);
		try {
			conn = ju.getConnection();
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setInt(1, startNum);
		    pstmt.setInt(2, endNum);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				pplanDto dto = new pplanDto();
				dto.setOid(rs.getString("OID"));
				dto.setB_oid(rs.getString("B_OID"));
				dto.setC_type(rs.getString("C_TYPE"));
				dto.setItem(rs.getString("ITEM"));
				dto.setP_no(rs.getString("P_NO"));
				dto.setY_pplan(rs.getString("Y_PPLAN"));
				dto.setM_pplan(rs.getString("M_PPLAN"));
				dto.setD_pplan(rs.getString("D_PPLAN"));
				dto.setP_rate(rs.getString("P_RATE"));
				dto.setO_rate(rs.getString("O_RATE"));
				dto.setBox(rs.getString("BOX"));
				dto.setH_stick(rs.getString("H_STICK"));
				dto.setN_car(rs.getString("N_CAR"));
				dto.setDescription(rs.getString("DESCRIPTION"));
				dto.setC_date(rs.getDate("C_DATE"));
				dto.setU_date(rs.getDate("U_DATE"));
				SelectPPLANList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();	
			}catch(Exception e2) {
				e2.getStackTrace();
				}	
			}
		return SelectPPLANList;
	}



}
