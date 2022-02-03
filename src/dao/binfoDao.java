package dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import common.JdbcUtil;
import dto.binfoDto;

public class binfoDao {
	 private JdbcUtil ju;

	   public binfoDao() {
	      ju = JdbcUtil.getInstance();
		   System.out.println(ju);
	   }

	   public int getCount_B() {

			int count = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "select count(*) from W_BINFO";
			System.out.println(sql);
			try {
				conn = ju.getConnection();
				pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();

				if(rs.next()) {
					count = rs.getInt(1);
					System.out.println(count);
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




		public ArrayList<binfoDto> selectWbinfo(int page) {
			int startNum = (page-1)*10 + 1;
			int endNum = page*10;

			ArrayList<binfoDto> dtoList = new ArrayList<binfoDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql =  "SELECT * FROM ("
		            + "SELECT * FROM ("
		            + "SELECT ROWNUM row_num, w_binfo.* FROM w_binfo"
		            + ") WHERE row_num >= ?"
		            + ") WHERE row_num <= ? ORDER BY OID";
			try {
				conn = ju.getConnection();
			    pstmt = conn.prepareStatement(sql);
			    pstmt.setInt(1, startNum);
			    pstmt.setInt(2, endNum);
			    System.out.println(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					binfoDto dto = new binfoDto();
					dto.setOid(rs.getString("OID"));
					dto.setBcode(rs.getString("BCODE"));
					dto.setBname(rs.getString("BNAME"));
					dto.setW_day(rs.getString("W_DAY"));
					dto.setW_time(rs.getString("W_TIME"));
					dto.setT_cnt(rs.getString("T_CNT"));
					dto.setL_stand(rs.getString("L_STAND"));
					dto.setS_day(rs.getString("S_DAY"));
					dto.setRfq(rs.getString("RFQ"));
					dto.setN_factory(rs.getString("N_FACTORY"));
					dto.setC_date(rs.getDate("C_DATE"));
					dto.setU_date(rs.getDate("U_DATE"));
					dto.setDescription(rs.getString("DESCRIPTION"));
					dto.setFile1(rs.getString("FILE1"));
					dto.setO_file1(rs.getString("O_FILE2"));
					dto.setFile2(rs.getString("FILE2"));
					dto.setO_file2(rs.getString("O_FILE2"));
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


				public ArrayList<binfoDto> searchWbinfo(String oidValue) {

					ArrayList<binfoDto> searchList = new ArrayList<binfoDto>();
					Connection conn = null;
					PreparedStatement pstmt = null;
					String sql =  "select * from w_binfo where oid = '" + oidValue + "'";
					System.out.println(sql);
					try {
						conn = ju.getConnection();
					    pstmt = conn.prepareStatement(sql);
					    System.out.println(sql);
						ResultSet rs = pstmt.executeQuery();
						while(rs.next()) {
							binfoDto dto = new binfoDto();
							dto.setOid(rs.getString("OID"));
							dto.setBcode(rs.getString("BCODE"));
							dto.setBname(rs.getString("BNAME"));
							dto.setW_day(rs.getString("W_DAY"));
							dto.setW_time(rs.getString("W_TIME"));
							dto.setT_cnt(rs.getString("T_CNT"));
							dto.setL_stand(rs.getString("L_STAND"));
							dto.setS_day(rs.getString("S_DAY"));
							dto.setRfq(rs.getString("RFQ"));
							dto.setN_factory(rs.getString("N_FACTORY"));
							dto.setC_date(rs.getDate("C_DATE"));
							dto.setU_date(rs.getDate("U_DATE"));
							dto.setDescription(rs.getString("DESCRIPTION"));
							dto.setFile1(rs.getString("FILE1"));
							dto.setO_file1(rs.getString("O_FILE2"));
							dto.setFile2(rs.getString("FILE2"));
							dto.setO_file2(rs.getString("O_FILE2"));
							searchList.add(dto);
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
					return searchList;
				}

				public ArrayList<binfoDto> binfoLastList() {

					ArrayList<binfoDto> lastList = new ArrayList<binfoDto>();
					Connection conn = null;
					PreparedStatement pstmt = null;
					String sql =  "select max(CAST(substr(oid,8) AS DECIMAL)) as maxcol from w_binfo";
					System.out.println(sql);
					try {
						conn = ju.getConnection();
					    pstmt = conn.prepareStatement(sql);
					    System.out.println(sql);
						ResultSet rs = pstmt.executeQuery();
						int max = 0;
						LocalDate now = LocalDate.now();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
						DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yy/MM/dd");
						String nowDate = now.format(formatter);
						String nowToday = now.format(formatter2);
						System.out.println(nowDate);
						String resultCode = "";
						if(rs.next()) {
							max = rs.getInt(1); // max = rs.getInt("maxcol");
												// 만약. 결과값이 있다면 첫번째 자리 숫자를 max변수에 담습니다. (최대수)
							System.out.println(max + "+ 1");
							max = max + 1;
							System.out.println(max);
							//
							resultCode = nowDate +"-"+ max;
							System.out.println(resultCode);
							//변수 oidCode에 담긴 값 "211230-"과 변수 max에 담긴 값(최대값+1)을 조합하여 변수 resultCode에 담습니다.
						}
							binfoDto dto = new binfoDto();
							dto.setResultCode(resultCode);
							dto.setToday(nowToday);
							lastList.add(dto);
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
					return lastList;
				}


				public void insertWbinfo(binfoDto Idto) {
					SimpleDateFormat ymd = new SimpleDateFormat("yy/MM/dd");
					Calendar calendar = Calendar.getInstance();
					Date nd = calendar.getTime();
					String nowd = ymd.format(nd);
					System.out.println("업데이트 날짜 가져옴");


					Connection conn = null;
					PreparedStatement pstmt = null;
					String sql = "INSERT INTO w_binfo(oid, bcode, bname, w_day, w_time, t_cnt, l_stand, s_day, description,c_date,u_date) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
					try {
						conn = ju.getConnection();
					    pstmt = conn.prepareStatement(sql);
					    System.out.println(sql);
							pstmt.setString(1, Idto.getOid());
							pstmt.setString(2, Idto.getBcode());
							pstmt.setString(3, Idto.getBname());
							pstmt.setString(4, Idto.getW_day());
							pstmt.setString(5, Idto.getW_time());
							pstmt.setString(6, Idto.getT_cnt());
							pstmt.setString(7, Idto.getL_stand());
							pstmt.setString(8, Idto.getS_day());
							pstmt.setString(9, Idto.getDescription());
							pstmt.setString(10, nowd);
							pstmt.setString(11, nowd);
							pstmt.executeUpdate();
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

				public ArrayList<binfoDto> detailWbinfo(String oidValue) {

					ArrayList<binfoDto> detailList = new ArrayList<binfoDto>();
					Connection conn = null;
					PreparedStatement pstmt = null;
					String sql =  "select * from w_binfo where oid = '" + oidValue + "'";
					System.out.println(sql);
					try {
						conn = ju.getConnection();
					    pstmt = conn.prepareStatement(sql);
					    System.out.println(sql);
						ResultSet rs = pstmt.executeQuery();
						while(rs.next()) {
							binfoDto dto = new binfoDto();
							dto.setOid(rs.getString("OID"));
							dto.setBcode(rs.getString("BCODE"));
							dto.setBname(rs.getString("BNAME"));
							dto.setW_day(rs.getString("W_DAY"));
							dto.setW_time(rs.getString("W_TIME"));
							dto.setT_cnt(rs.getString("T_CNT"));
							dto.setL_stand(rs.getString("L_STAND"));
							dto.setS_day(rs.getString("S_DAY"));
							dto.setRfq(rs.getString("RFQ"));
							dto.setN_factory(rs.getString("N_FACTORY"));
							dto.setC_date(rs.getDate("C_DATE"));
							dto.setU_date(rs.getDate("U_DATE"));
							dto.setDescription(rs.getString("DESCRIPTION"));
							dto.setFile1(rs.getString("FILE1"));
							dto.setO_file1(rs.getString("O_FILE2"));
							dto.setFile2(rs.getString("FILE2"));
							dto.setO_file2(rs.getString("O_FILE2"));
							detailList.add(dto);
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
					return detailList;
				}


				public void updateWbinfo(binfoDto udto) {
					SimpleDateFormat ymd = new SimpleDateFormat("yy/MM/dd");
					Calendar calendar = Calendar.getInstance();
					Date nd = calendar.getTime();
					String nowd = ymd.format(nd);
					System.out.println("업데이트 날짜 가져옴");


					Connection conn = null;
					PreparedStatement pstmt = null;
					String sql = "UPDATE w_binfo SET w_day=?, w_time=?, t_cnt=?, l_stand=?, s_day=?, description=?, u_date=? WHERE oid=?";
					try {
						conn = ju.getConnection();
					    pstmt = conn.prepareStatement(sql);


					    System.out.println(sql);

							pstmt.setString(1, udto.getW_day());
							pstmt.setString(2, udto.getW_time());
							pstmt.setString(3, udto.getT_cnt());
							pstmt.setString(4, udto.getL_stand());
							pstmt.setString(5, udto.getS_day());
							pstmt.setString(6, udto.getDescription());
							pstmt.setString(7, nowd);
							pstmt.setString(8, udto.getOid());

							pstmt.executeUpdate();
							System.out.println("SQL 실행완료");

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
