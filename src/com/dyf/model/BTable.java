package com.dyf.model;

import java.util.HashSet;
import java.util.Set;

/**
 * BTable entity. @author MyEclipse Persistence Tools
 */

public class BTable implements java.io.Serializable {

	// Fields

	private String bid;
	private String bname;
	private Set STables = new HashSet(0);

	// Constructors

	/** default constructor */
	public BTable() {
	}

	/** minimal constructor */
	public BTable(String bid) {
		this.bid = bid;
	}

	/** full constructor */
	public BTable(String bid, String bname, Set STables) {
		this.bid = bid;
		this.bname = bname;
		this.STables = STables;
	}

	// Property accessors

	public String getBid() {
		return this.bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Set getSTables() {
		return this.STables;
	}

	public void setSTables(Set STables) {
		this.STables = STables;
	}

	@Override
	public String toString() {
		return "BTable [bid=" + bid + ", bname=" + bname + "]";
	}


}