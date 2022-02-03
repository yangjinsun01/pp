package dto;

import java.sql.Date;

public class fmiddleDto {
	
	private String oid;
	private String b_oid;
	private String c_type;
	private String p_name;
	private String p_no;
	private String gubun;
	private Date c_date;
	private Date u_date;
	private String description;
	
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getB_oid() {
		return b_oid;
	}

	public void setB_oid(String b_oid) {
		this.b_oid = b_oid;
	}

	public String getC_type() {
		return c_type;
	}

	public void setC_type(String c_type) {
		this.c_type = c_type;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_no() {
		return p_no;
	}

	public void setP_no(String p_no) {
		this.p_no = p_no;
	}

	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	public Date getC_date() {
		return c_date;
	}

	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}

	public Date getU_date() {
		return u_date;
	}

	public void setU_date(Date u_date) {
		this.u_date = u_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public fmiddleDto() {
		
	}
	
	
	
}
