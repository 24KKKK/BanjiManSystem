package com.dyf.model;

import java.util.HashSet;
import java.util.Set;

/**
 * STable entity. @author MyEclipse Persistence Tools
 */

public class STable implements java.io.Serializable {

	// Fields

	private String sid;
	private BTable BTable;
	private String sname;
	private String ssex;
	private String spassword;
	private String slxdh;
	private String sjtzz;
	private Set CTables = new HashSet(0);

	// Constructors

	/** default constructor */
	public STable() {
	}

	/** minimal constructor */
	public STable(String sid) {
		this.sid = sid;
	}

	/** full constructor */
	public STable(String sid, BTable BTable, String sname, String ssex,
			String spassword, String slxdh, String sjtzz, Set CTables) {
		this.sid = sid;
		this.BTable = BTable;
		this.sname = sname;
		this.ssex = ssex;
		this.spassword = spassword;
		this.slxdh = slxdh;
		this.sjtzz = sjtzz;
		this.CTables = CTables;
	}

	// Property accessors

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public BTable getBTable() {
		return this.BTable;
	}

	public void setBTable(BTable BTable) {
		this.BTable = BTable;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSsex() {
		return this.ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public String getSpassword() {
		return this.spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

	public String getSlxdh() {
		return this.slxdh;
	}

	public void setSlxdh(String slxdh) {
		this.slxdh = slxdh;
	}

	public String getSjtzz() {
		return this.sjtzz;
	}

	public void setSjtzz(String sjtzz) {
		this.sjtzz = sjtzz;
	}

	public Set getCTables() {
		return this.CTables;
	}

	public void setCTables(Set CTables) {
		this.CTables = CTables;
	}

	@Override
	public String toString() {
		return "STable [sid=" + sid + ", sname=" + sname + ", ssex=" + ssex
				+ ", spassword=" + spassword + ", slxdh=" + slxdh + ", sjtzz="
				+ sjtzz + "]";
	}

	

}