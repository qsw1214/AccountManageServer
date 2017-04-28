package com.accountmanage.network.util;

public enum SmsSendType {

	SMS1003("获取验证码短信发送","HQYZM"),
	SMS8005("商户线下收款通知","XXSK"),
	FHTZ("产地订单发货通知","FHTZ"),
	CZCG("充值成功短信发送","CZCG");
	
	private String code;
	private String message;
	
	private SmsSendType(String message,String code){
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
