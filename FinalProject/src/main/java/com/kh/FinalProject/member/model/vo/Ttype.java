package com.kh.FinalProject.member.model.vo;

public class Ttype {
	private String id;
	private String sye;
	public Ttype(String id, String sye) {
		super();
		this.id = id;
		this.sye = sye;
	}
	public Ttype() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSye() {
		return sye;
	}
	public void setSye(String sye) {
		this.sye = sye;
	}
	@Override
	public String toString() {
		return "Ttype [id=" + id + ", sye=" + sye + "]";
	}
	
}

