package com.kh.FinalProject.chat.model.vo;

import java.io.Serializable;

public class OneToOne implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5736705719357646342L;
	int co_no;
	String myId;
	String friendId;
	
	public OneToOne() {}
	public OneToOne(int co_no, String myId, String friendId) {
		super();
		this.co_no = co_no;
		this.myId = myId;
		this.friendId = friendId;
	}
	public int getCo_no() {
		return co_no;
	}
	public void setCo_no(int co_no) {
		this.co_no = co_no;
	}
	public String getMyId() {
		return myId;
	}
	public void setMyId(String myId) {
		this.myId = myId;
	}
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	@Override
	public String toString() {
		return "OneToOne [co_no=" + co_no + ", myId=" + myId + ", friendId=" + friendId + "]";
	}
	
}







