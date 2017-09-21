package com.dyf.model;

/**
 * CTable entity. @author MyEclipse Persistence Tools
 */

public class CTable implements java.io.Serializable {

	// Fields

	private Long cid;
	private STable STable;
	private KTable KTable;
	private Double ccj;

	// Constructors

	/** default constructor */
	public CTable() {
	}

	/** minimal constructor */
	public CTable(Long cid, STable STable, KTable KTable) {
		this.cid = cid;
		this.STable = STable;
		this.KTable = KTable;
	}

	/** full constructor */
	public CTable(Long cid, STable STable, KTable KTable, Double ccj) {
		this.cid = cid;
		this.STable = STable;
		this.KTable = KTable;
		this.ccj = ccj;
	}

	// Property accessors

	public Long getCid() {
		return this.cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public STable getSTable() {
		return this.STable;
	}

	public void setSTable(STable STable) {
		this.STable = STable;
	}

	public KTable getKTable() {
		return this.KTable;
	}

	public void setKTable(KTable KTable) {
		this.KTable = KTable;
	}

	public Double getCcj() {
		return this.ccj;
	}

	public void setCcj(Double ccj) {
		this.ccj = ccj;
	}

}