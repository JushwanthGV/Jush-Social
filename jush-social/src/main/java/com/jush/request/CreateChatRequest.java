package com.jush.request;




public class CreateChatRequest {
	
	private Integer userid;
	
	public CreateChatRequest() {
		// TODO Auto-generated constructor stub
	}
	

	public CreateChatRequest(Integer userid) {
		super();
		this.userid = userid;
	}
	
	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	

	
	
}
