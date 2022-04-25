package com.LoginDto;

public class LDto {
	private int lno;
	private String lid;
	private String lpw;
	private String lemail;
	private int lage;
	private String lsex;
	private String luser;
	public LDto(int lno, String lid, String lpw, String lemail, int lage, String lsex, String luser,
			 String lresult, String sort) {
		super();
		this.lno = lno;
		this.lid = lid;
		this.lpw = lpw;
		this.lemail = lemail;
		this.lage = lage;
		this.lsex = lsex;
		this.luser = luser;
		this.lresult = lresult;
		this.sort = sort;
	}


	private String lresult;
	private String sort;
	public LDto() {
		super();
	}
	
	

	public LDto(int lno, String lid, String lpw, String lemail, int lage, String lsex, String luser) {
		super();
		this.lno = lno;
		this.lid = lid;
		this.lpw = lpw;
		this.lemail = lemail;
		this.lage = lage;
		this.lsex = lsex;
		this.luser = luser;
	}
	public int getLno() {
		return lno;
	}
	public void setLno(int lno) {
		this.lno = lno;
	}
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	public String getLemail() {
		return lemail;
	}
	public void setLemail(String lemail) {
		this.lemail = lemail;
	}
	
	public int getLage() {
		return lage;
	}
	public void setLage(int lage) {
		this.lage = lage;
	}
	public String getLsex() {
		return lsex;
	}
	public void setLsex(String lsex) {
		this.lsex = lsex;
	}
	public String getLuser() {
		return luser;
	}
	public void setLuser(String luser) {
		this.luser = luser;
	}
	
	
	public String getLpw() {
		return lpw;
	}
	public void setLpw(String lpw) {
		this.lpw = lpw;
	}


	public String getLresult() {
		return lresult;
	}


	public void setLresult(String lresult) {
		this.lresult = lresult;
	}


	public String getSort() {
		return sort;
	}


	public void setSort(String sort) {
		this.sort = sort;
	}
}
