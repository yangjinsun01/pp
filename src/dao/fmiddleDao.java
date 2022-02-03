package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import common.JdbcUtil;
import dto.fmiddleDto;

public class fmiddleDao {
	 private JdbcUtil ju;
	 	// DB 연동
	   public fmiddleDao() {
	      ju = JdbcUtil.getInstance();
		   System.out.println(ju);
	   }
	   
	   // 전체 row값을 불러오는 코드
	   public int getCount_F(String search) {
			
			int count = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "select count(*) from w_fmiddle where oid like '%" + search +"%'";
			System.out.println("getCount_F sql : "+sql);
			try {
				conn = ju.getConnection();
				pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt(1);
					System.out.println("getCount_F count : "+count);
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
	   
	   	// All select
		public ArrayList<fmiddleDto> selectFmiddle(int page, String search) {
			int startNum = (page-1)*20 + 1;
			int endNum = page*20;
			
			ArrayList<fmiddleDto> dtoList = new ArrayList<fmiddleDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql =  "SELECT * FROM ("
		            + "SELECT * FROM ("
		            + "SELECT ROWNUM row_num, w_fmiddle.* FROM w_fmiddle where oid like '%" + search 
		            + "%' ) WHERE row_num >= ?"
		            + ") WHERE row_num <= ? order by oid ";
			try {
				conn = ju.getConnection();
			    pstmt = conn.prepareStatement(sql);
			    pstmt.setInt(1, startNum);
			    pstmt.setInt(2, endNum);
				ResultSet rs = pstmt.executeQuery();
				System.out.println("selectWfmiddle : "+sql);
				
				while(rs.next()) {
					fmiddleDto dto = new fmiddleDto();
					dto.setOid(rs.getString("OID"));
					dto.setB_oid(rs.getString("B_OID"));
					dto.setC_type(rs.getString("C_TYPE"));
					dto.setP_name(rs.getString("P_NAME"));
					dto.setP_no(rs.getString("P_NO"));
					dto.setGubun(rs.getString("GUBUN"));
					dto.setC_date(rs.getDate("C_DATE"));
					dto.setU_date(rs.getDate("U_DATE"));
					dto.setDescription(rs.getString("DESCRIPTION"));
					dtoList.add(dto);
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
			return dtoList;
		}
		
		// Detail select
		public ArrayList<fmiddleDto> detailFmiddle(String page) {

			ArrayList<fmiddleDto> dtoList = new ArrayList<fmiddleDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql =  "SELECT * FROM w_fmiddle where OID = ?";
			try {
				conn = ju.getConnection();
			    pstmt = conn.prepareStatement(sql);
			    pstmt.setString(1, page);
				ResultSet rs = pstmt.executeQuery();
			    System.out.println("selectdetail : "+sql);
				
				while(rs.next()) {
					fmiddleDto dto = new fmiddleDto();
					dto.setOid(rs.getString("OID"));
					dto.setB_oid(rs.getString("B_OID"));
					dto.setC_type(rs.getString("C_TYPE"));
					dto.setP_name(rs.getString("P_NAME"));
					dto.setP_no(rs.getString("P_NO"));
					dto.setGubun(rs.getString("GUBUN"));
					dto.setC_date(rs.getDate("C_DATE"));
					dto.setU_date(rs.getDate("U_DATE"));
					dto.setDescription(rs.getString("DESCRIPTION"));
					dtoList.add(dto);
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
			return dtoList;
		}
		
		// Update
		public void updateFmiddle(fmiddleDto data) {
			SimpleDateFormat ymd = new SimpleDateFormat("yy/MM/dd");
			Calendar calendar = Calendar.getInstance();
			Date nd = calendar.getTime();
			String nowd = ymd.format(nd);
			System.out.println("업데이트 날짜 가져옴");
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql =  "UPDATE w_fmiddle SET b_oid=?, c_type=?, p_name=?, p_no=?, gubun=?, u_date=?, description=? WHERE oid=? ";
			try {
				conn = ju.getConnection();
			    pstmt = conn.prepareStatement(sql);
			    pstmt.setString(1, data.getB_oid());
			    pstmt.setString(2, data.getC_type());
			    pstmt.setString(3, data.getP_name());
			    pstmt.setString(4, data.getP_no());
			    pstmt.setString(5, data.getGubun());
			    pstmt.setString(6, nowd);
			    pstmt.setString(7, data.getDescription());
			    pstmt.setString(8, data.getOid());
				pstmt.executeUpdate();
				System.out.println("update : "+sql);
				
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
		}
		
		// Insert
		public void insertFmiddle(fmiddleDto data) {
			SimpleDateFormat ymd = new SimpleDateFormat("yy/MM/dd");
			Calendar calendar = Calendar.getInstance();
			Date nd = calendar.getTime();
			String nowd = ymd.format(nd);
			System.out.println("날짜 가져옴");
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql =  "INSERT INTO w_fmiddle(oid, b_oid, c_type, p_name, p_no, gubun, c_date, u_date, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				conn = ju.getConnection();
			    pstmt = conn.prepareStatement(sql);
			    pstmt.setString(1, data.getOid());
			    pstmt.setString(2, data.getB_oid());
			    pstmt.setString(3, data.getC_type());
			    pstmt.setString(4, data.getP_name());
			    pstmt.setString(5, data.getP_no());
			    pstmt.setString(6, data.getGubun());
			    pstmt.setString(7, nowd);
			    pstmt.setString(8, nowd);
			    pstmt.setString(9, data.getDescription());
				pstmt.executeUpdate();
				System.out.println("insert : "+sql);
				
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
		}
}

