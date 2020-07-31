package com.kh.FinalProject.member.model.vo;



public class Time {
	private String id;
	private int logintime;
	private int time;
	public Time(String id, int time) {
		super();
		this.id = id;
		this.time = time;
	}
	public Time() {
		super();
	}
	@Override
	public String toString() {
		return "Time [id=" + id + ", logintime=" + logintime + ", time=" + time + "]";
	}
	public String getId() {
		return id;
	}
	public int getLogintime() {
		return logintime;
	}
	public int getTime() {
		return time;
	}
	public Time(String id, int logintime, int time) {
		super();
		this.id = id;
		this.logintime = logintime;
		this.time = time;
	}
	
	
	

}
