package com.kh.FinalProject.travel.model.vo;

import java.io.Serializable;

public class MapBoard implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5684838601854511477L;
	private String postType;
	private int postNo;
	private int voteTotal;
	private int likeTotal;
	public MapBoard() {}
	public MapBoard(String postType, int postNo, int voteTotal, int likeTotal) {
		this.postType = postType;
		this.postNo = postNo;
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
		return "MapBoard [postType=" + postType + ", postNo=" + postNo + ", voteTotal=" + voteTotal + ", likeTotal="
				+ likeTotal + "]";
	}
	
	
}
