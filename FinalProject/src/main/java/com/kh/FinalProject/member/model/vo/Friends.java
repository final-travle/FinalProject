package com.kh.FinalProject.member.model.vo;

public class Friends {
	private int fNo;
	private String userId;
	private String fId;
	private String fnickname;
	private String fprofile;
	private String acceptYn;
	
	public Friends() {}
	public Friends(int fNo, String userId, String fId, String fnickname, String fprofile, String acceptYn) {
		super();
		this.fNo = fNo;
		this.userId = userId;
		this.fId = fId;
		this.fnickname = fnickname;
		this.fprofile = fprofile;
		this.acceptYn = acceptYn;
	}
	public int getfNo() {
		return fNo;
	}
	public void setfNo(int fNo) {
		this.fNo = fNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	public String getFnickname() {
		return fnickname;
	}
	public void setFnickname(String fnickname) {
		this.fnickname = fnickname;
	}
	public String getFprofile() {
		return fprofile;
	}
	public void setFprofile(String fprofile) {
		this.fprofile = fprofile;
	}
	public String getAcceptYn() {
		return acceptYn;
	}
	public void setAcceptYn(String acceptYn) {
		this.acceptYn = acceptYn;
	}
	@Override
	public String toString() {
		return "Friends [fNo=" + fNo + ", userId=" + userId + ", fId=" + fId + ", fnickname=" + fnickname
				+ ", fprofile=" + fprofile + ", acceptYn=" + acceptYn + "]";
	}
	
	
	
}