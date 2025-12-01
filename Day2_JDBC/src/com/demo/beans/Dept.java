package com.demo.beans;

import java.time.LocalDate;

public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	private String  pwd;
	private LocalDate startedon;
	
	public Dept() {
		super();
	}

	public Dept(int deptno, String dname, String loc, String pwd, LocalDate startedon) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
		this.pwd = pwd;
		this.startedon = startedon;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public LocalDate getStartedon() {
		return startedon;
	}

	public void setStartedon(LocalDate startedon) {
		this.startedon = startedon;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + ", pwd=" + pwd + ", startedon="
				+ startedon + "]";
	}
	
	

}
