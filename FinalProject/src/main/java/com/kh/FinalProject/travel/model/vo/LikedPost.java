package com.kh.FinalProject.travel.model.vo;

import java.io.Serializable;

public class LikedPost implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6695750384614691473L;
	private String userId;
	private String postType;
	private int postNo;
	private String likeYn;
	public LikedPost() {}
	public LikedPost(String userId, String postType, int postNo, String likeYn) {
		this.userId = userId;
		this.postType = postType;
		this.postNo = postNo;
		this.likeYn = likeYn;
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
	public String getLikeYn() {
		return likeYn;
	}
	public void setLikeYn(String likeYn) {
		this.likeYn = likeYn;
	}
	@Override
	public String toString() {
		return "LikedPost [userId=" + userId + ", postType=" + postType + ", postNo=" + postNo + ", likeYn=" + likeYn
				+ "]";
	}
	
	
	
}
