package com.kh.FinalProject.search.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1028885829963173839L;
	
	
	private String postType;
	private int postNo;
	private String thumbnail;
	private String userId;
	private String title;
	private String postContents;
	private int hits;
	private Date wirteDate;
	private String postDelYn;
	private String FileName;
	
	
	public Board() {}
	

	public Board(int postNo) {
		this.postNo = postNo;
	}
	
	public Board(String postType, int postNo, String thumbnail, String userId, String title) {	
		this.postType = postType;
		this.postNo = postNo;
		this.thumbnail = thumbnail;
		this.userId = userId;
		this.title = title;
	}



	public Board(String postType, int postNo, String thumbnail, String userId, String title, String postContents,
			int hits, Date wirteDate, String postDelYn, String fileName) {
		this.postType = postType;
		this.postNo = postNo;
		this.thumbnail = thumbnail;
		this.userId = userId;
		this.title = title;
		this.postContents = postContents;
		this.hits = hits;
		this.wirteDate = wirteDate;
		this.postDelYn = postDelYn;
		FileName = fileName;
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


	public String getPostContents() {
		return postContents;
	}


	public void setPostContents(String postContents) {
		this.postContents = postContents;
	}


	public int getHits() {
		return hits;
	}


	public void setHits(int hits) {
		this.hits = hits;
	}


	public Date getWirteDate() {
		return wirteDate;
	}


	public void setWirteDate(Date wirteDate) {
		this.wirteDate = wirteDate;
	}


	public String getPostDelYn() {
		return postDelYn;
	}


	public void setPostDelYn(String postDelYn) {
		this.postDelYn = postDelYn;
	}


	public String getFileName() {
		return FileName;
	}


	public void setFileName(String fileName) {
		FileName = fileName;
	}


	@Override
	public String toString() {
		return "Board [postType=" + postType + ", postNo=" + postNo + ", thumbnail=" + thumbnail + ", userId=" + userId
				+ ", title=" + title + ", postContents=" + postContents + ", hits=" + hits + ", wirteDate=" + wirteDate
				+ ", postDelYn=" + postDelYn + ", FileName=" + FileName + "]";
	}
	
	

}
