package com.kh.FinalProject.travel.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class ReComments implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 16670827122076639L;
	private int rcmntNo;
	private int cmntNo;
	private String postType;
	private int postNo;
	private String rcmntWirter;
	private String rcmntContents;
	private Date rcmntDate;
	public ReComments() {}
	public ReComments(int rcmntNo, int cmntNo, String postType, int postNo, String rcmntWirter, String rcmntContents,
			Date rcmntDate) {
		this.rcmntNo = rcmntNo;
		this.cmntNo = cmntNo;
		this.postType = postType;
		this.postNo = postNo;
		this.rcmntWirter = rcmntWirter;
		this.rcmntContents = rcmntContents;
		this.rcmntDate = rcmntDate;
	}
	public int getRcmntNo() {
		return rcmntNo;
	}
	public void setRcmntNo(int rcmntNo) {
		this.rcmntNo = rcmntNo;
	}
	public int getCmntNo() {
		return cmntNo;
	}
	public void setCmntNo(int cmntNo) {
		this.cmntNo = cmntNo;
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
	public String getRcmntWirter() {
		return rcmntWirter;
	}
	public void setRcmntWirter(String rcmntWirter) {
		this.rcmntWirter = rcmntWirter;
	}
	public String getRcmntContents() {
		return rcmntContents;
	}
	public void setRcmntContents(String rcmntContents) {
		this.rcmntContents = rcmntContents;
	}
	public Date getRcmntDate() {
		return rcmntDate;
	}
	public void setRcmntDate(Date rcmntDate) {
		this.rcmntDate = rcmntDate;
	}
	@Override
	public String toString() {
		return "ReComments [rcmntNo=" + rcmntNo + ", cmntNo=" + cmntNo + ", postType=" + postType + ", postNo=" + postNo
				+ ", rcmntWirter=" + rcmntWirter + ", rcmntContents=" + rcmntContents + ", rcmntDate=" + rcmntDate
				+ "]";
	}
	
}
