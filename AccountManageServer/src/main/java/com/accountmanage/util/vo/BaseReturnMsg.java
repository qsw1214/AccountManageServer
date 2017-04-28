package com.accountmanage.util.vo;

public class BaseReturnMsg {
	
	private boolean success = true;
	private String message;
	
	public BaseReturnMsg(){
		
	}
	public BaseReturnMsg(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
