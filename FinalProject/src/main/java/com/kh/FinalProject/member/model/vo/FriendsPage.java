package com.kh.FinalProject.member.model.vo;

public class FriendsPage {

	private	String type;
	private String search;
	private String userId;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "FriendsPage [type=" + type + ", search=" + search + ", userId=" + userId + "]";
	}

	public FriendsPage(String type, String search, String userId) {
		super();
		this.type = type;
		this.search = search;
		this.userId = userId;
	}

	public FriendsPage() {
		super();
	}
	
}
