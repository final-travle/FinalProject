package com.kh.FinalProject.chat.model.vo;

import java.io.Serializable;

import com.kh.FinalProject.member.model.vo.Member;

public class OneToOne implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5736705719357646342L;
	private String co_no;
	private String myId;
	private String friendId;
	private String oto_notice;
	private String oto_mybackground;
	private String oto_frbackground;
	
	private String nickname;
	private String profile;
	private int message_no;
	private String message_cont;
	private String sent_date;
	private int count;
	
	public OneToOne() {}

	public OneToOne(String co_no, String myId, String friendId, String oto_notice, String oto_mybackground,
			String oto_frbackground, String nickname, String profile, int message_no, String message_cont,
			String sent_date, int count) {
		super();
		this.co_no = co_no;
		this.myId = myId;
		this.friendId = friendId;
		this.oto_notice = oto_notice;
		this.oto_mybackground = oto_mybackground;
		this.oto_frbackground = oto_frbackground;
		this.nickname = nickname;
		this.profile = profile;
		this.message_no = message_no;
		this.message_cont = message_cont;
		this.sent_date = sent_date;
		this.count = count;
	}

	public String getCo_no() {
		return co_no;
	}

	public void setCo_no(String co_no) {
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

	public String getOto_notice() {
		return oto_notice;
	}

	public void setOto_notice(String oto_notice) {
		this.oto_notice = oto_notice;
	}

	public String getOto_mybackground() {
		return oto_mybackground;
	}

	public void setOto_mybackground(String oto_mybackground) {
		this.oto_mybackground = oto_mybackground;
	}

	public String getOto_frbackground() {
		return oto_frbackground;
	}

	public void setOto_frbackground(String oto_frbackground) {
		this.oto_frbackground = oto_frbackground;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public int getMessage_no() {
		return message_no;
	}

	public void setMessage_no(int message_no) {
		this.message_no = message_no;
	}

	public String getMessage_cont() {
		return message_cont;
	}

	public void setMessage_cont(String message_cont) {
		this.message_cont = message_cont;
	}

	public String getSent_date() {
		return sent_date;
	}

	public void setSent_date(String sent_date) {
		this.sent_date = sent_date;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "OneToOne [co_no=" + co_no + ", myId=" + myId + ", friendId=" + friendId + ", oto_notice=" + oto_notice
				+ ", oto_mybackground=" + oto_mybackground + ", oto_frbackground=" + oto_frbackground + ", nickname="
				+ nickname + ", profile=" + profile + ", message_no=" + message_no + ", message_cont=" + message_cont
				+ ", sent_date=" + sent_date + ", count=" + count + "]";
	}
	
}







