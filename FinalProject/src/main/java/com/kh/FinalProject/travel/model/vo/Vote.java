package com.kh.FinalProject.travel.model.vo;

import java.io.Serializable;

public class Vote implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5798227760172297452L;
	private String userId;
	private String postType;
	private int postNo;
	private String postYn;
	public Vote() {}
	public Vote(String userId, String postType, int postNo, String postYn) {
		this.userId = userId;
		this.postType = postType;
		this.postNo = postNo;
		this.postYn = postYn;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getPostYn() {
		return postYn;
	}
	public void setPostYn(String postYn) {
		this.postYn = postYn;
	}
	@Override
	public String toString() {
		return "Vote [userId=" + userId + ", postType=" + postType + ", postNo=" + postNo + ", postYn=" + postYn + "]";
	}
	
	
}
