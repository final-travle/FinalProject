package com.kh.FinalProject.member.model.vo;



public class Time {
	private String id;
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
		return "Time [id=" + id + ", time=" + time + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	
	

}
