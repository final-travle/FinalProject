package com.kh.FinalProject.travel.model.vo;

import java.io.Serializable;

public class PostTag implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4501095642646808877L;
	private String tagType;
	private String tagName;
	private String postType;
	private int postNo;
	public PostTag() {}
	public PostTag(String tagType, String tagName, String postType, int postNo) {
		this.tagType = tagType;
		this.tagName = tagName;
		this.postType = postType;
		this.postNo = postNo;
	}
	public String getTagType() {
		return tagType;
	}
	public void setTagType(String tagType) {
		this.tagType = tagType;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
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
	@Override
	public String toString() {
		return "PostTag [tagType=" + tagType + ", tagName=" + tagName + ", postType=" + postType + ", postNo=" + postNo
				+ "]";
	}
	
	
}
