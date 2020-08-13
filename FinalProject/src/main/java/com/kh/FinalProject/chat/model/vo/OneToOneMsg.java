package com.kh.FinalProject.chat.model.vo;

import java.io.Serializable;

public class OneToOneMsg implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4699136130996987162L;
	
	private int message_no;
	private int co_no;
	private String chatId;
	private String content;
	private String sentDate;
	private String read_yn;
	
	private String profile;
	private String nickname;
	
	public OneToOneMsg() {}

	public OneToOneMsg(int message_no, int co_no, String chatId, String content, String sentDate, String read_yn,
			String profile, String nickname) {
		super();
		this.message_no = message_no;
		this.co_no = co_no;
		this.chatId = chatId;
		this.content = content;
		this.sentDate = sentDate;
		this.read_yn = read_yn;
		this.profile = profile;
		this.nickname = nickname;
	}

	public int getMessage_no() {
		return message_no;
	}

	public void setMessage_no(int message_no) {
		this.message_no = message_no;
	}

	public int getCo_no() {
		return co_no;
	}

	public void setCo_no(int co_no) {
		this.co_no = co_no;
	}

	public String getChatId() {
		return chatId;
	}

	public void setChatId(String chatId) {
		this.chatId = chatId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSentDate() {
		return sentDate;
	}

	public void setSentDate(String sentDate) {
		this.sentDate = sentDate;
	}

	public String getRead_yn() {
		return read_yn;
	}

	public void setRead_yn(String read_yn) {
		this.read_yn = read_yn;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "OneToOneMsg [message_no=" + message_no + ", co_no=" + co_no + ", chatId=" + chatId + ", content="
				+ content + ", sentDate=" + sentDate + ", read_yn=" + read_yn + ", profile=" + profile + ", nickname="
				+ nickname + "]";
	}
	
}













