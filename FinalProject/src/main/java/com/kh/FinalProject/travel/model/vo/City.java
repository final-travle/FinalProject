package com.kh.FinalProject.travel.model.vo;

import java.io.Serializable;

public class City implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1885661999728411638L;
	private String ctName;
	private String ctCode;
	public City() {}
	public City(String ctName, String ctCode) {
		this.ctName = ctName;
		this.ctCode = ctCode;
	}
	public String getCtName() {
		return ctName;
	}
	public void setCtName(String ctName) {
		this.ctName = ctName;
	}
	public String getCtCode() {
		return ctCode;
	}
	public void setCtCode(String ctCode) {
		this.ctCode = ctCode;
	}
	@Override
	public String toString() {
		return "City [ctName=" + ctName + ", ctCode=" + ctCode + "]";
	}
	
	
}