package com.kh.FinalProject.common.model.vo;

import java.io.Serializable;

public class PrefStyle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6675965090722417043L;
	private String travStyle;
	private String userId;
	public PrefStyle(String travStyle, String userId) {
		super();
		this.travStyle = travStyle;
		this.userId = userId;
	}
	public String getTravStyle() {
		return travStyle;
	}
	public void setTravStyle(String travStyle) {
		this.travStyle = travStyle;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PrefStyle [travStyle=" + travStyle + ", userId=" + userId + "]";
	}
	
}
