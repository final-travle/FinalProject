package com.kh.FinalProject.chat.model.vo;

import java.io.Serializable;

public class OneToOneMsg implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4699136130996987162L;
	
	private int message_no;
	private String co_no;
	private String chatId;
	private String content;
	private String send_image;
	private String sentDate;
	private String read_yn;
	
	private String profile;
	private String nickname;
	private int count;
	
	public OneToOneMsg() {}

	public OneToOneMsg(int message_no, String co_no, String chatId, String content, String send_image, String sentDate,
			String read_yn, String profile, String nickname, int count) {
		super();
		this.message_no = message_no;
		this.co_no = co_no;
		this.chatId = chatId;
		this.content = content;
		this.send_image = send_image;
		this.sentDate = sentDate;
		this.read_yn = read_yn;
		this.profile = profile;
		this.nickname = nickname;
		this.count = count;
	}

	public int getMessage_no() {
		return message_no;
	}

	public void setMessage_no(int message_no) {
		this.message_no = message_no;
	}

	public String getCo_no() {
		return co_no;
	}

	public void setCo_no(String co_no) {
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

	public String getSend_image() {
		return send_image;
	}

	public void setSend_image(String send_image) {
		this.send_image = send_image;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "OneToOneMsg [message_no=" + message_no + ", co_no=" + co_no + ", chatId=" + chatId + ", content="
				+ content + ", send_image=" + send_image + ", sentDate=" + sentDate + ", read_yn=" + read_yn
				+ ", profile=" + profile + ", nickname=" + nickname + ", count=" + count + "]";
	}
	
}













