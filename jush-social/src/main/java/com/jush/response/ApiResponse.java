package com.jush.response;

public class ApiResponse {

	private String messageString;
	private boolean status;
	
	
	public ApiResponse() {
		
	}
	
	
	public ApiResponse(String messageString, boolean status) {
		super();
		this.messageString = messageString;
		this.status = status;
	}
	public String getMessageString() {
		return messageString;
	}
	public void setMessageString(String messageString) {
		this.messageString = messageString;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
}
