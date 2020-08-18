package com.kh.FinalProject.search.model.vo;

import java.io.Serializable;

public class Tag implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3045123783756963438L;
		
	private String tagName;
	private String tagType;
	
	public Tag() {
	}

	public Tag(String tagName, String tagType) {
		this.tagName = tagName;
		this.tagType = tagType;
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

	@Override
	public String toString() {
		return "Tag [tagName=" + tagName + ", tagType=" + tagType + "]";
	}
	
	
	
	
}
