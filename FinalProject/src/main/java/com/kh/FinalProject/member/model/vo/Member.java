package com.kh.FinalProject.member.model.vo;

import java.io.Serializable;
import java.sql.Date;



public class Member implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	private String id;
	private String pwd;
	private String name;
	private String nickname;
	private String birth;
	private String gender;
	private String job;
	private String email;
	private String phone;
	private String withd_yn;
	private Date join_date;
	private Date field;
	private String time;
	private String profile;
	
	private String chatroom_no;
	
	public Member(){}

	
	
	public Member(String id, String pwd, String name, String nickname, String birth, String gender, String job,
			String email, String phone, String withd_yn) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nickname = nickname;
		this.birth = birth;
		this.gender = gender;
		this.job = job;
		this.email = email;
		this.phone = phone;
		this.withd_yn = withd_yn;
	}



	public Member(String id, String pwd, String name, String nickname, String birth, String gender, String job,
			String email, String phone, String withd_yn, Date join_date, Date field, String time, String profile,
			String chatroom_no) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nickname = nickname;
		this.birth = birth;
		this.gender = gender;
		this.job = job;
		this.email = email;
		this.phone = phone;
		this.withd_yn = withd_yn;
		this.join_date = join_date;
		this.field = field;
		this.time = time;
		this.profile = profile;
		this.chatroom_no = chatroom_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWithd_yn() {
		return withd_yn;
	}

	public void setWithd_yn(String withd_yn) {
		this.withd_yn = withd_yn;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public Date getField() {
		return field;
	}

	public void setField(Date field) {
		this.field = field;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getChatroom_no() {
		return chatroom_no;
	}

	public void setChatroom_no(String chatroom_no) {
		this.chatroom_no = chatroom_no;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", nickname=" + nickname + ", birth=" + birth
				+ ", gender=" + gender + ", job=" + job + ", email=" + email + ", phone=" + phone + ", withd_yn="
				+ withd_yn + ", join_date=" + join_date + ", field=" + field + ", time=" + time + ", profile=" + profile
				+ ", chatroom_no=" + chatroom_no + "]";
	}
	
}

