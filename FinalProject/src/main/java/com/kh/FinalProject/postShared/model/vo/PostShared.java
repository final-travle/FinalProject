package com.kh.FinalProject.postShared.model.vo;

public class PostShared {
	private String share_id;
	private String post_type;
	private int post_no;
	private String user_id;
	
	public String getShare_id() {
		return share_id;
	}
	public void setShare_id(String share_id) {
		this.share_id = share_id;
	}
	public String getPost_type() {
		return post_type;
	}
	public void setPost_type(String post_type) {
		this.post_type = post_type;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "PostShared [share_id=" + share_id + ", post_type=" + post_type + ", post_no=" + post_no + ", user_id="
				+ user_id + "]";
	}
	public PostShared() {
		super();
	}
	
	
	
}
