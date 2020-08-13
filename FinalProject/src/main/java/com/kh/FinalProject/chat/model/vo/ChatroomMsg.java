package com.kh.FinalProject.chat.model.vo;

import java.io.Serializable;

public class ChatroomMsg implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2436948477533030699L;
	
	private int message_no;
	private int cr_no;
	private String chat_id;
	private String chat_content;
	
	private String nickname;
	private String profile;
	
	public ChatroomMsg() {}

	public ChatroomMsg(int message_no, int cr_no, String chat_id, String chat_content, String nickname,
			String profile) {
		super();
		this.message_no = message_no;
		this.cr_no = cr_no;
		this.chat_id = chat_id;
		this.chat_content = chat_content;
		this.nickname = nickname;
		this.profile = profile;
	}

	public int getMessage_no() {
		return message_no;
	}

	public void setMessage_no(int message_no) {
		this.message_no = message_no;
	}

	public int getCr_no() {
		return cr_no;
	}

	public void setCr_no(int cr_no) {
		this.cr_no = cr_no;
	}

	public String getChat_id() {
		return chat_id;
	}

	public void setChat_id(String chat_id) {
		this.chat_id = chat_id;
	}

	public String getChat_content() {
		return chat_content;
	}

	public void setChat_content(String chat_content) {
		this.chat_content = chat_content;
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

	@Override
	public String toString() {
		return "ChatroomMsg [message_no=" + message_no + ", cr_no=" + cr_no + ", chat_id=" + chat_id + ", chat_content="
				+ chat_content + ", nickname=" + nickname + ", profile=" + profile + "]";
	}
	
	
	
}
