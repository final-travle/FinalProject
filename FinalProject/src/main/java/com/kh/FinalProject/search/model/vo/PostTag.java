package com.kh.FinalProject.search.model.vo;

import java.io.Serializable;

public class PostTag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5401701533311541651L;
	
	private String tagName;
	private String tagType;
	private String PostType;
	private int postNo;
	
	public PostTag() {
	}



	public PostTag(String tagName, String tagType, String postType, int postNo) {
		this.tagName = tagName;
		this.tagType = tagType;
		this.PostType = postType;
		this.postNo = postNo;
	}



	public String getTagName() {
		return tagName;
	}



	public void setTagName(String tagName) {
		this.tagName = tagName;
	}



	public String getTagType() {
		return tagType;
	}



	public void setTagType(String tagType) {
		this.tagType = tagType;
	}



	public String getPostType() {
		return PostType;
	}



	public void setPostType(String postType) {
		PostType = postType;
	}



	public int getPostNo() {
		return postNo;
	}



	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}



	@Override
	public String toString() {
		return "PostTag [tagName=" + tagName + ", tagType=" + tagType + ", PostType=" + PostType + ", postNo=" + postNo
				+ "]";
	}




	
}
