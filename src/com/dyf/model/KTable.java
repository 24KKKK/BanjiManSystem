package com.dyf.model;

import java.util.HashSet;
import java.util.Set;

/**
 * KTable entity. @author MyEclipse Persistence Tools
 */

public class KTable implements java.io.Serializable {

	// Fields

	private String kid;
	private String kname;
	private String knature;
	private Double kxf;
	private Set CTables = new HashSet(0);

	// Constructors

	/** default constructor */
	public KTable() {
	}

	/** minimal constructor */
	public KTable(String kid, String kname, String knature, Double kxf) {
		this.kid = kid;
		this.kname = kname;
		this.knature = knature;
		this.kxf = kxf;
	}

	/** full constructor */
	public KTable(String kid, String kname, String knature, Double kxf,
			Set CTables) {
		this.kid = kid;
		this.kname = kname;
		this.knature = knature;
		this.kxf = kxf;
		this.CTables = CTables;
	}

	// Property accessors

	public String getKid() {
		return this.kid;
	}

	public void setKid(String kid) {
		this.kid = kid;
	}

	public String getKname() {
		return this.kname;
	}

	public void setKname(String kname) {
		this.kname = kname;
	}

	public String getKnature() {
		return this.knature;
	}

	public void setKnature(String knature) {
		this.knature = knature;
	}

	public Double getKxf() {
		return this.kxf;
	}

	public void setKxf(Double kxf) {
		this.kxf = kxf;
	}

	public Set getCTables() {
		return this.CTables;
	}

	public void setCTables(Set CTables) {
		this.CTables = CTables;
	}

	@Override
	public String toString() {
		return "KTable [kid=" + kid + ", kname=" + kname + ", knature="
				+ knature + ", kxf=" + kxf + "]";
	}


}