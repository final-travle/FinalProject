package com.kh.FinalProject.travel.model.vo;

import java.io.Serializable;

public class Travel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8783019928456349946L;
	
	private int tCode;
	private String postType;
	private int postNo;
	private int night;
	private String tName;
	private double txpoint;
	private double typoint;
	
	public Travel() {}
	public Travel(int tCode, String postType, int postNo, int night, String tName, double txpoint, double typoint) {
		this.tCode = tCode;
		this.postType = postType;
		this.postNo = postNo;
		this.night = night;
		this.tName = tName;
		this.txpoint = txpoint;
		this.typoint = typoint;
	}
	public int gettCode() {
		return tCode;
	}
	public void settCode(int tCode) {
		this.tCode = tCode;
	}
	public String getPostType() {
		return postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public int getNight() {
		return night;
	}
	public void setNight(int night) {
		this.night = night;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public double getTxpoint() {
		return txpoint;
	}
	public void setTxpoint(double txpoint) {
		this.txpoint = txpoint;
	}
	public double getTypoint() {
		return typoint;
	}
	public void setTypoint(double typoint) {
		this.typoint = typoint;
	}
	@Override
	public String toString() {
		return "Travel [tCode=" + tCode + ", postType=" + postType + ", postNo=" + postNo + ", night=" + night
				+ ", tName=" + tName + ", txpoint=" + txpoint + ", typoint=" + typoint + "]";
	}
	
	
	
	
	
	
	
}
