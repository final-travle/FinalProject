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
	private String nicname;
	private String birth;
	private String gender;
	private String job;//
	private String email;
	private String phone;
	private String withd_yn;//
	private Date join_date;//
	private Date field;//
	private String time;
	
	
	
	public Member(String id, String pwd, String name, String nicname, String birth, String gender, String job,
			String email, String phone, String withd_yn, Date join_date, Date field, String time) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nicname = nicname;
		this.birth = birth;
		this.gender = gender;
		this.job = job;
		this.email = email;
		this.phone = phone;
		this.withd_yn = withd_yn;
		this.join_date = join_date;
		this.field = field;
		this.time = time;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Member() {
		super();
	}
	public Member(String id, String pwd, String name, String nicname, String birth, String gender, String job,
			String email, String phone, String withd_yn) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nicname = nicname;
		this.birth = birth;
		this.gender = gender;
		this.job = job;
		this.email = email;
		this.phone = phone;
		this.withd_yn = withd_yn;
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
	public String getNicname() {
		return nicname;
	}
	public void setNicname(String nicname) {
		this.nicname = nicname;
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
	public Member(String id, String pwd, String name, String nicname, String birth, String gender, String job,
			String email, String phone, String withd_yn, Date join_date, Date field) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nicname = nicname;
		this.birth = birth;
		this.gender = gender;
		this.job = job;
		this.email = email;
		this.phone = phone;
		this.withd_yn = withd_yn;
		this.join_date = join_date;
		this.field = field;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", nicname=" + nicname + ", birth=" + birth
				+ ", gender=" + gender + ", job=" + job + ", email=" + email + ", phone=" + phone + ", withd_yn="
				+ withd_yn + ", join_date=" + join_date + ", field=" + field + ", time=" + time + "]";
	}
	
	
	
}

