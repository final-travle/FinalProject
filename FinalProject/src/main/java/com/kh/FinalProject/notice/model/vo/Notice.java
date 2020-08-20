package com.kh.FinalProject.notice.model.vo;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Notice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9073615018125019014L;
	
	private String postType;
	private int postNo;
	private String thumbnail;
	private String userId;
	private String title;
	private String postContents;
	private int hits;
	private Date writeDate;
	private String postDelYn;
	private String fileName;
	
	public Notice() {
	}

	public Notice(String postType, int postNo, String thumbnail, String userId, String title, String postContents,
			int hits, Date writeDate, String postDelYn, String fileName) {
		this.postType = postType;
		this.postNo = postNo;
		this.thumbnail = thumbnail;
		this.userId = userId;
		this.title = title;
		this.postContents = postContents;
		this.hits = hits;
		this.writeDate = writeDate;
		this.postDelYn = postDelYn;
		this.fileName = fileName;
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

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getPostDelYn() {
		return postDelYn;
	}

	public void setPostDelYn(String postDelYn) {
		this.postDelYn = postDelYn;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "Notice [postType=" + postType + ", postNo=" + postNo + ", thumbnail=" + thumbnail + ", userId=" + userId
				+ ", title=" + title + ", postContents=" + postContents + ", hits=" + hits + ", writeDate=" + writeDate
				+ ", postDelYn=" + postDelYn + ", fileName=" + fileName + "]";
	}


	
	
	
	
	
}
