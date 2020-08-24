package com.kh.FinalProject.common.model.vo;

import java.io.Serializable;

public class PostBoard implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9000154065065737596L;
	private String postType;
	private int postNo;
	private String thumbnail;
	private String userId;
	private String title;
	private int voteTotal;
	private int likeTotal;
	
	public PostBoard() {}
	public PostBoard(String postType, int postNo, String thumbnail, String userId, String title, int voteTotal,
			int likeTotal) {
		this.postType = postType;
		this.postNo = postNo;
		this.thumbnail = thumbnail;
		this.userId = userId;
		this.title = title;
		this.voteTotal = voteTotal;
		this.likeTotal = likeTotal;
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
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getVoteTotal() {
		return voteTotal;
	}
	public void setVoteTotal(int voteTotal) {
		this.voteTotal = voteTotal;
	}
	public int getLikeTotal() {
		return likeTotal;
	}
	public void setLikeTotal(int likeTotal) {
		this.likeTotal = likeTotal;
	}
	@Override
	public String toString() {
		return "PostBoard [postType=" + postType + ", postNo=" + postNo + ", thumbnail=" + thumbnail + ", userId="
				+ userId + ", title=" + title + ", voteTotal=" + voteTotal + ", likeTotal=" + likeTotal + "]";
	}
	
	
}
