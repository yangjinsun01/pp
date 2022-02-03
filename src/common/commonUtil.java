package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class commonUtil {
	private JdbcUtil ju;

	String upload_path="e:/uploadFile";
	
	public commonUtil() {
		ju = JdbcUtil.getInstance();
	}
	//년2월2일2 리턴
	public String retDate() {  
		LocalDate now = LocalDate.now();
		String initFirstDate = ((now.toString()).replace("-", "")).substring(2);
		return initFirstDate;
	}
	
	//해당 날짜의 "날짜+MAX+1"을 리턴(preFix : P-, F-... objName : 테이블 명)
	public String retOid(String preFix, String ObjName) {
		String initAllDate = retDate()+"-"+initSecondDate(preFix, ObjName);		
		return initAllDate;
	}
	
    //해당 날짜의 MAX+1값을 리턴
	public String initSecondDate(String preFix, String objName){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String initFirstDate = retDate(); //년월일
		int initIntSecondDate = 0; //SEQ INT
		String initStrSecondDate = ""; //SEQ STR
		String query = "select substr(max(OID),-2) from "+preFix+objName+" where OID like '%211230%'";
		try {
			con = ju.getConnection();
			pstmt = con.prepareStatement(query);
			//pstmt.setString(1, "%"+preFix+initFirstDate+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getRow() == 0) {	
					initStrSecondDate = "01";
				}else {
						initIntSecondDate = Integer.parseInt(rs.getString(1))+1;
						initStrSecondDate = String.valueOf(initIntSecondDate);
				}				
			}
		}catch(SQLException e) {
				e.printStackTrace();
		}finally {
				if(rs != null) {
					try{
						rs.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
				if(pstmt != null) {
					try{
						pstmt.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
				if(con != null) {
					try{
						con.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
		return initStrSecondDate;
		}
}
