package com.kh.FinalProject.travel.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Comments implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7234093535437378561L;
	private int cmntNo;
	private String postType;
	private int postNo;
	private String cmntWirter;
	private String cmntContents;
	private Date cmntDate;
	public Comments() {}
	public Comments(int cmntNo, String postType, int postNo, String cmntWirter, String cmntContents, Date cmntDate) {
		this.cmntNo = cmntNo;
		this.postType = postType;
		this.postNo = postNo;
		this.cmntWirter = cmntWirter;
		this.cmntContents = cmntContents;
		this.cmntDate = cmntDate;
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
	public String getCmntWirter() {
		return cmntWirter;
	}
	public void setCmntWirter(String cmntWirter) {
		this.cmntWirter = cmntWirter;
	}
	public String getCmntContents() {
		return cmntContents;
	}
	public void setCmntContents(String cmntContents) {
		this.cmntContents = cmntContents;
	}
	public Date getCmntDate() {
		return cmntDate;
	}
	public void setCmntDate(Date cmntDate) {
		this.cmntDate = cmntDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Comments [cmntNo=" + cmntNo + ", postType=" + postType + ", postNo=" + postNo + ", cmntWirter="
				+ cmntWirter + ", cmntContents=" + cmntContents + ", cmntDate=" + cmntDate + "]";
	}
	
	
	
}
