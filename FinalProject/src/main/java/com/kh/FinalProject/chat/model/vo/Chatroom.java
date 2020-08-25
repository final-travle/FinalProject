package com.kh.FinalProject.chat.model.vo;

import java.io.Serializable;
import java.util.Date;

public class Chatroom implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8668701317369570430L;
	
	private String chatroom_no;	//채팅방번호
	private String chatroomname;	//채팅방 이름
	private String chatroomdetail; //채팅방 소개?
	private String creater;				//방만든사람
	private int current_no;				//채팅방 현재인원수
	private Date createdate;			//방 생성 날짜
	private String open_notice;
	private String open_background;
	private String open_frbackground;
	
	public Chatroom() {}

	public Chatroom(String chatroom_no, String chatroomname, String chatroomdetail, String creater, int current_no,
			Date createdate, String open_notice, String open_background, String open_frbackground) {
		super();
		this.chatroom_no = chatroom_no;
		this.chatroomname = chatroomname;
		this.chatroomdetail = chatroomdetail;
		this.creater = creater;
		this.current_no = current_no;
		this.createdate = createdate;
		this.open_notice = open_notice;
		this.open_background = open_background;
		this.open_frbackground = open_frbackground;
	}

	public String getChatroom_no() {
		return chatroom_no;
	}

	public void setChatroom_no(String chatroom_no) {
		this.chatroom_no = chatroom_no;
	}

	public String getChatroomname() {
		return chatroomname;
	}

	public void setChatroomname(String chatroomname) {
		this.chatroomname = chatroomname;
	}

	public String getChatroomdetail() {
		return chatroomdetail;
	}

	public void setChatroomdetail(String chatroomdetail) {
		this.chatroomdetail = chatroomdetail;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public int getCurrent_no() {
		return current_no;
	}

	public void setCurrent_no(int current_no) {
		this.current_no = current_no;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getOpen_notice() {
		return open_notice;
	}

	public void setOpen_notice(String open_notice) {
		this.open_notice = open_notice;
	}

	public String getOpen_background() {
		return open_background;
	}

	public void setOpen_background(String open_background) {
		this.open_background = open_background;
	}

	public String getOpen_frbackground() {
		return open_frbackground;
	}

	public void setOpen_frbackground(String open_frbackground) {
		this.open_frbackground = open_frbackground;
	}

	@Override
	public String toString() {
		return "Chatroom [chatroom_no=" + chatroom_no + ", chatroomname=" + chatroomname + ", chatroomdetail="
				+ chatroomdetail + ", creater=" + creater + ", current_no=" + current_no + ", createdate=" + createdate
				+ ", open_notice=" + open_notice + ", open_background=" + open_background + ", open_frbackground="
				+ open_frbackground + "]";
	}
	
	
}







