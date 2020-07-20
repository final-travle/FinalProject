package com.kh.FinalProject.member.model.vo;

public class Friends {
	private int fNo;
	private String userId;
	private String fId;
	private String acceptYn;
	public Friends(int fNo, String userId, String fId, String acceptYn) {
		super();
		this.fNo = fNo;
		this.userId = userId;
		this.fId = fId;
		this.acceptYn = acceptYn;
	}
	
	public Friends() {
		super();
	}

	@Override
	public String toString() {
		return "Friends [fNo=" + fNo + ", userId=" + userId + ", fId=" + fId + ", acceptYn=" + acceptYn + "]";
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
	public String getAcceptYn() {
		return acceptYn;
	}
	public void setAcceptYn(String acceptYn) {
		this.acceptYn = acceptYn;
	}
	
	
	
}