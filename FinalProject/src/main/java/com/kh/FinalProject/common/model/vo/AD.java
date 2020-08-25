package com.kh.FinalProject.common.model.vo;

import java.io.Serializable;

public class AD implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4655390479056594637L;
	private int adNo;
	private String adTitle;
	private String adContents;
	private String adImg;
	private String adLink;
	private String tagName;
	private String tagType;
	
	public AD() {}
	public AD(int adNo, String adTitle, String adContents, String adImg, String adLink, String tagName,
			String tagType) {
		this.adNo = adNo;
		this.adTitle = adTitle;
		this.adContents = adContents;
		this.adImg = adImg;
		this.adLink = adLink;
		this.tagName = tagName;
		this.tagType = tagType;
	}
	public int getAdNo() {
		return adNo;
	}
	public void setAdNo(int adNo) {
		this.adNo = adNo;
	}
	public String getAdTitle() {
		return adTitle;
	}
	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}
	public String getAdContents() {
		return adContents;
	}
	public void setAdContents(String adContents) {
		this.adContents = adContents;
	}
	public String getAdImg() {
		return adImg;
	}
	public void setAdImg(String adImg) {
		this.adImg = adImg;
	}
	public String getAdLink() {
		return adLink;
	}
	public void setAdLink(String adLink) {
		this.adLink = adLink;
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
		return "AD [adNo=" + adNo + ", adTitle=" + adTitle + ", adContents=" + adContents + ", adImg=" + adImg
				+ ", adLink=" + adLink + ", tagName=" + tagName + ", tagType=" + tagType + "]";
	}
	
}
