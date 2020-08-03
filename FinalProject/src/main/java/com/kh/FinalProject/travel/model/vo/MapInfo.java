package com.kh.FinalProject.travel.model.vo;

import java.io.Serializable;

public class MapInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4596112729825835212L;
	private int night;
	private String postType;
	private int postNo;
	
	public MapInfo() {}
	public MapInfo(int night, String postType, int postNo) {
		this.night = night;
		this.postType = postType;
		this.postNo = postNo;
	}
	public int getNight() {
		return night;
	}
	public void setNight(int night) {
		this.night = night;
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
		return "MapInfo [night=" + night + ", postType=" + postType + ", postNo=" + postNo + "]";
	}
	
	
}
